
package kiss;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

/**
 *
 * @author Felix Peither, Eduard Bartolovic
 */
public class Main {
    
    public static final String LOCATION = "C:\\Users\\Edo\\Documents\\NetBeansProjects\\SA\\SA\\test\\kiss\\";
    //public static final String LOCATION = "C:\\Users\\Computer\\Documents\\NetBeansProjects\\SA\\SA\\test\\kiss\\";
    
    private static final String FILE = LOCATION+"CSVTestFile1.txt";
    
    public static void main(String...args) throws FileNotFoundException, IOException {
        Reader TestReader = new FileReader(FILE);
        MyCSVReader csvReader = new MyCSVReader();
        String data = "";
        for (int letter = TestReader.read(); letter > 0; letter = TestReader.read()) {
            data += (char)letter;
            System.out.println(letter);
            System.out.println("HAllo");
        }

        Reader reader = new FileReader(FILE);
        String[][] csvTextAsArray = csvReader.read(reader);
        System.out.println(data);
        System.out.print(Arrays.toString(csvTextAsArray));

    }
}
