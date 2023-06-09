package Users.Employee;

import BankUtil.BankingSystem;
import BankUtil.InterestType;
import BankUtil.LoanRequestManager;
import BankingError.AccountingError;
import BankingError.TransactionError;
import Users.Accounts.Account;
import Users.Accounts.AccountType;

public class Officer extends Employee{
    public Officer(String employeeName) {
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
        throw new AccountingError("You don't have permission for this operation");
    }

    @Override
    public float seeInternalFund() throws AccountingError {
        throw new AccountingError("You don't have permission for this operation");
    }

    @Override
    public boolean loanAvailable() {
        return !LoanRequestManager.isEmpty();
    }
}
