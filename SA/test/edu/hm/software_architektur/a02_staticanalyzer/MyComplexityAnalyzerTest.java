package edu.hm.software_architektur.a02_staticanalyzer;

import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Edo
 */
public class MyComplexityAnalyzerTest {
    
//    public final Path path = Paths.get("C:\\Users\\Computer\\Documents\\NetBeansProjects\\SA\\SA\\build\\test\\classes\\edu\\hm\\software_architektur\\a02_staticanalyzer");
//    public final Path path = Paths.get("C:\\Users\\Edo\\Documents\\NetBeansProjects\\SA\\SA\\build\\test\\classes\\edu\\hm\\software_architektur\\a02_staticanalyzer");
       public final Path path = Paths.get("C:\\Users\\Edo\\Documents\\NetBeansProjects\\SA\\SA\\build\\test\\classes"); 
    
    public MyComplexityAnalyzerTest() {
    }

    @Test(timeout = 2000)
    public void test1() throws Exception {
        MyComplexityAnalyzer analyzer = new MyComplexityAnalyzer(Paths.get(path.toAbsolutePath().toString()+"\\ABC.class"));
        assertEquals(Integer.valueOf(2),analyzer.analyzeClassfiles().get("ABC.class"));   
    }
    
    @Test(timeout = 2000)
    public void test2() throws Exception {
        MyComplexityAnalyzer analyzer = new MyComplexityAnalyzer(Paths.get(path.toAbsolutePath().toString()+"\\Anonymous.class"));
        assertEquals(Integer.valueOf(2),analyzer.analyzeClassfiles().get("Anonymous.class"));   
    }
    
    @Test(timeout = 2000)
    public void test3() throws Exception {
        MyComplexityAnalyzer analyzer = new MyComplexityAnalyzer(Paths.get(path.toAbsolutePath().toString()+"\\Anonymous$1.class"));
        assertEquals(Integer.valueOf(2),analyzer.analyzeClassfiles().get("Anonymous$1.class"));   
    }
    
    @Test(timeout = 2000)
    public void test4() throws Exception {
        final String fileName = "BreakContinue";
        MyComplexityAnalyzer analyzer = new MyComplexityAnalyzer(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        assertEquals(Integer.valueOf(5),analyzer.analyzeClassfiles().get(fileName+".class"));   
    }
    
    @Test(timeout = 2000)
    public void test5() throws Exception {
        final String fileName = "ConditionalOp";
        MyComplexityAnalyzer analyzer = new MyComplexityAnalyzer(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        assertEquals(Integer.valueOf(3),analyzer.analyzeClassfiles().get(fileName+".class"));   
    }
    
    @Test(timeout = 2000)
    public void test6() throws Exception {
        final String fileName = "Finally";
        MyComplexityAnalyzer analyzer = new MyComplexityAnalyzer(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        assertEquals(Integer.valueOf(2),analyzer.analyzeClassfiles().get(fileName+".class"));   
    }
    @Test(timeout = 2000)
    public void test7() throws Exception {
        final String fileName = "For";
        MyComplexityAnalyzer analyzer = new MyComplexityAnalyzer(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        assertEquals(Integer.valueOf(4),analyzer.analyzeClassfiles().get(fileName+".class"));   
    }
    
    @Test(timeout = 2000)
    public void test8() throws Exception {
        final String fileName = "Hello";
        MyComplexityAnalyzer analyzer = new MyComplexityAnalyzer(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        assertEquals(Integer.valueOf(2),analyzer.analyzeClassfiles().get(fileName+".class"));   
    }
    
    @Test(timeout = 2000)
    public void test9() throws Exception {
        final String fileName = "HelloAgain";
        MyComplexityAnalyzer analyzer = new MyComplexityAnalyzer(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        assertEquals(Integer.valueOf(2),analyzer.analyzeClassfiles().get(fileName+".class"));   
    }
    @Test(timeout = 2000)
    public void test10() throws Exception {
        final String fileName = "HelloAll";
        MyComplexityAnalyzer analyzer = new MyComplexityAnalyzer(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        assertEquals(Integer.valueOf(10),analyzer.analyzeClassfiles().get(fileName+".class"));   
    }
    @Test(timeout = 2000)
    public void test11() throws Exception {
        final String fileName = "HelloIf";
        MyComplexityAnalyzer analyzer = new MyComplexityAnalyzer(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        assertEquals(Integer.valueOf(3),analyzer.analyzeClassfiles().get(fileName+".class"));   
    }
    @Test(timeout = 2000)
    public void test12() throws Exception {
        final String fileName = "HelloIfAnd";
        MyComplexityAnalyzer analyzer = new MyComplexityAnalyzer(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        assertEquals(Integer.valueOf(4),analyzer.analyzeClassfiles().get(fileName+".class"));   
    }
    @Test(timeout = 2000)
    public void test13() throws Exception {
        final String fileName = "Interface";
        MyComplexityAnalyzer analyzer = new MyComplexityAnalyzer(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        assertEquals(Integer.valueOf(2),analyzer.analyzeClassfiles().get(fileName+".class"));   
    }
    @Test(timeout = 2000)
    public void test14() throws Exception {
        final String fileName = "Lambda";
        MyComplexityAnalyzer analyzer = new MyComplexityAnalyzer(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        assertEquals(Integer.valueOf(3),analyzer.analyzeClassfiles().get(fileName+".class"));   
    }
    @Test(timeout = 2000)
    public void test15() throws Exception {
        final String fileName = "NestedTryCatch";
        MyComplexityAnalyzer analyzer = new MyComplexityAnalyzer(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        assertEquals(Integer.valueOf(8),analyzer.analyzeClassfiles().get(fileName+".class"));   
    }
    @Test(timeout = 2000)
    public void test16() throws Exception {
        final String fileName = "PrivateFinal";
        MyComplexityAnalyzer analyzer = new MyComplexityAnalyzer(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        assertEquals(Integer.valueOf(5),analyzer.analyzeClassfiles().get(fileName+".class"));   
    }
    
    @Test(timeout = 2000)
    public void test17() throws Exception {
        final String fileName = "TryCatch";
        MyComplexityAnalyzer analyzer = new MyComplexityAnalyzer(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        assertEquals(Integer.valueOf(4),analyzer.analyzeClassfiles().get(fileName+".class"));   
    }
    @Test(timeout = 2000)
    public void test18() throws Exception {
        final String fileName = "TryCatches";
        MyComplexityAnalyzer analyzer = new MyComplexityAnalyzer(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        assertEquals(Integer.valueOf(5),analyzer.analyzeClassfiles().get(fileName+".class"));   
    }
    @Test(timeout = 2000)
    public void test19() throws Exception {
        final String fileName = "TwoClasses";
        MyComplexityAnalyzer analyzer = new MyComplexityAnalyzer(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        assertEquals(Integer.valueOf(3),analyzer.analyzeClassfiles().get(fileName+".class"));   
    }
    @Test(timeout = 2000)
    public void test20() throws Exception {
        final String fileName = "Foo";
        MyComplexityAnalyzer analyzer = new MyComplexityAnalyzer(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        assertEquals(Integer.valueOf(3),analyzer.analyzeClassfiles().get(fileName+".class"));   
    }
    @Test(timeout = 2000)
    public void test21() throws Exception {
        final String fileName = "While";
        MyComplexityAnalyzer analyzer = new MyComplexityAnalyzer(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        assertEquals(Integer.valueOf(3),analyzer.analyzeClassfiles().get(fileName+".class"));   
    }
    @Test(timeout = 2000)
    public void test22() throws Exception {
        MyComplexityAnalyzer analyzer = new MyComplexityAnalyzer(Paths.get(path.toAbsolutePath().toString()+"\\"+"Hello.class"));
        assertEquals(Integer.valueOf(2),analyzer.analyzeClassfiles().get("Hello"+".class"));   
    }
    @Test(timeout = 2000)
    public void test23() throws Exception {
        MyComplexityAnalyzer analyzer = new MyComplexityAnalyzer(Paths.get(path.toAbsolutePath().toString()+"\\"+"TwoClasses.class"));
        assertEquals(Integer.valueOf(3),analyzer.analyzeClassfiles().get("TwoClasses.class"));   
    }
    @Test(timeout = 2000)
    public void test24() throws Exception {
        MyComplexityAnalyzer analyzer = new MyComplexityAnalyzer(Paths.get(path.toAbsolutePath().toString()+"\\"+"Foo.class"));
        assertEquals(Integer.valueOf(3),analyzer.analyzeClassfiles().get("Foo"+".class"));   
    }
}
