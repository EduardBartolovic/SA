package edu.hm.software_architektur.a02_staticanalyzer;

import edu.hm.cs.rs.arch18.a02_staticanalyzer.ComplexityAnalyzer;
import edu.hm.cs.rs.arch18.a02_staticanalyzer.demo.ProcessRunner;
import java.io.IOException;
import java.nio.file.Paths;

/**
 *
 * @author Edo
 */
public class Main {
    
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
    
    public static void main(String... args) throws IOException, InterruptedException{
        ProcessRunner.main(COMMAND, OPTION_C, OPTION_P,"C:\\Users\\Edo\\Documents\\NetBeansProjects\\SA\\SA\\build\\test\\classes\\Anonymous$1.class"); 
        ProcessRunner.main(COMMAND, OPTION_C, OPTION_P,"C:\\Users\\Edo\\Documents\\NetBeansProjects\\SA\\SA\\build\\test\\classes\\Anonymous.class"); 
        ProcessRunner.main(COMMAND, OPTION_C, OPTION_P,"C:\\Users\\Edo\\Documents\\NetBeansProjects\\SA\\SA\\build\\test\\classes\\Interface.class"); 
        ProcessRunner.main(COMMAND, OPTION_C, OPTION_P,"C:\\Users\\Edo\\Documents\\NetBeansProjects\\SA\\SA\\build\\test\\classes\\AbstractTest.class"); 

        
        ProcessRunner.main(COMMAND, OPTION_C, OPTION_P,"C:\\Users\\Edo\\Documents\\NetBeansProjects\\SA\\SA\\build\\test\\classes\\Or.class"); 
        ProcessRunner.main(COMMAND, OPTION_C, OPTION_P,"C:\\Users\\Edo\\Documents\\NetBeansProjects\\SA\\SA\\build\\test\\classes\\HelloIfAnd.class"); 
        ProcessRunner.main(COMMAND, OPTION_C, OPTION_P,"C:\\Users\\Edo\\Documents\\NetBeansProjects\\SA\\SA\\build\\test\\classes\\MoreOr.class"); 
    
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get("C:\\Users\\Edo\\Documents\\NetBeansProjects\\SA\\SA\\build\\classes\\edu\\hm\\software_architektur\\a02_staticanalyzer")); 
        System.out.println(analyzer.analyzeClassfiles());
        
        ComplexityAnalyzer analyzer1 = new MyComplexityAnalyzer().setRootdir(Paths.get("C:\\Users\\Edo\\Documents\\NetBeansProjects\\SA\\SA\\build\\test\\classes")); 
        System.out.println(analyzer1.analyzeClassfiles());
        

    }
}
