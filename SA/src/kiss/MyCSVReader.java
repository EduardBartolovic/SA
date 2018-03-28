package kiss;

import edu.hm.cs.rs.arch18.a01_kiss.CSVReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Diese Klasse konvertiert Text im CSV Format in ein 
 * zweidimensionales String Array. Es Implementiert das Interface
 * CSVReader von Prof. Dr. Schiedermeier der FK 07 der Hochschule Muenchen.
 * 
 * @author Felix Peither, Eduard Bartolovic
 */
public class MyCSVReader implements CSVReader{

    /**
     * Die Methode read liest einen Text in einem vereinfachten CSV-Format
     * von einem Reader und gibt die Zeilen und Spalten in einem neuen,
     * zweidimensionalen String-Array zurueck. 
     * 
     * @param reader
     * @return csvText
     * @throws IOException
     * @throws IllegalArgumentException 
     */
    @Override
    public String[][] read(Reader reader) throws IOException, IllegalArgumentException {   
        
//        char[] dataArray = new char[4];
        
        final BufferedReader bufReader = new BufferedReader(reader);
        
        int heightCounter = 0; // var to save number of lines
        String allData = "";   // whole file will be saved to this string
//        int letter = bufReader.read(); 
        String line = bufReader.readLine();
        
//        if(letter < 0)  //check if file is empty
//            throw new IllegalArgumentException("text should not be empty");
//        
//        //read the whole file
//        while(line != null) {  
//            
//            if(letter == '\\'){               
//                allData += '\\';
//                allData += (char)bufReader.read();
//            }else{
//                if(letter == '\n')  // to count the number of lines
//                    heightCounter++;
//                
//                allData += (char)letter;
//            }
//            letter = bufReader.read();
//        }

        if (line == null)
            throw new IllegalArgumentException("text should not be empty");
        
        while (line != null){
            
            heightCounter++;
            allData += line;
            line = bufReader.readLine();
        }
        
        if(allData.charAt(allData.length() - 1) != '\n') //check if file ends with enter
            throw new IllegalArgumentException("File ends not with \\n ");
        
        final char[] dataArray = allData.toCharArray(); 
        
        
        // Build the full 2d array 
//        final String[][] csvText = fillLines(dataArray, heightCounter);
        
        return fillLines(dataArray, heightCounter);
    }
    
    /**
     * Fuellt die zeilen des zwei dimensionalen Arrays mit
     * den eingelesenen zeilen.
     * 
     * @param dataArray Alles eingelesenen Zeilen als eindimensionales array
     * @param heightCounter hoehe des zweidimensionalen Arrays
     * @return gefuelltes String[][] Array
     */
    private String[][] fillLines(char[] dataArray, int heightCounter) {
        int lineCounter = 0;
        
        // allokate a big enough outer array
        final String[][] csvText = new String[heightCounter][0];
        
        String line = "";
        for (int counter = 0; counter < dataArray.length ; counter++) {
            final char character = dataArray[counter];
            
            if(character == '\\'){
                counter++;
                final char nextCharacter = dataArray[counter];
                line += character;
                line += nextCharacter;
            }else if (character == '\n') {
                // override the former 'line' with the accual line 
                // we read from the reader
                if (!line.isEmpty())
                    csvText[lineCounter] = toStringArray(line);
                lineCounter++;
                line = "";
            } else {
                line += character;
            }
        }
        
        return csvText;
    }
    
    /**
     * Aus einem String wird die momentane Zeile gebaut.
     * Die Worte werden an ',' getrennt.
     * 
     * @param line Die anzuschauende Zeile als String
     * @return Zeile als String[]
     */
    private String[] toStringArray(String line) {
        int cellCounter = 1;        
        
        boolean flagForBackSlash = false;
        for (int counter = 0; counter < line.length(); counter++){
            final char letter = line.charAt(counter);
            
            if(letter == ',' && !flagForBackSlash){
                cellCounter++;
            }else if(letter == '\\'){
                flagForBackSlash = !flagForBackSlash;
            }else{
                flagForBackSlash = false;
            }
            
        }
        
        final String[] retArr = new String[cellCounter];
        cellCounter = 0;
        String word = "";
        for (int counter = 0; counter < line.length(); counter++){
 
            final char letter = line.charAt(counter);
            
            if(letter == '\\'){
                counter++;           // to see whats the next letter after the\
                final char nextLetter = line.charAt(counter);
                word += nextLetter;
                
            }else if(letter == ',') {
                
                retArr[cellCounter] = word; // save the word into a cell
                cellCounter++;      //move to the next word
                word = "";          //reset the old word
                
            } else {
                word += line.charAt(counter);
            }
            
        }
        retArr[cellCounter] = word; // save the word into a cell
        
        return retArr;
    }
    
   
}

