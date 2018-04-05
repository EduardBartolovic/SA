package edu.hm.software_architektur.a02_staticanalyzer;


import edu.hm.cs.rs.arch18.a02_staticanalyzer.ComplexityAnalyzer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.swing.filechooser.FileSystemView;

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
     * default Constructor.
     */
    public MyComplexityAnalyzer(){
        rootDir = FileSystemView.getFileSystemView().getHomeDirectory().toPath();
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

        final List<String> fileNames = new ArrayList<>(); //list where file names are saved to
        final Map<String,Integer> analyzedFiles = new HashMap<>(); // saving the complexity associated with filename
        
        final Consumer<List<List<String>>> fileAnalyzer = listOflists -> {
            boolean athrowSet = false;
            int fileCount = 0;
            for (List<String> file: listOflists) { //part for counting the complexity.
                int complexity = 0;
                for (String line: file) {
                    if(line.contains("if")) {
                        complexity++;
                    }else if(line.contains("athrow")){
                        athrowSet = true;
                    } else if (line.contains("goto") && athrowSet) {
                        complexity++;
                    } else if(line.contains("return")){
                        complexity++;
                    }
                }
                analyzedFiles.put(fileNames.get(fileCount), complexity);
                fileCount++;
            }
        };// end of Function fileAnayzer+++++++++
        
        final Function<Path,List<String>> pathToData = path -> { //this function will get the decompiled file and turns it into  list
            fileNames.add(path.getFileName().toString());
            String data = "";
            try {
                data = runProgram(COMMAND, OPTION_C, OPTION_P, path.toString());
            } catch (IOException | InterruptedException ex) {
                System.out.println("Error in pathToData");
            }
            return Arrays.asList(data.split("\n"));
        };
        
        fileAnalyzer.accept(Files.walk(rootDir)
                                    .filter(file -> file.toString().endsWith(".class"))
                                    .map(pathToData::apply)
                                    .collect(Collectors.toList())
        );
        return Collections.unmodifiableMap(analyzedFiles);
    }
    
    /**
     * Startet ein anderes Programm und liefert dessen Konsolenausgabe (out und err) zurueck.
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
        try(final InputStream inputStream = process.getInputStream();
            final Reader reader = new InputStreamReader(inputStream);
            final BufferedReader bufferedReader = new BufferedReader(reader)) {
            final Thread collector = new Thread(() -> bufferedReader.lines().forEach(output::add));
            collector.start();
            if(process.waitFor() != 0)
                throw new IOException("process failed");
            collector.join();
        }
        return output.stream().collect(Collectors.joining("\n"));
    }
    
}
