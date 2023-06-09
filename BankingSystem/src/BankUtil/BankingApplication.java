package BankUtil;

import Users.Accounts.AccountType;

import java.util.Scanner;

public class BankingApplication {
    public static AccountType stringToAccountType(String accountType){
        if(accountType.equalsIgnoreCase("Student")){
            return AccountType.STUDENT;
        } else if(accountType.equalsIgnoreCase("Savings")){
            return AccountType.SAVINGS;
        }else if(accountType.equalsIgnoreCase("Fixed_Deposit")){
            return AccountType.FIXED_DEPOSIT;
        }else if(accountType.equalsIgnoreCase("Loan")){
            return AccountType.LOAN;
        }else{
            return AccountType.UNKNOWN;
        }
    }

    public static void main(String[] args) {
        System.out.printf(BankingSystem.startBankingSystem(1000000));
        System.out.println("\n");
        Scanner sc = new Scanner(System.in);
        String currentAccount = null;
        String currentEmployee = null;
        while(true){
            String str = sc.nextLine();
            String[] tokens = str.split(" ");
            String command = tokens[0];
            if(command.equalsIgnoreCase("CREATE")){
                String username = tokens[1];
                String accountTypeStr = tokens[2];
                AccountType accountType = stringToAccountType(accountTypeStr);
                if(accountType == AccountType.UNKNOWN){
                    System.out.println("Invalid Account Type");
                    continue;
                }
                float amount = Float.parseFloat(tokens[3]);
                String returnMsg = BankingSystem.CreateAccount(accountType, username, amount);
                if(BankingSystem.isAccountActive(username)){
                    currentAccount = username;
                }else{
                    currentAccount = null;
                }
                System.out.println(returnMsg);
            }
            else if (command.equalsIgnoreCase("DEPOSIT")) {
                if(currentAccount == null){
                    System.out.println("No active account user");
                    continue;
                }

                float amount = Float.parseFloat(tokens[1].replace(",", ""));
                System.out.println(BankingSystem.Deposit(currentAccount, amount));
            }
            else if (command.equalsIgnoreCase("WITHDRAW")) {
                if(currentAccount == null){
                    System.out.println("No active account user");
                    continue;
                }
                float amount = Float.parseFloat(tokens[1].replace(",", ""));
                System.out.println(BankingSystem.Withdraw(currentAccount, amount));
            }
            else if (command.equalsIgnoreCase("REQUEST")) {
                if(currentAccount == null){
                    System.out.println("No active account user");
                    continue;
                }
                float amount = Float.parseFloat(tokens[1].replace(",", ""));
                System.out.println(BankingSystem.Request(currentAccount, amount));
            }
            else if (command.equalsIgnoreCase("QUERY")) {
                if(currentAccount == null){
                    System.out.println("No active account user");
                    continue;
                }
                System.out.println(BankingSystem.Query(currentAccount));
            }
            else if (command.equalsIgnoreCase("ANALYZE")) {
                System.out.println(BankingSystem.SeeAccountList());
                System.out.println(BankingSystem.SeeEmployeeList());
                System.out.println(BankingSystem.seeTransactionHistory());
                System.out.println(BankingSystem.getInternalFund() + "\n");
                BankingSystem.seeLoanRequest();
                System.out.println("\n");
            }
            else if (command.equalsIgnoreCase("CLOSE")) {
                if(currentAccount == null && currentEmployee == null){
                    System.out.println("No active user");
                    continue;
                }else if (currentAccount != null){
                    System.out.println(BankingSystem.Logout(currentAccount));
                }else{
                    System.out.println(BankingSystem.Logout(currentEmployee));
                }
                System.out.println("\n");
                currentAccount = null;
                currentEmployee = null;
            }
            else if (command.equalsIgnoreCase("OPEN")) {
                String username = tokens[1];
                if(currentAccount != null || currentEmployee != null){
                    System.out.println("Already active user");
                    continue;
                }
                System.out.println(BankingSystem.Login(username));
                if(BankingSystem.isEmployeeActive(username)){
                    currentEmployee = username;
                }else if(BankingSystem.isAccountActive(username)){
                    currentAccount = username;
                }
            }
            else if (command.equalsIgnoreCase("LOOKUP")){
                if(currentEmployee == null){
                    System.out.println("No active employee user");
                    continue;
                }
                String username = tokens[1];
                System.out.println(BankingSystem.Lookup(currentEmployee, username));
            }
            else if (command.equalsIgnoreCase("APPROVE")){
                if(!tokens[1].equalsIgnoreCase("LOAN")){
                    System.out.println("Command not recognized");
                    System.out.println("\n");
                }
                if(currentEmployee == null){
                    System.out.println("No active employee user");
                    continue;
                }
                System.out.println(BankingSystem.ApproveLoan(currentEmployee));
            }
            else if (command.equalsIgnoreCase("CHANGE")){
                if(currentEmployee == null){
                    System.out.println("No active employee user");
                    continue;
                }
                String accountTypeStr = tokens[1];
                AccountType accountType = stringToAccountType(accountTypeStr);
                float newInt = Float.parseFloat(tokens[2].replace(",", ""));
                System.out.println(BankingSystem.ChangeIntRate(currentEmployee, accountType, newInt));
            }
            else if (command.equalsIgnoreCase("SEE")){
                if(currentEmployee == null){
                    System.out.println("No active employee user");
                    continue;
                }
                System.out.println(BankingSystem.See(currentEmployee));
            }
            else if(command.equalsIgnoreCase("INC")){
                System.out.println(BankingSystem.increment());
                System.out.println("\n");
            }
            else if (command.equalsIgnoreCase("Q")) {
                break;
            } else {
                System.out.println("Command not recognized");
                System.out.println("\n");
            }
        }

    }
}
