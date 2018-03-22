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
        
        int heightCounter = 0; // var to save number of lines
        String allData = "";   // whole file will be saved to this string
        int letter = reader.read(); 
        
        if(letter < 0)  //check if file is empty
            throw new IllegalArgumentException("text should not be empty");
        
        //read the whole file
        while( letter > 0) {    
            if(letter == '\\'){
                final int nextLetter = reader.read(); 
                if(nextLetter == '\r'){ //ignore Enter when previsly element is a backslash
                    reader.read(); // for \n
                }else{
                    allData += '\\';
                    allData += (char)nextLetter;
                }
            }else{
                if(letter == '\n')  // to count the number of lines
                    heightCounter++;
                
                allData += (char)letter;
            }
            letter = reader.read();
        }
        
        if(allData.charAt(allData.length()-1) != '\n') //check if file ends with enter
            throw new IllegalArgumentException("File ends not with \\r\\n ");
        
        final char[] dataArray = allData.toCharArray(); 
        
        
        final String[][] csvText = new String[heightCounter][];//allokate array which will be returned
        
        //filling up the array
        int lineCounter = 0;
        String line = "";
        for (Character character: dataArray) {
            if (character == '\n') {
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
     * splitting word by ,
     * @param line
     * @return line
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
                char nextLetter = line.charAt(counter);
                
                if(nextLetter == ','){
                    word += ',';
                }else if(nextLetter == '\\'){
                    word += '\\';
                }else{
                    word += '\\';
                    word += nextLetter;
                }
                
            }else if(letter == ',' || letter == '\r') {
                
                retArr[cellCounter] = word; // save the word into a cell
                cellCounter++;      //move to the next word
                word = "";          //reset the old word
                
            } else {
                word += line.charAt(counter);
            }
            
        }
        return retArr;
    }
    
   
}

