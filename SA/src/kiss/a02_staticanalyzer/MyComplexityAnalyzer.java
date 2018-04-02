/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiss.a02_staticanalyzer;


import edu.hm.cs.rs.arch18.a02_staticanalyzer.ComplexityAnalyzer;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
/**
 *
 * @author Eduard Bartolovic, Felix Peither
 */
public class MyComplexityAnalyzer implements ComplexityAnalyzer {

    @Override
    public ComplexityAnalyzer setRootdir(Path rootdir) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, Integer> analyzeClassfiles() throws IOException {
        
        Reader reader = new FileReader("");
        String allData = "";   // whole file will be saved to this string
        
        int letter = reader.read(); 
        //read the whole file
        while( letter > 0) {    
            allData += (char)letter;
            letter = reader.read();
        }
        

        Stream.of(allData);
        
        
        
        
        return new HashMap<>();
    }
    
}
