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
        String cell = "";
        String allData = "";
        int heightCounter = 0;
        int widthCounter = 0; 
        
        for (int letter = reader.read(); reader.read() > 0; letter = reader.read()) {
            allData = allData + (char)letter;
        }
        
        char[] dataArray = allData.toCharArray(); // new String[allData.length()];
        
        final String[][] csvText = build2DArray(dataArray);
        
        for (Character c: dataArray) {
            if (c != ',' && c != '\n') {
                cell += c;
            } else if (c == ',') {
                csvText[heightCounter][widthCounter] = cell;
                widthCounter++;
            } else if (c == '\n') {
                heightCounter++;
                widthCounter = 0;
            }
        }
        return csvText;
    }
    
    private String[][] build2DArray(char[] dataArray) throws IOException {
        int arrayHeight = 0;
        int arrayWidth = 0;
        int maxWidth = 0;
        
        for (Character c: dataArray) {
            if (c == ',') {
                arrayWidth++;
                maxWidth = Math.max(maxWidth, arrayWidth);
            } else if (c == '\n') {
                arrayHeight++;
            }
        }
        
        final String[][] csvText = new String[arrayHeight][arrayWidth];
        return csvText;
    }
    
}
