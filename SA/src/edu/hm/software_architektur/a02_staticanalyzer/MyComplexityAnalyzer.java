package edu.hm.software_architektur.a02_staticanalyzer;

import edu.hm.cs.rs.arch18.a02_staticanalyzer.ComplexityAnalyzer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
     * offset needed for searching the name of the file
     */
    private static final int OFFSETFORCLASSNAME = 6;
    /**
     * offset needed for searching the name of the file
     */
    private static final int OFFSETFORINTERFACENAME = 10;
    /**
     * saving the directory where a search should start.
     */
    private final Path rootDir;
    
    /**
     * default Constructor.
     */
    public MyComplexityAnalyzer(){
        this(Paths.get(System.getProperty("user.dir")));
    }
    
    /**
     * public Constructor for setting new path rootdirectory.
     * @param rootdir 
     */
    private MyComplexityAnalyzer(Path rootdir){
        this.rootDir = rootdir;
    }
    
    @Override
    public ComplexityAnalyzer setRootdir(Path rootdir) throws IOException {      
        return new MyComplexityAnalyzer(rootdir);
    }

    @Override
    public Map<String, Integer> analyzeClassfiles() throws IOException {
        
        final Function<Path,List<String>> pathToData = path -> { //this function will get the decompiled file and turns it into  list
            String data = "";
            try {
                data = runProgram(COMMAND, OPTION_C, OPTION_P, path.toString());
            } catch (IOException | InterruptedException exception) {
                throw new RuntimeException();
            }
            return Arrays.asList(data.split("\n"));
        };
        
        return Collections.unmodifiableMap(complexityAnalyzer(Files.walk(rootDir)
                                                                .sequential()
                                                                .filter(file -> file.toString().endsWith(".class"))
                                                                .map(pathToData::apply)
                                                                .collect(Collectors.toList()))
        );
    }
    
    /**
     * Startet ein anderes Programm und liefert dessen Ausgabe zurueck.
     * @param command Programmname und Kommandozeilenargumente.
     * @return Ausgabe des Programms.
     * @exception IOException bei einem Fehler im Filesystem.
     * @exception InterruptedException bei einer Unterbrechung des Prozesses.
     */
    private String runProgram(String... command) throws IOException, InterruptedException {
        final Process process = new ProcessBuilder(command)
        .redirectErrorStream(true)
        .start();
        final List<String> output = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(),Charset.defaultCharset()))) {
            final Thread collector = new Thread(() -> bufferedReader.lines().forEach(output::add));
            collector.start();
            if(process.waitFor() != 0)
                throw new IOException("process failed");
            collector.join();
        }
        return output.stream().collect(Collectors.joining("\n"));
    }
    
    /**
     * calculating the complexity of some files.
     * @param listOfList
     * @return Map filled with file names and there complexity
     */
    private Map<String,Integer> complexityAnalyzer(List<List<String>> listOfList){
        final Map<String,Integer> analyzedFiles = new HashMap<>(); // saving the complexity associated with filename
        for (List<String> file: listOfList) { //part for counting the complexity.
            int complexity = 0;
            String fileName = "";
            boolean searchForName = true;
            boolean athrowSet = false;
            for (String line: file) {
                if(line.contains("class ") && searchForName){
                    fileName = line.substring(line.indexOf("class ")+OFFSETFORCLASSNAME);
                    fileName = fileName.substring(0,fileName.indexOf(' '))+".class";
                    searchForName = false;
                }else if(line.contains("interface ") && searchForName){
                    fileName = line.substring(line.indexOf("interface ")+OFFSETFORINTERFACENAME);
                    fileName = fileName.substring(0,fileName.indexOf(' '))+".class";
                    searchForName = false;
                }else if(line.contains("if")) {
                    complexity++;
                    athrowSet = false;
                }else if(line.contains("athrow")){
                    athrowSet = true;
                } else if (line.contains("goto") && athrowSet) {
                    complexity++;
                } else if(line.contains("return")){
                    complexity++;
                    athrowSet = false;
                }
            }
            analyzedFiles.put(fileName,complexity);
        }
        return analyzedFiles;
    }   
}