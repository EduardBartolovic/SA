/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiss;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author Felix Peither, Eduard Bartolovic
 */
public class main {
    
    private static final String FILE = "C:\\Users\\Computer\\Documents\\NetBeansProjects\\SA\\SA\\test\\kiss\\CSVTestFile1.txt";
    
    public static void main(String...args) {
        try {
            FileReader TestReader = new FileReader(FILE);
            MyCSVReader csvReader = new MyCSVReader();
            String data = "";
            for (int letter = TestReader.read(); letter < 0; letter = TestReader.read()) {
                data += (char)letter;
            }
            
            FileReader reader = new FileReader(FILE);
            String[][] csvTextAsArray = csvReader.read(reader);
            System.out.println(data);
            System.out.print(Arrays.toString(csvTextAsArray));
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
            System.out.println("FNFE was thrown");
        } catch (IOException ioe) {
            System.out.println("IOE was thrown");
        }
    }
}
