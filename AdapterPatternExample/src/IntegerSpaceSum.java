import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
    Adaptee Class
    Takes integers seperated by space and gives summation
*/

public class IntegerSpaceSum {

    int giveSumSpace(String filename){
        try {
            File inputFile = new File(filename);
            Scanner myReader = new Scanner(inputFile);
            ArrayList<Integer> arrayList = new ArrayList<>();
            int sum = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] integers = data.split(" ");
                for(String x: integers)
                    arrayList.add(Integer.parseInt(x));
            }
            myReader.close();
            for(int x: arrayList)
                sum += x;
            return sum;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return 0;
    }
}
