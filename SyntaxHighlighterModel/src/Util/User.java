package Util;

import java.util.Scanner;

public class User {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.print("Enter Filename: ");
            String str = sc.nextLine();
            String output = Editor.parse(str);
            System.out.println(output);
            if(output.equals("")) break;
        }
    }
}
