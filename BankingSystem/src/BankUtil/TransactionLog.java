package BankUtil;

import java.util.ArrayList;

public class TransactionLog {
    private static ArrayList<String> Ledger = new ArrayList<>();
    public static void addEntry(String entry){
        Ledger.add(entry);
    }
    
    public static String see(){
        return Ledger.toString();
    }
}
