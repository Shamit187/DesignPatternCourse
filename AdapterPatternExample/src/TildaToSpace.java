import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TildaToSpace extends IntegerSpaceSum implements IntegerTildaSum{
    static String modifiedFileName = "modified.txt";

    @Override
    public int giveSumTilda(String filename) {
        try {

            File modifiedFile = new File(modifiedFileName);
            modifiedFile.createNewFile();//do nothing if filename already exists
            FileWriter myWriter = new FileWriter(modifiedFileName);

            File inputFile = new File(filename);
            Scanner myReader = new Scanner(inputFile);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                data = data.replace('~', ' ');
                myWriter.write(data);
                myWriter.write(' ');
            }

            myWriter.close();

            return giveSumSpace(modifiedFileName);

        }catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return 0;
    }
}
