package Users.Employee;
import BankUtil.InterestType;
import BankingError.AccountingError;
import BankingError.TransactionError;
import Users.Accounts.AccountType;
import Users.IBankingUser;

public abstract class Employee implements IBankingUser {
    protected String employeeName;
    protected boolean isActive;

    @Override
    public void login(){
        isActive = true;
    }

    public void logout(){
        isActive = false;
    }

    public abstract float lookup(String accountName) throws AccountingError;
    public abstract void approveLoan() throws TransactionError, AccountingError;
    public abstract void changeInterestRate(AccountType accountType, InterestType interestType, float newInterest) throws AccountingError;
    public abstract float seeInternalFund() throws AccountingError;
    public abstract boolean loanAvailable();

    public boolean isActive(){
        return isActive;
    }
}
