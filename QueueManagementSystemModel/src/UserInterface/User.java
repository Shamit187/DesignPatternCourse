package UserInterface;

import Builder.EPackage;
import Builder.SystemBuilder;
import Product.CommSystem.ECommSystem;
import Util.SoldSystemList;
import Util.SystemU;

import java.util.Scanner;

public class User {
    static EPackage stringToPackage(String input){
        if(input.equalsIgnoreCase("DELUXE")){
            return EPackage.DELUXE;
        }else if(input.equalsIgnoreCase("OPTIMAL")){
            return EPackage.OPTIMAL;
        }else if(input.equalsIgnoreCase("POOR")){
            return EPackage.POOR;
        }else{
            return null;
        }
    }
    static ECommSystem stringToCommSystem(String input){
        if(input.equalsIgnoreCase("WIFI")){
            return ECommSystem.WIFIMODULE;
        }else if(input.equalsIgnoreCase("SIM")){
            return ECommSystem.SIMCARD;
        }else {
            return null;
        }
    }
    static String stringToCommand(String input){
        String[] tokens = input.split(" ");
        String command = tokens[0];
        if(command.equalsIgnoreCase("CREATE")){
            EPackage ePackage = stringToPackage(tokens[1]);
            ECommSystem eCommSystem = stringToCommSystem(tokens[2]);
            if(eCommSystem == null || ePackage == null) return "Wrong Input";
            int numberOfDisplay = Integer.parseInt(tokens[3]);
            if(numberOfDisplay < 0){
                return "Display Number must be greater than 0";
            }
            SystemU systemU = SystemBuilder.buildSystem(ePackage, numberOfDisplay, eCommSystem);
            String returnString = "System Built\n";
            returnString += systemU.seeProductDescription();
            return returnString;
        }else if(command.equalsIgnoreCase("SEE")){
            int id = Integer.parseInt(tokens[1]);
            return SoldSystemList.getSystemDescription(id);
        }else if(command.equalsIgnoreCase("COST")){
            int id = Integer.parseInt(tokens[1]);
            return SoldSystemList.getCost(id);
        } else if (command.equalsIgnoreCase("INC")) {
            SoldSystemList.incrementYear();
            return "Year Incremented";
        } else if(command.equalsIgnoreCase("CLOSE")){
            return null;
        } else {
            return "Wrong Input";
        }
        /*
          Comm1: System Creation:   Create  Deluxe  Wifi    2
          Comm2: See Description:   See     1
          Comm3: See Cost       :   Cost    1
          Comm4: Inc            :   INC
          Comm5: Close          :   CLOSE
        */
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            String str = sc.nextLine();
            String output = stringToCommand(str);
            if(output == null) break;
            System.out.println(output);
        }
    }
}
