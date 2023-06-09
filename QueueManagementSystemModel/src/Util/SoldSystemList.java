package Util;

import java.util.HashMap;
import java.util.Map;

public class SoldSystemList {
    private static final HashMap<Integer, SystemU> systemArrayList = new HashMap<>();

    public static void incrementYear(){
        for(Map.Entry<Integer, SystemU> set: systemArrayList.entrySet()){
            set.getValue().increaseUseYear();
        }
    }

    public static void addNewSystem(SystemU systemU){
        systemArrayList.put(systemU.getInstanceNumber(), systemU);
    }

    public static String getSystemDescription(int i){
        SystemU output = systemArrayList.get(i);
        if(output == null) return "No such Product ID";
        return output.seeProductDescription();
    }

    public static String getCost(int i){
        SystemU output = systemArrayList.get(i);
        if(output == null) return "No such Product ID";
        return Double.toString(output.getCost());
    }
}
