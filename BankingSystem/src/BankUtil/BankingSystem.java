package BankUtil;

import BankingError.AccountingError;
import BankingError.TransactionError;
import Users.Accounts.*;
import Users.Employee.*;

import java.text.NumberFormat;
import java.util.Hashtable;

public class BankingSystem {
    private static double internalFund = 1000000;
    public static double getInternalFund(){
        return internalFund;
    }

    public static void decreaseInternalFund(float amount){
        internalFund -= amount;
    }

    public static void increaseInternalFund(float amount){
        internalFund += amount;
    }
    public static Hashtable<String, Account> accountList = new Hashtable<>();
    public static Hashtable<String, Employee> employeeList = new Hashtable<>();

    public static String startBankingSystem(double startingFund){
        internalFund = startingFund;
        createEmployee(EmployeeType.MANAGING_DIRECTOR, "MD");
        createEmployee(EmployeeType.OFFICER, "O1");
        createEmployee(EmployeeType.OFFICER, "O2");
        createEmployee(EmployeeType.CASHIER, "C1");
        createEmployee(EmployeeType.CASHIER, "C2");
        createEmployee(EmployeeType.CASHIER, "C3");
        createEmployee(EmployeeType.CASHIER, "C4");
        createEmployee(EmployeeType.CASHIER, "C5");
        return "Bank Created; MD, O1, O2, C1, C2, C3, C4, C5 created";
    }

    private static void createEmployee(EmployeeType employeeType, String employeeName){
        if(employeeType == EmployeeType.MANAGING_DIRECTOR){
            ManagingDirector managingDirector = new ManagingDirector(employeeName);
            employeeList.put(employeeName, managingDirector);
        }else if(employeeType == EmployeeType.CASHIER){
            Cashier cashier = new Cashier(employeeName);
            employeeList.put(employeeName, cashier);
        }else if(employeeType == EmployeeType.OFFICER){
            Officer officer= new Officer(employeeName);
            employeeList.put(employeeName, officer);
        }
    }

    private static void accountCreator(AccountType accountType, String accountName, float initAmount) throws AccountingError, TransactionError {
        if(accountList.containsKey(accountName)){
            throw new AccountingError("Account Name Already Exists");
        }
        if(accountType == AccountType.SAVINGS){
            SavingsAccount account = new SavingsAccount(accountName, initAmount);
            accountList.put(accountName, account);
        }else if (accountType == AccountType.STUDENT) {
            StudentAccount account = new StudentAccount(accountName, initAmount);
            accountList.put(accountName, account);
        }else if (accountType == AccountType.LOAN) {
            LoanAccount account = new LoanAccount(accountName, initAmount);
            accountList.put(accountName, account);
        }else if (accountType == AccountType.FIXED_DEPOSIT) {
            FixedDepositAccount account = new FixedDepositAccount(accountName, initAmount);
            accountList.put(accountName, account);
        }
    }

    public static String CreateAccount(AccountType accountType, String accountName, float initAmount){
        try{
            accountCreator(accountType, accountName, initAmount);
        } catch (AccountingError | TransactionError e) {
            return e.getMessage();
        }
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        Login(accountName);
        if(accountType == AccountType.SAVINGS){
            return "Saving Account for " + accountName + " Created; " + "initial balance " + formatter.format(initAmount);
        }else if (accountType == AccountType.STUDENT) {
            return "Student Account for " + accountName + " Created; " + "initial balance " + formatter.format(initAmount);
        }else if (accountType == AccountType.LOAN) {
            return "Loan Account for " + accountName + " Created; " + "initial loan " + formatter.format(initAmount);
        }else if (accountType == AccountType.FIXED_DEPOSIT) {
            return "Fixed Deposit Account for " + accountName + " Created; " + "initial balance " + formatter.format(initAmount);
        }
        return "Error";
    }

    public static boolean isAccountActive(String userName){
        if(!accountList.containsKey(userName)){
            return false;
        }if(accountList.get(userName).isActive()){
            return true;
        }return false;
    }

    public static String Login(String userName){
        if(accountList.containsKey(userName)){
            Account currentAccount = accountList.get(userName);
            currentAccount.login();
            return "Welcome back, " + userName;
        }else if(employeeList.containsKey(userName)){
            Employee currentEmployee = employeeList.get(userName);
            currentEmployee.login();
            String returnString = userName + " active";
            if(currentEmployee.loanAvailable()){
                returnString += ", there are loan approvals pending";
            }
            return returnString;
        }else{
            return "No Account with such name";
        }
    }

    public static String Logout(String userName){
        if(userName == null){
            return "Account already logged out";
        }
        if(accountList.containsKey(userName)) {
            Account currentAccount = accountList.get(userName);
            currentAccount.logout();
            return "Transaction closed for " + userName;
        }else if(employeeList.containsKey(userName)){
            Employee currentEmployee = employeeList.get(userName);
            currentEmployee.logout();
            return "Operation for " + userName + " closed";
        }else{
            return "No Account with such name";
        }
    }

    public static String Deposit(String userName, float amount){
        if(!accountList.containsKey(userName)){
            return "No Account with such name";
        }
        Account currentAccount = accountList.get(userName);
        try {
            currentAccount.deposit(amount);
        } catch (TransactionError e) {
            return "Invalid Transaction";
        }
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(amount) + " deposited; current balance " + formatter.format(currentAccount.getCurrentDeposit()) + "";
    }

    public static String Withdraw(String userName, float amount){
        if(!accountList.containsKey(userName)){
            return "No Account with such name";
        }
        Account currentAccount = accountList.get(userName);
        try {
            currentAccount.withdraw(amount);
        } catch (TransactionError e) {
            return "Invalid Transaction";
        }
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(amount) + "$ withdrawn; current balance " + formatter.format(currentAccount.getCurrentDeposit()) + "$";
    }

    public static String Request(String userName, float amount){
        if(!accountList.containsKey(userName)){
            return "No Account with such name";
        }
        Account currentAccount = accountList.get(userName);
        try {
            currentAccount.requestLoan(amount);
        } catch (TransactionError e) {
            return "Invalid Transaction";
        }
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return "Loan request successful; sent for approval";
    }

    public static String Query(String userName){
        if(!accountList.containsKey(userName)){
            return "No Account with such name";
        }
        Account currentAccount = accountList.get(userName);
        return currentAccount.queryDeposit();
    }

    public static String SeeAccountList(){
        return accountList.toString();
    }

    public static String SeeEmployeeList(){
        return employeeList.toString();
    }

    public static String seeTransactionHistory(){
        return TransactionLog.see();
    }

    public static void seeLoanRequest(){
        LoanRequestManager.seeAllRequest();
    }

    public static boolean isEmployeeActive(String userName){
        if(!employeeList.containsKey(userName)){
            return false;
        }if(employeeList.get(userName).isActive()){
            return true;
        }return false;
    }

    public static String ApproveLoan(String userName){
        if(!employeeList.containsKey(userName)){
            return "No Employee with such name";
        }
        Employee currentAccount = employeeList.get(userName);
        try{
            currentAccount.approveLoan();
        } catch (AccountingError e) {
            return e.getMessage();
        } catch (TransactionError e) {
            return "Invalid Transaction";
        }
        return "";
    }

    public static String ChangeIntRate(String userName, AccountType accountType, float newIntRate){
        if(!employeeList.containsKey(userName)){
            return "No Employee with such name";
        }
        Employee currentAccount = employeeList.get(userName);
        try{
            currentAccount.changeInterestRate(accountType, InterestType.LOAN, newIntRate);
        }catch (AccountingError e) {
            return e.getMessage();
        }
        return "Interest Rate Changed of " + accountType.name() + " to " + newIntRate;
    }

    public static String See(String userName){
        if(!employeeList.containsKey(userName)){
            return "No Employee with such name";
        }
        Employee currentAccount = employeeList.get(userName);
        double internalFund;
        try{
            internalFund = currentAccount.seeInternalFund();
        }catch (AccountingError e) {
            return e.getMessage();
        }
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return "Remaining Internal Fund of Bank " + formatter.format(internalFund);
    }

    public static String Lookup(String userName, String accountName){
        if(!employeeList.containsKey(userName)){
            return "No Employee with such name";
        }
        Employee currentAccount = employeeList.get(userName);
        double balance;
        try {
            balance = currentAccount.lookup(accountName);
        } catch (AccountingError e) {
            return e.getMessage();
        }
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return accountName + "'s current Balance " + formatter.format(balance);
    }

    public static String increment(){
        accountList.forEach((name, account) -> {
            account.incrementYear();
        });
        return "1 year passed";
    }

}
