package edu.hm.software_architektur.a02_staticanalyzer;

import edu.hm.cs.rs.arch18.a02_staticanalyzer.ComplexityAnalyzer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Edo
 */
public class MyComplexityAnalyzerTest {
    
    public final Path path = Paths.get("C:\\Users\\Computer\\Documents\\NetBeansProjects\\SA\\SA\\build\\test\\classes");
//    public final Path path = Paths.get("C:\\Users\\Edo\\Documents\\NetBeansProjects\\SA\\SA\\build\\test\\classes\\edu\\hm\\software_architektur\\a02_staticanalyzer");
//    public final Path path = Paths.get("C:\\Users\\Edo\\Documents\\NetBeansProjects\\SA\\SA\\build\\test\\classes"); 
    
    public MyComplexityAnalyzerTest() {
    }

    @Test(timeout = 2000)
    public void test1() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\ABC.class"));
        assertEquals(Integer.valueOf(2),analyzer.analyzeClassfiles().get("ABC.class"));   
    }
    
    @Test(timeout = 2000)
    public void test2() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\Anonymous.class"));
        assertEquals(Integer.valueOf(2),analyzer.analyzeClassfiles().get("Anonymous.class"));   
    }
    
    @Test(timeout = 2000)
    public void test3() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\Anonymous$1.class"));
        assertEquals(Integer.valueOf(2),analyzer.analyzeClassfiles().get("Anonymous$1.class"));   
    }
    
    @Test(timeout = 2000)
    public void test4() throws Exception {
        final String fileName = "BreakContinue";
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        assertEquals(Integer.valueOf(5),analyzer.analyzeClassfiles().get(fileName+".class"));   
    }
    
    @Test(timeout = 2000)
    public void test5() throws Exception {
        final String fileName = "ConditionalOp";
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        assertEquals(Integer.valueOf(3),analyzer.analyzeClassfiles().get(fileName+".class"));   
    }
    
    @Test(timeout = 2000)
    public void test6() throws Exception {
        final String fileName = "Finally";
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        assertEquals(Integer.valueOf(2),analyzer.analyzeClassfiles().get(fileName+".class"));   
    }
    @Test//(timeout = 2000)
    public void test7() throws Exception {
        final String fileName = "For";
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        Map<String, Integer> retValue = analyzer.analyzeClassfiles();
        assertEquals(Integer.valueOf(4),retValue.get("For.class"));   
    }
    
    @Test(timeout = 2000)
    public void test8() throws Exception {
        final String fileName = "Hello";
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        assertEquals(Integer.valueOf(2),analyzer.analyzeClassfiles().get(fileName+".class"));   
    }
    
    @Test(timeout = 2000)
    public void test9() throws Exception {
        final String fileName = "HelloAgain";
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        assertEquals(Integer.valueOf(2),analyzer.analyzeClassfiles().get(fileName+".class"));   
    }
    @Test(timeout = 2000)
    public void test10() throws Exception {
        final String fileName = "HelloAll";
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        assertEquals(Integer.valueOf(10),analyzer.analyzeClassfiles().get(fileName+".class"));   
    }
    @Test(timeout = 2000)
    public void test11() throws Exception {
        final String fileName = "HelloIf";
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        assertEquals(Integer.valueOf(3),analyzer.analyzeClassfiles().get(fileName+".class"));   
    }
    @Test(timeout = 2000)
    public void test12() throws Exception {
        final String fileName = "HelloIfAnd";
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        assertEquals(Integer.valueOf(4),analyzer.analyzeClassfiles().get(fileName+".class"));   
    }
    @Test(timeout = 2000)
    public void test13() throws Exception {
        final String fileName = "Interface";
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        assertEquals(Integer.valueOf(2),analyzer.analyzeClassfiles().get(fileName+".class"));   
    }
    @Test(timeout = 2000)
    public void test14() throws Exception {
        final String fileName = "Lambda";
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        assertEquals(Integer.valueOf(3),analyzer.analyzeClassfiles().get(fileName+".class"));   
    }
    @Test(timeout = 2000)
    public void test15() throws Exception {
        final String fileName = "NestedTryCatch";
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        assertEquals(Integer.valueOf(8),analyzer.analyzeClassfiles().get(fileName+".class"));   
    }
    @Test(timeout = 2000)
    public void test16() throws Exception {
        final String fileName = "PrivateFinal";
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        assertEquals(Integer.valueOf(5),analyzer.analyzeClassfiles().get(fileName+".class"));   
    }
    
    @Test(timeout = 2000)
    public void test17() throws Exception {
        final String fileName = "TryCatch";
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        assertEquals(Integer.valueOf(4),analyzer.analyzeClassfiles().get(fileName+".class"));   
    }
    @Test(timeout = 2000)
    public void test18() throws Exception {
        final String fileName = "TryCatches";
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        assertEquals(Integer.valueOf(5),analyzer.analyzeClassfiles().get(fileName+".class"));   
    }
    @Test(timeout = 2000)
    public void test19() throws Exception {
        final String fileName = "TwoClasses";
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        assertEquals(Integer.valueOf(3),analyzer.analyzeClassfiles().get(fileName+".class"));   
    }
    @Test(timeout = 2000)
    public void test20() throws Exception {
        final String fileName = "Foo";
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        assertEquals(Integer.valueOf(3),analyzer.analyzeClassfiles().get(fileName+".class"));   
    }
    @Test(timeout = 2000)
    public void test21() throws Exception {
        final String fileName = "While";
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        assertEquals(Integer.valueOf(3),analyzer.analyzeClassfiles().get(fileName+".class"));   
    }
    @Test(timeout = 2000)
    public void test22() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"Hello.class"));
        assertEquals(Integer.valueOf(2),analyzer.analyzeClassfiles().get("Hello"+".class"));   
    }
    @Test(timeout = 2000)
    public void test23() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"TwoClasses.class"));
        assertEquals(Integer.valueOf(3),analyzer.analyzeClassfiles().get("TwoClasses.class"));   
    }
    @Test(timeout = 2000)
    public void test24() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"Foo.class"));
        assertEquals(Integer.valueOf(3),analyzer.analyzeClassfiles().get("Foo"+".class"));   
    }
    @Test//(timeout = 20000)
    public void test25() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"));
        final Map<String,Integer> have = analyzer.analyzeClassfiles();
        System.out.println(have);
//        assertEquals(30,have.size());  
        assertEquals(Integer.valueOf(2),have.get("ABC"+".class"));   
        assertEquals(Integer.valueOf(2),have.get("Anonymous"+".class"));   
        assertEquals(Integer.valueOf(2),have.get("Anonymous$1"+".class"));   
        assertEquals(Integer.valueOf(5),have.get("BreakContinue"+".class"));
        assertEquals(Integer.valueOf(3),have.get("ConditionalOp"+".class"));   
        assertEquals(Integer.valueOf(2),have.get("Finally"+".class"));   
        assertEquals(Integer.valueOf(4),have.get("For.class")); 
        assertEquals(Integer.valueOf(2),have.get("Hello"+".class"));          
        assertEquals(Integer.valueOf(2),have.get("HelloAgain"+".class"));   
        assertEquals(Integer.valueOf(10),have.get("HelloAll"+".class"));   
        assertEquals(Integer.valueOf(3),have.get("HelloIf"+".class"));   
        assertEquals(Integer.valueOf(4),have.get("HelloIfAnd"+".class"));   
        assertEquals(Integer.valueOf(2),have.get("Interface"+".class"));   
        assertEquals(Integer.valueOf(3),have.get("Lambda"+".class"));   
        assertEquals(Integer.valueOf(8),have.get("NestedTryCatch"+".class")); 
        assertEquals(Integer.valueOf(4),have.get("Or.class"));  
        assertEquals(Integer.valueOf(5),have.get("PrivateFinal"+".class"));   
        assertEquals(Integer.valueOf(4),have.get("TryCatch"+".class"));   
        assertEquals(Integer.valueOf(5),have.get("TryCatches"+".class"));       
        assertEquals(Integer.valueOf(3),have.get("main.TwoClasses"+".class"));
        assertEquals(Integer.valueOf(3),have.get("Foo"+".class"));  
        assertEquals(Integer.valueOf(3),have.get("While"+".class"));  
        assertEquals(Integer.valueOf(2),have.get("Hello"+".class"));   
        assertEquals(Integer.valueOf(3),have.get("TwoClasses"+".class"));   
        assertEquals(Integer.valueOf(3),have.get("sub.Foo"+".class"));  
        
    }
    @Test(timeout = 2000)
    public void test26() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"Or.class"));
        assertEquals(Integer.valueOf(4),analyzer.analyzeClassfiles().get("Or.class"));   
    }
    
    @Test(timeout = 2000)
    public void test27() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"MoreOr.class"));
        assertEquals(Integer.valueOf(6),analyzer.analyzeClassfiles().get("MoreOr.class"));   
    }
    
    @Test(timeout = 2000)
    public void test28() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"MoreAnd.class"));
        assertEquals(Integer.valueOf(6),analyzer.analyzeClassfiles().get("MoreAnd.class"));   
    }
    @Test(timeout = 2000)
    public void test29() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"AndOr.class"));
        assertEquals(Integer.valueOf(6),analyzer.analyzeClassfiles().get("AndOr.class"));   
    }
    @Test(timeout = 2000)
    public void test30() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"IfInIf.class"));
        assertEquals(Integer.valueOf(4),analyzer.analyzeClassfiles().get("IfInIf.class"));   
    }
    @Test(timeout = 2000)
    public void test31() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"IfInIfIf.class"));
        assertEquals(Integer.valueOf(5),analyzer.analyzeClassfiles().get("IfInIfIf.class"));   
    }
    @Test(timeout = 2000)
    public void test32() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"AbstractTest.class"));
        assertEquals(Integer.valueOf(3),analyzer.analyzeClassfiles().get("AbstractTest.class"));   
    }
    

}
