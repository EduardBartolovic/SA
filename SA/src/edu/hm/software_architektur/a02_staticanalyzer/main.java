package edu.hm.software_architektur.a02_staticanalyzer;

import edu.hm.cs.rs.arch18.a02_staticanalyzer.demo.ProcessRunner;
import java.io.IOException;

/**
 *
 * @author Computer
 */
public class main {
    private static final String COMMAND = "javap";
    private static final String OPTION_C = "-c";
    private static final String OPTION_P = "-p";
    
    public static void main(String...args) throws IOException, InterruptedException{
        //Path path = Paths.get("C:\\Users\\Computer\\Documents\\NetBeansProjects\\SA\\SA\\build\\classes\\edu\\hm\\software_architektur");
//        Path path = Paths.get("C:\\Users\\Computer\\Documents\\NetBeansProjects\\SA\\SA\\build\\classes\\edu\\hm\\software_architektur");
//        MyComplexityAnalyzer analyzer = new MyComplexityAnalyzer(path);
//        for (int c = 0; c < 100; c++) {
//            // do nothing
//        }
//        System.out.println(analyzer.analyzeClassfiles().toString());
        ProcessRunner.main(COMMAND, OPTION_C, OPTION_P,"C:\\Users\\Edo\\Documents\\NetBeansProjects\\SA\\SA\\build\\test\\classes\\Finally.class");
    }
}
