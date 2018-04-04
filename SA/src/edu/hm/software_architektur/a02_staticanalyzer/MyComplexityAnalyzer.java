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
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * analyzing the complexity of a java class file.
 * @author Eduard Bartolovic, Felix Peither
 */
public class MyComplexityAnalyzer implements ComplexityAnalyzer {

    /**
     * parameter for disambler.
     */
    private static final String COMMAND = "javap";
    /**
     * parameter for disambler.
     */
    private static final String OPTION_C = "-c";
    /**
     * parameter for disambler.
     */
    private static final String OPTION_P = "-p";
    /**
     * saving the directory where a search should start.
     */
    private final Path rootDir;
    
    
    /**
     * public Constructor for setting new path rootdirectory.
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
        final Function<List<List<String>>,Optional<Map<String,Integer>>> fileAnalyzer = listOflists -> {
            boolean athrowSet = false;
            final Map<String,Integer> analyzedFiles = new HashMap<>();
            int fileCount = 0;
            final int[] complexityForEachFile = new int[listOflists.size()];
            for (List<String> file: listOflists) {
                for (String line: file) {
                    System.out.println(line);
                    if(line.contains("if")) {
                        complexityForEachFile[fileCount]++;
                    }else if(line.contains("athrow")){
                        athrowSet = true;
//                        complexityForEachFile[fileCount]++;
                    } else if (line.contains("goto") && athrowSet) {
                        complexityForEachFile[fileCount]++;
                    } else if(line.contains("return")){
                        complexityForEachFile[fileCount]++;
                    }
                }
                analyzedFiles.put(fileNames.get(fileCount), complexityForEachFile[fileCount]);
                fileCount++;
            }
            return Optional.of(Collections.unmodifiableMap(analyzedFiles));
        };// end of Function fileAnayzer+++++++++
        
        final Function<Path,String> pathToData = path -> {
            final ByteArrayOutputStream baos = new ByteArrayOutputStream();
            final PrintStream printStream = new PrintStream(baos);
            System.setOut(printStream);
            try {
                ProcessRunner.main(COMMAND, OPTION_C, OPTION_P, path.toString());
            } catch (IOException | InterruptedException exception) {
                System.out.println("Error in translting File");
            }
            final String result = baos.toString();
            System.out.flush();
            return result.trim();
        };
        
        
        return fileAnalyzer.apply(Files.walk(rootDir)
                                        .filter(file -> file.toString().endsWith(".class"))
                                        //.distinct()
                                        .map(path -> {
                                            fileNames.add(path.getFileName().toString());
                                            return pathToData.apply(path);
                                        })
                                        .map(data -> {
                                            final List<String> retList = new ArrayList<>();
                                            retList.addAll(Arrays.asList(data.split("\n")));
                                            return retList;
                                        })
                                        .collect(Collectors.toList()))
                .get();// when map ist empty
    }
    
}
