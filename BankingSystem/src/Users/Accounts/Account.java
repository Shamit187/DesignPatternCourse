package Users.Accounts;

import java.text.NumberFormat;
import BankingError.AccountingError;
import BankingError.TransactionError;
import Users.IBankingUser;

public abstract class Account implements IBankingUser {

    protected String accountName;
    protected float currentDeposit;
    protected float currentLoan;
    protected int maturation;
    protected boolean isActive;

    @Override
    public void login() {
        this.isActive = true;
    }

    @Override
    public void logout() {
        this.isActive = false;
    }

    public abstract void deposit(float depositAmount) throws TransactionError;
    public abstract void withdraw(float withdrawAmount) throws TransactionError;
    public abstract void requestLoan(float requestedAmount) throws TransactionError;
    public abstract void payBackLoanWithDeposit() throws TransactionError;
    public abstract void incrementYear();
    public String getAccountName() {
        return accountName;
    }

    public void acceptLoan(float requestedLoan){
        currentLoan += requestedLoan;
        currentDeposit += requestedLoan;
    }

    public String queryDeposit(){
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        if(this.currentLoan == 0){
            return "Current Balance " + formatter.format(this.currentDeposit) + "";
        }
        return "Current Balance " + formatter.format(this.currentDeposit) + ", loan" + formatter.format(this.currentLoan);
    }

    public float getCurrentDeposit() {
        return currentDeposit;
    }

    public boolean isActive() {
        return isActive;
    }

    public float getCurrentLoan() {
        return currentLoan;
    }
}
