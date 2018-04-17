package edu.hm.peither_bartolov.a04_resiliance;

import edu.hm.cs.rs.arch.a01_kiss.CSVReader;
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
public class MyCSVReaderDeluxe implements CSVReader{

    /** 
     * this is a constant for the length of the char array in the buffered reader.
     */
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
        int fileSize = bufReader.read(data);// read data out of file 
        
        if(fileSize == 0) 
            throw new IllegalArgumentException("text should not be empty");
        
        final StringBuilder allData = new StringBuilder();   // whole file will be saved to this string
        while(fileSize > 0){
            allData.append(new String(data)); 
            data = new char[LENGTHOFBUF];
            fileSize = bufReader.read(data);
        }
        
        final char[] dataArray = new char[allData.length()];
        allData.getChars(0, allData.length(), dataArray, 0);
        
        return fillLines(dataArray, testNumberOfLines(dataArray)); 
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
        int lineCounter = 0;                                //to keep track which line needs to be filled
        int commaCounter = 0;                               //keep track how many commas are in one line
        int startOfNextLine = 0;                            //keep track where evry line starts 
        boolean flagForBackslash = false;                   //to remember that the last element was a '\'
        boolean flagForQuotes = false;
        for (int counter = 0; counter < dataArray.length ; counter++) { 
            final char character = dataArray[counter];
            
            if(character == '"' ){
                
                flagForQuotes = !flagForQuotes; 
                
                flagForBackslash = false;
                
            }else if(character == '\\' ){
                
                flagForBackslash = !flagForBackslash; 
                
            }else if(character == ',' && !flagForBackslash ){
                
                commaCounter++;
                
            }else if(character == '\n' && !flagForBackslash) {
                
                final char[] line =  new char[counter - startOfNextLine +1]; //allokate the new line 
                System.arraycopy(dataArray, startOfNextLine, line, 0, counter - startOfNextLine ); //copy the line out of dataArray 
                startOfNextLine = counter+1; //the next line will start a counter position + 1

                if (isReallyEmpty(line))
                    csvText[lineCounter] = toStringArray(line,commaCounter); //generate the line with cells
                
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
     * checking if line is really Empty.
     * @param line the original line
     * @return boolean
     */
    private boolean isReallyEmpty(char... line) {
        
        int endOfLine = line.length-1;
        boolean isAfterEnd = true;
        for (int index = endOfLine ; index >= 0; index--) {
            if (line[index] != '\n' && !isAfterEnd) {
                endOfLine = index;
                isAfterEnd = false;
            }
        }
    
        final char[] trimmedLine = new char[endOfLine];
        System.arraycopy(line, 0, trimmedLine, 0, endOfLine);
        
       
        return !new String(trimmedLine).isEmpty();
    }
    
    /**
     * Aus einem String wird die momentane Zeile gebaut.
     * Die Worte werden an ',' getrennt.
     * 
     * @param line Die anzuschauende Zeile als String
     * @param commaCount die anzahl der gefundenen kommas
     * @return Zeile als String[]
     */
    private String[] toStringArray(char[] line, int commaCount) {
        int cellCounter = commaCount+1;  //there is a minimum of one cell   
        line[line.length-1] = ',';  //adding a ',' at the end to mark the end of the line

        final String[] csvLine = new String[cellCounter];
        cellCounter = 0;    
        int startOfNextLine = 0;
        int backslashCount = 0;
        boolean flagForBackslash = false;
        for (int counter = 0; counter < line.length ; counter++) {
            final char character = line[counter];
            
            if(character == '\\'){
                
                if (!flagForBackslash)              // only counting doublebackslash once
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
    
    /**
     * counting the number of real newlines in String. thows exception when file has a bad ending
     * @param allData String
     * @return number of lines as int
     */
    private int testNumberOfLines(char... allData){
        
        int numberOfLines = 0;
        boolean flagForBackslash = false;
        boolean flagForEndLine = false;
        for(char letter : allData){
            
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
    for (Character letter: original) {

        if (flagForDoubleBackslash) {
            result[resultIndex] = letter;
            resultIndex++;
            flagForDoubleBackslash = false;
        } else if (letter == '\\'){
            flagForDoubleBackslash = true;
        } else {
            result[resultIndex] = letter;
            resultIndex++;
            flagForDoubleBackslash = false;
        }
    }
    
    return result;
    }
}

