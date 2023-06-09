import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        while(true) {
            IntegerTildaSum integerTildaSum = new TildaToSpace();
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Filename: ");
            String str = sc.nextLine();
            if(str.equalsIgnoreCase("Q")) break;
            System.out.println("Sum: " + integerTildaSum.giveSumTilda(str));
        }
    }
}
