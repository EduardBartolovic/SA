package kiss;

import edu.hm.cs.rs.arch18.a01_kiss.CSVReader;
import java.io.IOException;
import java.io.Reader;


public class MyCSVReader implements CSVReader{
    
    public int height = 0;
    public int width = 0;
    public char[] dataArray;

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
//        int widthCounter = 0; 
        
        for (int letter = reader.read(); letter > 0; letter = reader.read()) {
            allData += (char)letter;
        }
        
        char[] dataArray = allData.toCharArray(); // new String[allData.length()];
        
        final String[][] csvText = build2DArray(dataArray);
        
        for (Character c: dataArray) {
            if (c == '\n') {
                csvText[heightCounter] = toStringArray(cell);
                
                for (String s: toStringArray(cell))
                    System.out.print(s);
                
                System.out.println("");
                
                heightCounter++;
                cell = "";
            } else if (c != '\n') {
                cell += c;
            }
        }
        
        return csvText;
    }
    
    private String[][] build2DArray(char[] dataArray) throws IOException {
        int arrayHeight = 0;
//        int arrayWidth = 0;
//        int maxWidth = 0;
        
        this.dataArray = dataArray;
        
        for (Character c: dataArray) {
            if (c == '\n') {
                arrayHeight++;
            }
        }
        
        final String[][] csvText = new String[arrayHeight][1];
        height = arrayHeight;
//        width = maxWidth;
        return csvText;
    }
    
    private String[] toStringArray(String line) {
        String[] retArr;
        int cellCounter = 1;
        int counter = 0;
        String word = "";
        
        for (int i = 0; i < line.length(); i++){
            if (line.charAt(i) == ',') {
                cellCounter++;
            }
        }
        
        retArr = new String[cellCounter];
        
        for (int i = 0; i < line.length(); i++){
            if (line.charAt(i) == ',') {
                retArr[counter] = word;
                counter++;
                word = "";
            } else {
                word += line.charAt(i);
            }
        }
        
//        word = word.substring(word.length() - 2);
        retArr[counter] = word;
//        
        return retArr;
    }
}
