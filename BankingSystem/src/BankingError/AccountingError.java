package BankingError;

public class AccountingError extends Exception{
    public AccountingError(String errorMsg){
        super(errorMsg);
    }
}
