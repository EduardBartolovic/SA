package edu.hm.software_architektur.a02_staticanalyzer;

import edu.hm.cs.rs.arch.a02_staticanalyzer.ComplexityAnalyzer;
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
//import java.util.function.Function;
import java.util.stream.Collectors;
import javafx.util.Pair;

/**
 * analyzing the complexity of a java class file.
 * @author Eduard Bartolovic, Felix Peither
 */
public class MyComplexityAnalyzer implements ComplexityAnalyzer {

    /**
     * offset needed for searching the name of the file.
     */
    private static final int OFFSET_FOR_CLASSNAME = 6;
    /**
     * offset needed for searching the name of the file.
     */
    private static final int OFFSET_FOR_INTERFACENAME = 10;
    /**
     * regex for finding name of Class.
     */
    private static final String REGEX_FOR_CLASS= "[ ]*([p][u][b][l][i][c][ ]){0,1}([a][b][s][t][r][a][c][t][ ]){0,1}[c][l][a][s][s][ ][\\S]*[ ]{0,1}[\\S]*[ ]{0,1}[\\S]*[ ]{0,1}[\\S]*[ ]{0,1}[\\S]*[ ]*[{]";
    /**
     * regex for finding name of Interface.
     */
    private static final String REGEX_FOR_INTERFACE= "[ ]*([p][u][b][l][i][c][ ]){0,1}[i][n][t][e][r][f][a][c][e][ ][\\S]*[ ]*[\\S]*[ ]*[\\S]*[ ]*[{]";
    
    /**
     * regex for finding the beginning of an exceptiontabel
     * for try catch blocks.
     */
    private static final String REGEX_FOR_EXC_TABEL_ENTRY = "[ ][ ]*[0-9][0-9]*[ ][ ]*[0-9][0-9]*[ ][ ]*[0-9][0-9]*[ ]*.*";
    
    /**
     * regex for finding out if a exception table entry is 
     * for a finally block or not.
     */
    private static final String REGEX_FOR_BEEING_FIALLY = "[ ][ ]*[0-9][0-9]*[ ][ ]*[0-9][0-9]*[ ][ ]*[0-9][0-9]*[ ]*[a][n][y][ ]*";
    
    /**
     * file type. 
     */
    private static final String CLASS = ".class";
    
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
     * private Constructor for setting new path rootdirectory.
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
        
        return Collections.unmodifiableMap(complexityAnalyzer(Files.walk(rootDir) // returns a stream of Files
                                                                .sequential()      
                                                                .filter(file -> file.toString().endsWith(".class")) //filter all files which are not .class files
                                                                .map(path -> pathToData(path)) // get the filecontent
                                                                .collect(Collectors.toList())) 
        );// returning a unmodifiable Map containing analyzed files and there complexity
    }
    
    /**
     * Gers all the data from a .class file.
     * 
     * @param path the path of the .class file
     * @return the data from the .class file as a list of strings
     */
    private List<String> pathToData(Path path) {
        String data = "";
        try {
            data = runProgram("javap", "-c", "-p", path.toString());
        } catch (IOException | InterruptedException exception) {
            System.out.println("Error");    
        }
        return Arrays.asList(data.split("\n"));
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
     * @param listOfList list containing data from files
     * @return Map filled with file names and there complexity
     */
    private Map<String,Integer> complexityAnalyzer(List<List<String>> listOfList){
        final Map<String,Integer> analyzedFiles = new HashMap<>(); // saving the complexity associated with filename
        //part for counting the complexity.
        listOfList.forEach(file -> { // for every file 
            final Pair<String, Integer> fileAnalyzerOutput = analyzeFile(file);
            analyzedFiles.put(fileAnalyzerOutput.getKey(), fileAnalyzerOutput.getValue());  // save file with its complexity
        });
        return analyzedFiles;
    }
    
    /**
     * Analyzes one file.
     * 
     * @param file the file to be analyzed
     * @return a pair of the file name and the computed complexity
     */
    private Pair<String, Integer> analyzeFile(List<String> file) {
        int complexity = 0;     //file complexity counter
        String fileName = "";   
        boolean exceptionTableFound = false;
        for (String line: file) {
            if(line.matches(REGEX_FOR_CLASS)){
                fileName = line.substring(line.indexOf("class ")+OFFSET_FOR_CLASSNAME);
                fileName = fileName.substring(0,fileName.indexOf(' '))+ CLASS;
            }else if(line.matches(REGEX_FOR_INTERFACE)){ // checking if the class is an interface
                fileName = line.substring(line.indexOf("interface ")+OFFSET_FOR_INTERFACENAME);
                fileName = fileName.substring(0,fileName.indexOf(' '))+ CLASS;
            }else if(line.matches("[ ]*[0-9]*[:]( )[i][f][_]*[a-z]*[ ]*[0-9]*")) { //find if
                complexity++;
            }else if(line.matches("[ ]*[E][x][c][e][p][t][i][o][n][ ][t][a][b][l][e][:][ ]*")) {
                exceptionTableFound = true;
            }else if(isValidExceptionEntry(line, exceptionTableFound)) { // finding an exception tabel entry
                complexity++;
            } else if(isValidMethod(line)){ // find methods                   
                complexity++;
                exceptionTableFound = false;
            }
        }
        return new Pair<>(fileName, complexity);
    }
    
    /**
     * Cechs if a given method head matters to for the complexity.
     * 
     * @param line the line to be examined
     * @return true if the method matters for the complexity
     */
    private boolean isValidMethod(String line) {
        return line.matches("[ ]*([\\S]*[ ]){0,5}[\\S]*[(][\\S| ]*[)]([ ][t][h][r][o][w][s][ ][\\S]*){0,1}[;]")&&!line.contains("abstract ")&&!line.contains("default ");
    }
    
    /**
     * Checks if a given line from an exception table matters
     * for the coplexity.
     * 
     * @param line the line to be examined
     * @param exceptionTableFound indicates if an exception table was found
     * @return true if entry matters to for the complexity, false otherwise
     */
    private boolean isValidExceptionEntry(String line, boolean exceptionTableFound) {
        return line.matches(REGEX_FOR_EXC_TABEL_ENTRY) && exceptionTableFound && !line.matches(REGEX_FOR_BEEING_FIALLY);
    }
}