package edu.hm.software_architektur.a02_staticanalyzer;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Computer
 */
public class main {
    public static void main(String...args) throws IOException{
        //Path path = Paths.get("C:\\Users\\Computer\\Documents\\NetBeansProjects\\SA\\SA\\build\\classes\\edu\\hm\\software_architektur");
        Path path = Paths.get("C:\\Users\\Edo\\Documents\\NetBeansProjects\\SA\\SA\\build\\classes\\edu\\hm\\software_architektur");
        MyComplexityAnalyzer analyzer = new MyComplexityAnalyzer(path);
        for (int c = 0; c < 100; c++) {
            // do nothing
        }
        System.out.println(analyzer.analyzeClassfiles().toString());
    }
}
