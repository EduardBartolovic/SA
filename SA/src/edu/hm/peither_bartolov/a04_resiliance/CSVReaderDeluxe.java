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
public class CSVReaderDeluxe implements CSVReader{

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
        boolean flagForQuoteStart = false;
//        boolean flagForQuoteEnd = false;
        for (int counter = 0; counter < dataArray.length ; counter++) { 
            final char character = dataArray[counter];
            
            if(checker(character, '\\', !flagForQuoteStart)){
                flagForBackslash = !flagForBackslash; 
            }else if(checker(character, ',', !flagForBackslash, !flagForQuoteStart)) {
                commaCounter++;
            }else if(checker(character, '\n', !flagForBackslash, !flagForQuoteStart)) {
                final char[] line =  new char[counter - startOfNextLine +1]; //allokate the new line 
                System.arraycopy(dataArray, startOfNextLine, line, 0, counter - startOfNextLine ); //copy the line out of dataArray 
                startOfNextLine = counter+1; //the next line will start a counter position + 1
                
                if (isReallyEmpty(line))
                    csvText[lineCounter] = toStringArray(line,commaCounter); //generate the line with cells
                
                lineCounter++; 
                commaCounter = 0;
                flagForBackslash = false;
                flagForQuoteStart = false;
            } else if (character == '"') {
                flagForQuoteStart = !flagForQuoteStart;//                    flagForQuoteEnd = true;
            } else{
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
        boolean flagForQuoteStart = false;
        for (int counter = 0; counter < line.length ; counter++) {
            final char character = line[counter];
            if(checker(character, '\\', !flagForQuoteStart)){
                flagForBackslash = !flagForBackslash;
            } else if (checker(character, ',', !flagForBackslash, !flagForQuoteStart)) { 
                final char[] word =  new char[counter - startOfNextLine ]; 
                System.arraycopy(line, startOfNextLine, word, 0, counter - startOfNextLine );
                startOfNextLine = counter+1;
                csvLine[cellCounter] = new String(removeBackSlashesAndQuotes(word/*, backslashCount*/));               
                cellCounter++;
                flagForBackslash = false;
            } else if (character == '"') {
                flagForQuoteStart = !flagForQuoteStart;
            } else{
                flagForBackslash = false;
            } 
            
        }
        
        return csvLine;
    }
    
    private boolean checker(char haveLetter, char wantLetter, boolean...bools) {
        boolean returnBool = wantLetter == haveLetter;
        for (Boolean bool: bools) {
            returnBool = returnBool && bool;
        }
        return returnBool;
    }
    
    /**
     * counting the number of real newlines in String. 
     * thows exception when file has a bad ending
     * 
     * @param allData String
     * @return number of lines as int
     */
    private int testNumberOfLines(char... allData){
        
        int numberOfLines = 0;
        boolean flagForBackslash = false;
        boolean flagForEndLine = false;
        boolean flagForQuoteStart = false;
        for(char letter : allData){
            
            if (checker(letter, '\\', !flagForQuoteStart)) {
                flagForBackslash = !flagForBackslash;
                flagForEndLine = false;
            } else if (checker(letter, '\n', !flagForBackslash, !flagForQuoteStart)){
                numberOfLines++;
                flagForEndLine = true;
            } else if (letter == 0){
                flagForBackslash = false;
            } else if (letter == '"') {
                flagForQuoteStart = !flagForQuoteStart;
            } else {
                flagForBackslash = false;
                flagForEndLine = false;
            }
        }
        
        notRightFormat(flagForQuoteStart, flagForEndLine);
        
//        if (flagForQuoteStart) 
//            throw new IllegalArgumentException("wrong quotation");
//        if(!flagForEndLine)
//            throw new IllegalArgumentException("File ends not with \\n ");
        System.out.println(numberOfLines);
        return numberOfLines;  
         
    }
    
    /**
     * check if the text has the right format.
     * 
     * @param flagForQuoteStart flag for right quotation
     * @param flagForEndLine flag for right end on text
     * @throws IllegalArgumentException
     */
    private void notRightFormat(boolean flagForQuoteStart, boolean flagForEndLine) throws IllegalArgumentException{
        if (flagForQuoteStart) 
            throw new IllegalArgumentException("wrong quotation");
        if(!flagForEndLine)
            throw new IllegalArgumentException("File ends not with \\n ");     
    }
    
    /**
     * check if a word from the text is in right quotation
     * 
     * @param original the original word
     * @throws IllegalArgumentException
     */
    private void failIfNotCorrectlyQuoted(char...original) throws IllegalArgumentException {
        boolean notCorrectlyQuoted;
        try {
            notCorrectlyQuoted = original[0] == '"' && original[original.length-1] != '"';
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            notCorrectlyQuoted = false;
        }
        if (notCorrectlyQuoted) {
            throw new IllegalArgumentException("word not correctly quoted!");
        }
    }
    
    /**
     * Removes all anacceptable backslashes from a word.
     * 
     * @param original the original word
     * @return A word without backslashes
     */
    public char[] removeBackSlashesAndQuotes(char...original/*, int backslashCount*/){
    
        failIfNotCorrectlyQuoted(original);
        
        final StringBuilder resultString = new StringBuilder();
//        int resultIndex = 0;
        boolean flagForDoubleBackslash = false;
        boolean flagForQuoteStart = false;
        boolean flagForQuoteEnd = false;
        for (Character letter: original) {
        
            if (flagForDoubleBackslash) {
                resultString.append(letter);
                flagForDoubleBackslash = false;
            }else if(checker(letter, '\\', !flagForQuoteStart)) {
                flagForDoubleBackslash = true;
            } else if (letter == '"') {
                boolean[] retBools = addQuotes(flagForQuoteStart, flagForQuoteEnd, flagForDoubleBackslash);
                if (retBools[0]) {
                    resultString.append(letter);
                }
                flagForQuoteStart = retBools[1];
                flagForDoubleBackslash  = retBools[3];
                flagForQuoteEnd  = retBools[2];
            } else {
                resultString.append(letter);
                flagForDoubleBackslash = false;
            }
        }
    
        if (flagForQuoteStart && !flagForQuoteEnd) {
            throw new IllegalArgumentException("Word not correctly quoted");
        }
    
//        System.out.println(resultString.toString().toCharArray().length);
    return resultString.toString().toCharArray();
    }
    
    /**
     * check if the qoutes have to be added or not.
     * 
     * @param flagForQuoteStart flag if the quote is within a quotation or not
     * @param flagForQuoteEnd flag if the quote is after another one
     * @param flagForDoubleBackslash flag if the quote is after a backslash
     * @return true at pos 0 if a quote has to be added to the word, and the updated flags
     */
    private boolean[] addQuotes(boolean flagForQuoteStart, boolean flagForQuoteEnd, boolean flagForDoubleBackslash) {
        boolean[] addQuotes = new boolean[]{false, flagForQuoteStart, flagForQuoteEnd, flagForDoubleBackslash};
        
//        System.out.println(flagForDoubleBackslash + " back " + flagForQuoteEnd + " end " + flagForQuoteStart + " start ");
        if (flagForQuoteStart && !flagForQuoteEnd) {
//            System.out.println("im here 1");
            addQuotes[2] = true;
        } else if (flagForQuoteEnd && flagForQuoteStart) {
//            System.out.println("im here 2");
            addQuotes[0] = true;
            addQuotes[2] = false;
        } else if (flagForDoubleBackslash) {
//            System.out.println("im here 3");
            addQuotes[0] = true;
            addQuotes[3] = false;
        } else {
//            System.out.println("im here 4");
            addQuotes[1] = true;
        }
        
        return addQuotes;
    }
    
}

