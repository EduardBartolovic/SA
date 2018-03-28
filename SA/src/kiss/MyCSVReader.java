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
        
        final char[] dataArray = allData.toCharArray(); 
        
        int heightCounter = testNumberOfLines(allData); // var to save number of lines

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
                
                if(!new String(line).isEmpty())//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
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
        
//        final String line = new String(lined);
//        
//        final String[] retArr = new String[cellCounter];
//        cellCounter = 0;
//        String word = "";
//        for (int counter = 0; counter < line.length(); counter++){
// 
//            final char letter = line.charAt(counter);
//            
//            if(letter == '\\'){
//                counter++;           // to see whats the next letter after the\
//                final char nextLetter = line.charAt(counter);
//                word += nextLetter;
//                
//            }else if(letter == ',') {
//                
//                retArr[cellCounter] = word; // save the word into a cell
//                cellCounter++;      //move to the next word
//                word = "";          //reset the old word
//                
//            } else {
//                word += line.charAt(counter);
//            }
//            
//        }
//        retArr[cellCounter] = word; // save the word into a cell
//        
//        return retArr;
        
        
        
        final String[] csvLine = new String[cellCounter];
        cellCounter = 0;
        int startOfNextLine = 0;
        boolean flagForBackslash = false;
        for (int counter = 0; counter < line.length ; counter++) {
            final char character = line[counter];
            
            if(character == '\\'){
                
                flagForBackslash = !flagForBackslash;

            }else if(character == ',' && !flagForBackslash) {
                
                final char[] word =  new char[counter - startOfNextLine ];
                System.arraycopy(line, startOfNextLine, word, 0, counter - startOfNextLine );
                startOfNextLine = counter+1;
                
                
                csvLine[cellCounter] = new String(word).replace("\\\\", "\\");
                
                cellCounter++;
                flagForBackslash = false;
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
    
//    private char[] removeBackSlash(char[] line){
//        
//        
//        
//        for(int counter = 0 ; counter < line.length ; counter++){
//            final char letter = line[counter];
//            if(letter == '\\'){
//                
//            }
//        }
//        
//        
//        return;
//    }
        
}

