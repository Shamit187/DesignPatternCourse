package BankUtil;

import BankingError.TransactionError;
import Users.Accounts.Account;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LoanRequestManager {
    private static HashMap<Account, Float> RequestList = new HashMap<>();

    public static void entryRequest(Account account, float RequestedLoan) throws TransactionError {
        if(RequestList.containsKey(account)){
            throw new TransactionError("Loan Request already exist for this user");
        }else{
            RequestList.put(account, RequestedLoan);
        }
    }

    //Temporary Code
    public static void seeAllRequest(){
        for(Map.Entry<Account, Float> entry : RequestList.entrySet()){
            Account account = entry.getKey();
            float loan = entry.getValue();
            System.out.println(account.getAccountName() + " requested " + loan + "\n");
        }
    }

    public static void acceptAllRequest() throws TransactionError {
        Iterator<Map.Entry<Account, Float>> it = RequestList.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Account, Float> entry = it.next();
            Account account = entry.getKey();
            float loan = entry.getValue();
            if(loan > BankingSystem.getInternalFund()){
                throw new TransactionError("Internal Fund in not sufficient");
            }
            TransactionLog.addEntry(account.getAccountName() + " got " + loan + "$ of loan");
            account.acceptLoan(loan);
            BankingSystem.decreaseInternalFund(loan);
            System.out.println("Loan for " + account.getAccountName() + " approved");
            it.remove();
        }
    }

    public static boolean isEmpty() {
        return RequestList.isEmpty();
    }
}
