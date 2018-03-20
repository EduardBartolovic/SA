package kiss;

import edu.hm.cs.rs.arch18.a01_kiss.CSVReader;
import java.io.IOException;
import java.io.Reader;


public class MyCSVReader implements CSVReader{

    /**
     * Die Methode read liest einen Text in einem vereinfachten CSV-Format
     * von einem Reader und gibt die Zeilen und Spalten in einem neuen,
     * zweidimensionalen String-Array zurück. 
     * 
     * @param reader
     * @return csvText
     * @throws IOException
     * @throws IllegalArgumentException 
     */
    @Override
    public String[][] read(Reader reader) throws IOException, IllegalArgumentException {   
        final String[][] csvText = new String[1][1];
        String cell = "";
        String allData = "";
        int lengthCounter = 0;
        int widthCounter = 0;
        for (int letter = reader.read(); reader.read() < 0; letter = reader.read()) {
            allData = allData + (char)letter;
        }
        
        char[] dataArray = allData.toCharArray(); // new String[allData.length()];
        
        for (Character c: dataArray) {
            if (c != ',' && c != '\n') {
                cell += c;
            } else if (c == ',') {
                
            } else if (c == '\n') {
                
            }
        }
        return csvText;
    }
    
}
