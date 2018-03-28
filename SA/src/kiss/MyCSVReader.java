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
        
        final int fileSize = bufReader.read(data);
        
        if(fileSize == 0)
            throw new IllegalArgumentException("text should not be empty");
        
        String allData = "";   // whole file will be saved to this string
        while(data[0] > 0){
            allData += new String(data); 
            data = new char[LENGTHOFBUF];
            bufReader.read(data);
        }
        
        final char[] dataArray = allData.toCharArray(); 
        
        return fillLines(dataArray, testNumberOfLines(allData));
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
        
        
        // allokate a big enough outer array
        final String[][] csvText = new String[heightCounter][0];
        int lineCounter = 0;
        int commaCounter = 0;
        int startOfNextLine = 0;
        boolean flagForBackslash = false;
        for (int counter = 0; counter < dataArray.length ; counter++) {
            final char character = dataArray[counter];
            
            if(character == '\\'){
                
                flagForBackslash = !flagForBackslash;
                
            }else if(character == ',' && !flagForBackslash){
                
                commaCounter++;
                
            }else if(character == '\n' && !flagForBackslash) {
                
                final char[] line =  new char[counter - startOfNextLine +1];
                System.arraycopy(dataArray, startOfNextLine, line, 0, counter - startOfNextLine );
                startOfNextLine = counter+1;
                
                if(!new String(line).trim().isEmpty())
                    csvText[lineCounter] = toStringArray(line,commaCounter);
                
                lineCounter++;
                commaCounter = 0;
                flagForBackslash = false;
            }else{
                flagForBackslash = false;
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
    private String[] toStringArray(char[] line, int commaCount) {
        int cellCounter = commaCount+1;  //there is a minimum of one cell   
        line[line.length-1] = ',';

        final String[] csvLine = new String[cellCounter];
        cellCounter = 0;
        int startOfNextLine = 0;
        int backslashCount = 0;
        boolean flagForBackslash = false;
        for (int counter = 0; counter < line.length ; counter++) {
            final char character = line[counter];
            
            if(character == '\\'){
                
                if (!flagForBackslash)
                    backslashCount++;
                
                flagForBackslash = !flagForBackslash;

            }else if(character == ',' && !flagForBackslash) {
                
                final char[] word =  new char[counter - startOfNextLine ];
                System.arraycopy(line, startOfNextLine, word, 0, counter - startOfNextLine );
                startOfNextLine = counter+1;
                
                csvLine[cellCounter] = new String(removeBackSlashes(word, backslashCount));
                                
                cellCounter++;
                flagForBackslash = false;
                backslashCount = 0;
            }else{
                flagForBackslash = false;
            } 
            
        }
        
        return csvLine;
    }
    
    private int testNumberOfLines(String allData){
        
        int numberOfLines = 0;
        boolean flagForBackslash = false;
        boolean flagForEndLine = false;
        for(int counter = 0 ; counter < allData.length() ; counter++){
            
            final char letter = allData.charAt(counter);
            
            if(letter == '\\'){
                flagForBackslash = !flagForBackslash;
                flagForEndLine = false;
            } else if(letter == '\n' && !flagForBackslash){
                numberOfLines++;
                flagForEndLine = true;
            }else if(letter == 0){
                flagForBackslash = false;
            } else {
                flagForBackslash = false;
                flagForEndLine = false;
            }
        }
            
        if(!flagForEndLine)
            throw new IllegalArgumentException("File ends not with \\n ");
            
         return numberOfLines;  
         
    }
    
    /**
     * Removes all anacceptable backslashes from a word.
     * 
     * @param original the original word
     * @param backslashCount how many '\' to remove from a word
     * @return A word without backslashes
     */
    public char[] removeBackSlashes(char[] original, int backslashCount){
    final char[] result = new char[original.length - backslashCount];
    int resultIndex = 0;
    boolean flagForDoubleBackslash = false;
    
    for (Character c: original) {
        if (c != '\\'){
            result[resultIndex] = c;
            resultIndex++;
            flagForDoubleBackslash = false;
        } else if (flagForDoubleBackslash) {
            result[resultIndex] = c;
            resultIndex++;
            flagForDoubleBackslash = false;
        } else {
            flagForDoubleBackslash = true;
        }
    }
    
    return result;
    }
}

