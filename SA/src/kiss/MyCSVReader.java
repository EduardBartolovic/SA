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
        int letter = reader.read();
        
        if(letter < 0)
            throw new IllegalArgumentException("text should not be empty");
        
        while( letter > 0) {
            
            if(letter == '\\'){
                final int nextLetter = reader.read();
                
                if(nextLetter == '\r'){
                    reader.read(); // for \n
                
                }else{
                    allData += '\\';
                    allData += (char)nextLetter;
                }
            }else{
                allData += (char)letter;
            }
            
            letter = reader.read();
        }
        
        if(allData.charAt(allData.length()-1) != '\n')
            throw new IllegalArgumentException("File ends not with \\r\\n ");
        
        final char[] dataArray = allData.toCharArray(); 
        
        final String[][] csvText = build2DArray(dataArray);
        
        for (Character c: dataArray) {
            if (c == '\n') {
                csvText[heightCounter] = toStringArray(cell);
             
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
        
        

        for (Character letter : dataArray) {
            
            if (letter == '\n') {
                arrayHeight++;
            }
            
        }
        
        final String[][] csvText = new String[arrayHeight][1];
        return csvText;
    }
    
    private String[] toStringArray(String line) {
        int cellCounter = 1;
        int counter = 0;
        String word = "";
        
        
        boolean flagForBackSlash = false;
        for (int i = 0; i < line.length(); i++){
            final char letter = line.charAt(i);
            
            if(letter == ',' && !flagForBackSlash){
                cellCounter++;
            }else if(letter == '\\'){
                flagForBackSlash = !flagForBackSlash;
            }else{
                flagForBackSlash = false;
            }
            
        }
        
        final String[] retArr = new String[cellCounter];
        
        for (int i = 0; i < line.length(); i++){
 
            final char letter = line.charAt(i);
            
            if(letter == '\\'){
                i++;
                char nextLetter = line.charAt(i);
                if(nextLetter == ','){
                    word += ',';
                }else if(nextLetter == '\\'){
                    word += '\\';
                }else{
                    word += '\\';
                    word += nextLetter;
                }
                
            }else{
                if (letter == ',' || letter == '\r') {
                    retArr[counter] = word;
                    counter++;
                    word = "";
                } else {
                    word += line.charAt(i);
                }
            }
            
            
        }
        return retArr;
    }
    
   
}

