package Users.Employee;

import BankUtil.BankingSystem;
import BankUtil.InterestType;
import BankUtil.LoanRequestManager;
import BankingError.AccountingError;
import BankingError.TransactionError;
import Users.Accounts.*;

public class ManagingDirector extends Employee{
    public ManagingDirector(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public float lookup(String accountName) throws AccountingError {
        Account account = BankingSystem.accountList.get(accountName);
        if(account == null){
            throw new AccountingError("Account doesn't exist");
        }
        return account.getCurrentDeposit();
    }

    @Override
    public void approveLoan() throws TransactionError {
        LoanRequestManager.acceptAllRequest();
    }

    @Override
    public void changeInterestRate(AccountType accountType, InterestType interestType, float newInterest) throws AccountingError {
        if(accountType == AccountType.STUDENT){
            StudentAccount.changeInterestRate(interestType, newInterest);
        }else if(accountType == AccountType.SAVINGS){
            SavingsAccount.changeInterestRate(interestType, newInterest);
        }else if(accountType == AccountType.FIXED_DEPOSIT){
            FixedDepositAccount.changeInterestRate(interestType, newInterest);
        }else if(accountType == AccountType.LOAN){
            LoanAccount.changeInterestRate(interestType, newInterest);
        }else{
            throw new AccountingError("Invalid accountType");
        }
    }

    @Override
    public float seeInternalFund() {
        return (float) BankingSystem.getInternalFund();
    }

    @Override
    public boolean loanAvailable() {
        return !LoanRequestManager.isEmpty();
    }
}
