package edu.hm.software_architektur.a02_staticanalyzer;


import edu.hm.cs.rs.arch18.a02_staticanalyzer.ComplexityAnalyzer;
import static edu.hm.software_architektur.a01_csvreader.MyCSVReader.LENGTHOFBUF;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author Eduard Bartolovic, Felix Peither
 */
public class MyComplexityAnalyzer implements ComplexityAnalyzer {

    private final Path rootDir;
    
    private MyComplexityAnalyzer(Path rootdir){
        this.rootDir = rootdir;
    }
    
    @Override
    public ComplexityAnalyzer setRootdir(Path rootdir) throws IOException {      
        return new MyComplexityAnalyzer(rootdir);
    }

    @Override
    public Map<String, Integer> analyzeClassfiles() throws IOException {
        

        
                
        final Function<List<Path>,Map<String,Integer>> fileAnalyzer = (pathList) -> {
            
            final Map<String,Integer> analyzedFiles = new HashMap<>();
            
            
            pathList.forEach((path) -> {
                final BufferedReader bufReader;
                try {
                    bufReader = new BufferedReader(new FileReader(path.toString()));

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
                    
                    
                    
                    
                } catch (IOException ex) {
                    System.out.println("Error in finding File or error in reading File");
                }
            });

            return analyzedFiles;
        };
        
        final List<Path> pathList = Files.walk(rootDir)
                                        .filter(file -> file.toString().endsWith(".class"))
                                        //.distinct()
                                        .collect(Collectors.toList());
        
        
        
      
        
        
        
        
        return fileAnalyzer.apply(pathList);
    }
    
}
