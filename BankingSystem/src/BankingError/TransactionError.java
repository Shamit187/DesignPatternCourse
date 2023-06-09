package BankingError;

public class TransactionError extends Exception{
    public TransactionError(String errorMsg){
        super(errorMsg);
    }
}
