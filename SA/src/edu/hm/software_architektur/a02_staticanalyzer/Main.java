package edu.hm.software_architektur.a02_staticanalyzer;

import edu.hm.cs.rs.arch18.a02_staticanalyzer.ComplexityAnalyzer;
import java.io.IOException;
import java.nio.file.Paths;

/**
 *
 * @author Edo
 */
public class Main {
    public static void main(String... args) throws IOException{
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get("C:\\Users\\Edo\\Documents\\NetBeansProjects\\SA\\SA\\build\\classes\\edu\\hm\\software_architektur\\a02_staticanalyzer")); 
        System.out.println(analyzer.analyzeClassfiles());
    }
}
