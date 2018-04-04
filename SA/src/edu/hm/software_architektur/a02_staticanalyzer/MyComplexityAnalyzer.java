package edu.hm.software_architektur.a02_staticanalyzer;


import edu.hm.cs.rs.arch18.a02_staticanalyzer.ComplexityAnalyzer;
import edu.hm.cs.rs.arch18.a02_staticanalyzer.demo.ProcessRunner;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        

        
                

        final Function<List<String>,Map<String,Integer>> fileAnalyzer = (string) -> {
            
            final Map<String,Integer> analyzedFiles = new HashMap<>();
            
            
            return analyzedFiles;
        };// end of Function fileAnayzer+++++++++
        
        final Function<Path,String> pathToData = (path) -> {
            final ByteArrayOutputStream baos = new ByteArrayOutputStream();
            final PrintStream printStream = new PrintStream(baos);
            System.setOut(printStream);
            
            try {
                ProcessRunner.main(path.toString());
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(MyComplexityAnalyzer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            final String result = baos.toString();
            System.out.flush();
            return result.trim();
        };
        
        final List<String> fileData = Files.walk(rootDir)
                                        .filter(file -> file.toString().endsWith(".class"))
                                        //.distinct()
                                        .map((path) -> pathToData.apply(path))
                                        .collect(Collectors.toList());

        
        return fileAnalyzer.apply(fileData);
    }
    
}
