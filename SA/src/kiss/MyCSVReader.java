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

    
    public static final int LENGTHOFBUF = 10000;
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
        
        final BufferedReader bufReader = new BufferedReader(reader);
        
        char[] data = new char[LENGTHOFBUF];
        
        bufReader.read(data);
        
        if(data[0] == 0)
            throw new IllegalArgumentException("text should not be empty");
        
        String allData = "";   // whole file will be saved to this string
        while(data[0] > 0){
            allData += new String(data); 
            data = new char[LENGTHOFBUF];
            bufReader.read(data);
        }
        
        
        int heightCounter = 0; // var to save number of lines
        boolean flagForBackslash = false;
        for(int counter = 0 ;  counter < allData.length() ; counter++){
            
            final char letter = allData.charAt(counter);
            
            if(letter == '\\'){
                flagForBackslash = !flagForBackslash;
            } else if(letter == '\n' && !flagForBackslash){
                flagForBackslash = false;
                heightCounter++;
            }else{
                flagForBackslash = false;
            }
        }
        
        final int positionOfLastElement = allData.trim().length();
        if (allData.charAt(positionOfLastElement) != '\n')
            throw new IllegalArgumentException("File ends not with \\n ");
        
        final char[] dataArray = allData.toCharArray(); 
        
        
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

