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

        final StringBuilder allData = new StringBuilder();   // whole file will be saved to this string
        int readChar = bufReader.read();
        if (readChar < 0) {
                throw new IllegalArgumentException("text should not be empty");
        }

        while(readChar > 0){     
            allData.append((char)readChar); 
            readChar = bufReader.read();
        }
        
        final char[] dataArray = allData.toString().toCharArray();
        
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
                
            }else if(character == '\\' ){
                
                flagForBackslash = !flagForBackslash; 
                
            }else if(flagChecker(character,',',flagForBackslash,flagForQuotes)){
                
                commaCounter++;
                
            }else if(flagChecker(character,'\n',flagForBackslash,flagForQuotes)){
                
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
        boolean flagForBackslash = false;
        boolean flagForQuotes = false;
        for (int counter = 0; counter < line.length ; counter++) {
            final char character = line[counter];
            
            if(character == '"'){
                flagForQuotes = !flagForQuotes;
            } else if(flagChecker(character,'\\',flagForQuotes,false)){
                
                flagForBackslash = !flagForBackslash;

            }else if(flagChecker(character,',',flagForBackslash,flagForQuotes)){
                
                csvLine[cellCounter] = buildWord(line,startOfNextLine,counter);
                startOfNextLine = counter+1;
                cellCounter++;
                flagForBackslash = false;
                
            }else{
                flagForBackslash = false;
            } 
            
        }
        
        return csvLine;
    }
    
    /**
     * building words.
     * @param line line of words
     * @param start start pos of word
     * @param end end pos of word
     * @return the word modified.
     */
    private String buildWord(char[] line, int start, int end){
        final char[] word =  new char[end-start]; 
        System.arraycopy(line, start, word, 0, end-start );
        
        if(word.length == 0)
           return new String(word);
        
        final int begin;
        final int limit;
        if(word[0] == '"'){
            if(word[word.length-1] != '"')
                throw new IllegalArgumentException();
            begin = 1;
            limit = word.length-1;
        }else{
            begin = 0;
            limit = word.length;
        }
        
        return removeBackslashAndQuotes(begin,limit,word);
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
        boolean flagForQuotes = false;
        for(char letter : allData){
            
            if(letter == '"'){
                flagForQuotes = !flagForQuotes;
                flagForBackslash = false;
            } else if(flagChecker(letter,'\\',flagForQuotes,false)){
                flagForBackslash = !flagForBackslash;
                flagForEndLine = false;
            } else if(flagChecker(letter,'\n',flagForBackslash,flagForQuotes)){
                numberOfLines++;
                flagForBackslash = false;
                flagForEndLine = true;
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
     * removing all backslashes and quotes which are wrong.
     * @param start start of loop
     * @param end   end of loop
     * @param original word to be modified
     * @return modified word 
     */
    public String removeBackslashAndQuotes(int start ,int end ,char... original) {
        
        boolean flagForQuote = false;
        boolean flagForBackslash = false;
        final StringBuilder word = new StringBuilder();        
        for(int originalIndex = start ;originalIndex < end; originalIndex++) {
            final char letter = original[originalIndex];
            if (flagForBackslash) {
                word.append(letter);
                flagForBackslash = false;
            } else if (letter == '\\' && original[0] == '"') {
                word.append(letter);
            } else if (letter == '\\'){
                flagForBackslash = true;
            }else if(flagChecker(letter,'"',!flagForQuote,false)){
                flagForQuote = false;
                word.append(letter);
            }else if(letter == '"'){
                flagForQuote = true;
            }else{
                word.append(letter);
                flagForBackslash = false;
            }
        }

        return word.toString();
    }
    
    /**
     * checking the expression.
     * @param letterToCheck char
     * @param character char
     * @param firstBool bool
     * @param secBool bool
     * @return boolean from expression
     */
    private boolean flagChecker(char letterToCheck , char character ,boolean firstBool , boolean secBool){
        return letterToCheck == character && !firstBool && !secBool;
    }
}

