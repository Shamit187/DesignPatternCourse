package Users.Accounts;

import BankUtil.BankingSystem;
import BankUtil.InterestType;
import BankUtil.LoanRequestManager;
import BankUtil.TransactionLog;
import BankingError.TransactionError;

import java.text.NumberFormat;

public class SavingsAccount extends Account{
    private static float loanInterestRate = .1f;
    private static float depositInterestRate = .1f;

    public SavingsAccount(String accountName, float initialDeposit) throws TransactionError {
        this.accountName =  accountName;
        this.currentDeposit = 0;
        this.currentLoan = 0.0f;
        this.isActive = false;
        this.maturation = 0;
        deposit(initialDeposit);
    }

    @Override
    public void deposit(float depositAmount) throws TransactionError {
        //necessary initialization
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        //error handling
        if(depositAmount <= 0){
            throw new TransactionError("Deposit Amount can never be negative");
        }

        //pay off loan if available
        if(this.currentLoan > 0){
            float paidOff = this.currentLoan;
            this.currentLoan -= depositAmount;
            if(this.currentLoan < 0){ //deposit greater than loan
                TransactionLog.addEntry(this.accountName + " paid off " + formatter.format(depositAmount + this.currentLoan));
                BankingSystem.increaseInternalFund(paidOff);
                depositAmount = depositAmount - paidOff;
                this.currentLoan = 0;
            }else{ //deposit smaller than loan
                BankingSystem.increaseInternalFund(depositAmount);
            }
        }

        //rest amount to deposit
        this.currentDeposit += depositAmount;
        TransactionLog.addEntry(this.accountName + " deposited " + formatter.format(depositAmount));
    }

    @Override
    public void withdraw(float withdrawAmount) throws TransactionError {
        if(this.currentDeposit - withdrawAmount < 1000.0f){
            throw new TransactionError("Saving Users.Accounts.Account must have at least 1,000$ in balance");
        }
        this.currentDeposit -= withdrawAmount;
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        TransactionLog.addEntry(this.accountName + " withdraw " + formatter.format(withdrawAmount));
    }

    @Override
    public void requestLoan(float requestedAmount) throws TransactionError {
        if(requestedAmount > 10000.0f){
            throw new TransactionError("Maximum allowable loan for Savings Users.Accounts in 10,000$.");
        }else if(requestedAmount > BankingSystem.getInternalFund()){
            throw new TransactionError("Internal Fund not enough");
        }else{
            LoanRequestManager.entryRequest(this, requestedAmount);
        }
    }

    @Override
    public void payBackLoanWithDeposit() throws TransactionError {
        if(this.currentLoan > this.currentDeposit) throw new TransactionError("Not enough Money");
        else {
            BankingSystem.increaseInternalFund(currentLoan);
            currentDeposit -= currentLoan;
            currentLoan = 0;
        }
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        TransactionLog.addEntry(this.accountName + " paid back all the loans");
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
