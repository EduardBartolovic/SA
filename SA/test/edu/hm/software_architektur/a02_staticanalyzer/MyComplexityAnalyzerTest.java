package edu.hm.software_architektur.a02_staticanalyzer;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;

/**
 *
 * @author Edo
 */
public class MyComplexityAnalyzerTest {
    
   // public final Path path = Paths.get("C:\\Users\\Computer\\Documents\\NetBeansProjects\\SA\\SA\\build\\classes\\edu\\hm\\software_architektur");
    public final Path path = Paths.get("C:\\Users\\Edo\\Documents\\NetBeansProjects\\SA\\SA\\test\\edu\\hm\\software_architektur\\a02_staticanalyzer");
        
    
    public MyComplexityAnalyzerTest() {
    }

    @Test(timeout = 10000)
    public void test1() throws Exception {
        MyComplexityAnalyzer analyzer = new MyComplexityAnalyzer(Paths.get(path.toAbsolutePath().toString()+"ABC=2"));
        System.out.println(analyzer.analyzeClassfiles().toString());
        
    }
    
}
