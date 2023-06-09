package Users.Accounts;

import BankUtil.BankingSystem;
import BankUtil.InterestType;
import BankUtil.LoanRequestManager;
import BankUtil.TransactionLog;
import BankingError.TransactionError;

import java.text.NumberFormat;

public class LoanAccount extends Account{
    private static float loanInterestRate = .1f;
    private static float depositInterestRate = .05f;

    public LoanAccount(String accountName, float initialLoan) throws TransactionError {
        if(initialLoan < 0.0f) throw new TransactionError("Loan can not be negative");
        this.accountName =  accountName;
        this.currentDeposit = 0;
        this.currentLoan = initialLoan;
        this.isActive = false;
        this.maturation = 0;
    }

    @Override
    public void deposit(float depositAmount) throws TransactionError {
        //necessary init
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        //error handling
        if(depositAmount <= 0){
            throw new TransactionError("Deposit Amount can never be negative");
        }

        //pay off loan
        TransactionLog.addEntry(this.accountName + " deposited " + formatter.format(depositAmount));
        float paidOff = this.currentLoan;
        if(this.currentLoan > 0){
            this.currentLoan -= depositAmount;
            if(this.currentLoan < 0){
                BankingSystem.increaseInternalFund(paidOff);
                depositAmount = depositAmount - paidOff;
                this.currentLoan = 0;
            }else{
                BankingSystem.increaseInternalFund(depositAmount);
            }
        }
        TransactionLog.addEntry(this.accountName + " got " + formatter.format(depositAmount) + " back");
    }

    @Override
    public void withdraw(float withdrawAmount) throws TransactionError {
        throw new TransactionError("Loan Users.Accounts.Account can't be withdrawn");
    }

    @Override
    public void requestLoan(float requestedAmount) throws TransactionError {
        if(requestedAmount != this.currentLoan * 0.05f ){
            throw new TransactionError("Maximum allowable loan for Student Users.Accounts in 5% of current loan.");
        }else{
            LoanRequestManager.entryRequest(this, requestedAmount);
        }
    }

    @Override
    public void payBackLoanWithDeposit() throws TransactionError {
        throw new TransactionError("Nothing to pay back");
    }

    public void requestLoan() throws TransactionError {
        if(this.currentLoan * 0.05f > BankingSystem.getInternalFund()){
            throw new TransactionError("Internal Fund not enough");
        }
        LoanRequestManager.entryRequest(this, this.currentLoan * 0.05f);
    }

    @Override
    public void incrementYear() {
        float incrementAmount = this.currentDeposit * depositInterestRate - this.currentLoan * loanInterestRate;
        this.currentDeposit += (this.currentDeposit * depositInterestRate - this.currentLoan * loanInterestRate);
        if(this.currentDeposit <= 0){
            this.currentLoan += (-this.currentDeposit);
            this.currentDeposit = 0;
        }else{
            BankingSystem.decreaseInternalFund(incrementAmount);
        }
    }

    public static void changeInterestRate(InterestType interestType, float newInterestRate){
        if(interestType == InterestType.DEPOSIT){
            depositInterestRate = newInterestRate;
        }else{
            loanInterestRate = newInterestRate;
        }
    }
}
