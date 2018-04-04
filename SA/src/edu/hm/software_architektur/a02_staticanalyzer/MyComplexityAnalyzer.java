package edu.hm.software_architektur.a02_staticanalyzer;


import edu.hm.cs.rs.arch18.a02_staticanalyzer.ComplexityAnalyzer;
import edu.hm.cs.rs.arch18.a02_staticanalyzer.demo.ProcessRunner;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    private static final String COMMAND = "javap";
    private static final String OPTION_C = "-c";
    private static final String OPTION_P = "-p";
    
    /**
     * public Constructor for setting new path rootdirectory
     * @param rootdir 
     */
    public MyComplexityAnalyzer(Path rootdir){
        this.rootDir = rootdir;
    }
    
    @Override
    public ComplexityAnalyzer setRootdir(Path rootdir) throws IOException {      
        return new MyComplexityAnalyzer(rootdir);
    }

    @Override
    public Map<String, Integer> analyzeClassfiles() throws IOException {

        final List<String> fileNames = new ArrayList<>(); //list where file names are saved to
        
        final Function<List<List<String>>,Map<String,Integer>> fileAnalyzer = (listOflists) -> {
            
            final Map<String,Integer> analyzedFiles = new HashMap<>();
            int fileCount = 0;
            final int[] complexityForEachFile = new int[listOflists.size()];
            for (List<String> list: listOflists) {
                for (String line: list) {
                    System.out.println(line);
                    if (line.contains("if")) {
                        complexityForEachFile[fileCount]++;
                    }else if(line.contains("athrow")){
                        complexityForEachFile[fileCount]++;
                    } else if (line.contains("return")){
                        complexityForEachFile[fileCount]++;
                    }
                }
                analyzedFiles.put(fileNames.get(fileCount), complexityForEachFile[fileCount]);
                fileCount++;
            }
            
            return Collections.unmodifiableMap(analyzedFiles);
        };// end of Function fileAnayzer+++++++++
        
        final Function<Path,String> pathToData = (path) -> {
            final ByteArrayOutputStream baos = new ByteArrayOutputStream();
            final PrintStream printStream = new PrintStream(baos);
            System.setOut(printStream);
            
            try {
                ProcessRunner.main(COMMAND, OPTION_C, OPTION_P, path.toString());
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(MyComplexityAnalyzer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            final String result = baos.toString();
            System.out.flush();
            return result.trim();
        };
        
        
        return fileAnalyzer.apply(Files.walk(rootDir)
                                        .filter(file -> file.toString().endsWith(".class"))
                                        //.distinct()
                                        .map((path) -> {
                                            fileNames.add(path.getFileName().toString());
                                            return pathToData.apply(path);
                                        })
                                        .map(data -> {
                                            List<String> retList = new ArrayList<>();
                                            retList.addAll(Arrays.asList(data.split("\n")));
                                            return retList;
                                        })
                                        .collect(Collectors.toList()));
    }
    
}
