package edu.hm.software_architektur.a02_staticanalyzer;

import edu.hm.cs.rs.arch.a02_staticanalyzer.ComplexityAnalyzer;
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
//    public final Path path = Paths.get("C:\\Users\\Edo\\Documents\\NetBeansProjects\\SA\\SA\\build\\classes"); 
    
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
    @Test(timeout = 2000)
    public void test7() throws Exception {
        final String fileName = "For";
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        Map<String, Integer> retValue = analyzer.analyzeClassfiles();
        assertEquals(Integer.valueOf(4),retValue.get("For.class"));   
    }
    
    @Test(timeout = 2000)
    public void test8() throws Exception {
        final String fileName = "Hello";
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\a\\b\\c\\d\\e\\"+fileName+".class"));
        assertEquals(Integer.valueOf(2),analyzer.analyzeClassfiles().get("a.b.c.d.e."+fileName+".class"));   
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
        Map<String, Integer> have = analyzer.analyzeClassfiles();
        assertEquals(Integer.valueOf(4),have.get(fileName+".class"));   
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
        Map<String, Integer> have = analyzer.analyzeClassfiles();
        assertEquals(Integer.valueOf(3),have.get(fileName+".class"));   
    }
    @Test(timeout = 2000)
    public void test20() throws Exception {
        final String fileName = "Foo";
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+fileName+".class"));
        Map<String, Integer> have = analyzer.analyzeClassfiles();
        assertEquals(Integer.valueOf(3),have.get(fileName+".class"));   
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
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"main\\TwoClasses.class"));
        assertEquals(Integer.valueOf(3),analyzer.analyzeClassfiles().get("main.TwoClasses.class"));   
    }
    @Test(timeout = 2000)
    public void test24() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"sub\\Foo.class"));
        assertEquals(Integer.valueOf(3),analyzer.analyzeClassfiles().get("sub.Foo"+".class"));   
    }
//    @Test(timeout = 20000)
//    public void test25() throws Exception {
//        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"));
//        final Map<String,Integer> have = analyzer.analyzeClassfiles();
//        System.out.println(have); 
//        assertEquals(Integer.valueOf(2),have.get("ABC"+".class"));   
//        assertEquals(Integer.valueOf(2),have.get("Anonymous"+".class"));   
//        assertEquals(Integer.valueOf(2),have.get("Anonymous$1"+".class"));   
//        assertEquals(Integer.valueOf(5),have.get("BreakContinue"+".class"));
//        assertEquals(Integer.valueOf(3),have.get("ConditionalOp"+".class"));   
//        assertEquals(Integer.valueOf(2),have.get("Finally"+".class"));   
//        assertEquals(Integer.valueOf(4),have.get("For.class")); 
//        assertEquals(Integer.valueOf(2),have.get("Hello"+".class"));          
//        assertEquals(Integer.valueOf(2),have.get("HelloAgain"+".class"));   
//        assertEquals(Integer.valueOf(10),have.get("HelloAll"+".class"));   
//        assertEquals(Integer.valueOf(3),have.get("HelloIf"+".class"));   
//        assertEquals(Integer.valueOf(4),have.get("HelloIfAnd"+".class"));   
//        assertEquals(Integer.valueOf(2),have.get("Interface"+".class"));   
//        assertEquals(Integer.valueOf(3),have.get("Lambda"+".class"));   
//        assertEquals(Integer.valueOf(8),have.get("NestedTryCatch"+".class")); 
//        assertEquals(Integer.valueOf(4),have.get("Or.class"));  
//        assertEquals(Integer.valueOf(5),have.get("PrivateFinal"+".class"));   
//        assertEquals(Integer.valueOf(4),have.get("TryCatch"+".class"));   
//        assertEquals(Integer.valueOf(5),have.get("TryCatches"+".class"));       
//        assertEquals(Integer.valueOf(3),have.get("main.TwoClasses"+".class"));
//        assertEquals(Integer.valueOf(3),have.get("Foo"+".class"));  
//        assertEquals(Integer.valueOf(3),have.get("While"+".class"));  
//        assertEquals(Integer.valueOf(2),have.get("Hello"+".class"));   
//        assertEquals(Integer.valueOf(3),have.get("TwoClasses"+".class"));   
//        assertEquals(Integer.valueOf(3),have.get("sub.Foo"+".class"));  
//        
//    }
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
    @Test(timeout = 2000)
    public void test33() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"StringReturn.class"));
        assertEquals(Integer.valueOf(3),analyzer.analyzeClassfiles().get("StringReturn.class"));   
    }
    @Test(timeout = 2000)
    public void test34() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"StringIf.class"));
        assertEquals(Integer.valueOf(3),analyzer.analyzeClassfiles().get("StringIf.class"));   
    }
    @Test(timeout = 2000)
    public void test35() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"RegexTestImplements.class"));
        assertEquals(Integer.valueOf(25),analyzer.analyzeClassfiles().get("RegexTestImplements.class"));   
    }
    @Test(timeout = 2000)
    public void test36() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"InterfaceExtends.class"));
        assertEquals(Integer.valueOf(1),analyzer.analyzeClassfiles().get("InterfaceExtends.class"));   
    }
    @Test//(timeout = 2000)
    public void test37() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"ExtendsImplements.class"));
        Map<String, Integer> have = analyzer.analyzeClassfiles();
        assertEquals(Integer.valueOf(2),have.get("edu.hm.software_architektur.a02_staticanalyzer.ExtendsImplements.class"));   
    }
    @Test//(timeout = 2000)
    public void test38() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"ABCAbstractFake.class"));
        Map<String, Integer> have = analyzer.analyzeClassfiles();
        assertEquals(Integer.valueOf(4),have.get("ABCAbstractFake.class"));   
    }
    @Test(timeout = 2000)
    public void test39() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"SimpleLambdaTest.class"));
        assertEquals(Integer.valueOf(4),analyzer.analyzeClassfiles().get("SimpleLambdaTest.class"));   
    }
    @Test(timeout = 2000)
    public void test40() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"SimpleIfTest.class"));
        assertEquals(Integer.valueOf(3),analyzer.analyzeClassfiles().get("SimpleIfTest.class"));   
    }
    @Test(timeout = 2000)
    public void test41() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"SimpleForTest.class"));
        assertEquals(Integer.valueOf(3),analyzer.analyzeClassfiles().get("SimpleForTest.class"));   
    }
    @Test(timeout = 2000)
    public void test42() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"SimpleCatchTest.class"));
        Map<String, Integer> have = analyzer.analyzeClassfiles();
        assertEquals(Integer.valueOf(4),have.get("SimpleCatchTest.class"));   
    }
    @Test(timeout = 2000)
    public void test43() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"MultipleMethodsAndThrows.class"));
        Map<String, Integer> have = analyzer.analyzeClassfiles();
        assertEquals(Integer.valueOf(9),have.get("MultipleMethodsAndThrows.class"));   
    }
    @Test(timeout = 2000)
    public void test44() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"MethodInString.class"));
        assertEquals(Integer.valueOf(2),analyzer.analyzeClassfiles().get("MethodInString.class"));   
    }
    @Test(timeout = 2000)
    public void test45() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"MarkusTest.class"));
        Map<String, Integer> have = analyzer.analyzeClassfiles();
        assertEquals(Integer.valueOf(15),have.get("MarkusTest.class"));   
    }
    @Test(timeout = 2000)
    public void test46() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"InterfaceDefault.class"));
        assertEquals(Integer.valueOf(2),analyzer.analyzeClassfiles().get("InterfaceDefault.class"));   
    }
    @Test(timeout = 2000)
    public void test47() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"ImplementsTest.class"));
        assertEquals(Integer.valueOf(3),analyzer.analyzeClassfiles().get("ImplementsTest.class"));   
    }
    @Test(timeout = 2000)
    public void test48() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"ifeq.class"));
        assertEquals(Integer.valueOf(2),analyzer.analyzeClassfiles().get("ifeq.class"));   
    }
    @Test(timeout = 2000)
    public void test49() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"HelloJava.class"));
        assertEquals(Integer.valueOf(2),analyzer.analyzeClassfiles().get("HelloJava.class"));   
    }
    @Test(timeout = 2000)
    public void test50() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"FirstClass.class"));
        assertEquals(Integer.valueOf(4),analyzer.analyzeClassfiles().get("FirstClass.class"));   
    }
    @Test(timeout = 2000)
    public void test51() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"InheritedClass.class"));
        assertEquals(Integer.valueOf(2),analyzer.analyzeClassfiles().get("InheritedClass.class"));   
    }
    @Test(timeout = 2000)
    public void test52() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"FakeAnonymous.class"));
        assertEquals(Integer.valueOf(3),analyzer.analyzeClassfiles().get("FakeAnonymous.class"));   
    }
    @Test//(timeout = 2000)
    public void test53() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"gaul\\DeepPackageAnonymous\\DeepPackageAnonymous.class"));
        Map<String, Integer> have = analyzer.analyzeClassfiles();
        assertEquals(Integer.valueOf(4),have.get("edu.hm.gaul.DeepPackageAnonymous.DeepPackageAnonymous.class"));   
    }
    @Test(timeout = 2000)
    public void test54() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"gaul\\DeepPackageAnonymous\\DeepPackageFakeAnonym$1.class"));
        assertEquals(Integer.valueOf(4),analyzer.analyzeClassfiles().get("edu.hm.gaul.DeepPackageAnonymous.DeepPackageFakeAnonym$1.class"));   
    }
    @Test(timeout = 2000)
    public void test55() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"gaul\\DeepPackageAnonymous\\DeepPackageAnonymous.class"));
        assertEquals(Integer.valueOf(4),analyzer.analyzeClassfiles().get("edu.hm.gaul.DeepPackageAnonymous.DeepPackageAnonymous.class"));   
    }
    @Test(timeout = 2000)
    public void test56() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"CustomException.class"));
        assertEquals(Integer.valueOf(4),analyzer.analyzeClassfiles().get("CustomException.class"));   
    }
    @Test(timeout = 2000)
    public void test57() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"CTors.class"));
        assertEquals(Integer.valueOf(4),analyzer.analyzeClassfiles().get("CTors.class"));   
    }
    @Test(timeout = 2000)
    public void test58() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"CodeInSystem.class"));
        assertEquals(Integer.valueOf(2),analyzer.analyzeClassfiles().get("CodeInSystem.class"));   
    }
    @Test(timeout = 2000)
    public void test59() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"Constructor.class"));
        assertEquals(Integer.valueOf(3),analyzer.analyzeClassfiles().get("Constructor.class"));   
    }
    @Test(timeout = 2000)
    public void test60() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"DoWhile.class"));
        assertEquals(Integer.valueOf(3),analyzer.analyzeClassfiles().get("DoWhile.class"));   
    }
//    @Test(timeout = 2000)
//    public void test61() throws Exception {
//        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"Endless.class"));
//        Map<String, Integer> have = analyzer.analyzeClassfiles();
//        assertEquals(Integer.valueOf(4),have.get("Endless.class"));   
//    }
//    @Test(timeout = 2000)
//    public void test62() throws Exception {
//        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"EndlessWithBreak.class"));
//        Map<String, Integer> have = analyzer.analyzeClassfiles();
//        assertEquals(Integer.valueOf(5),have.get("EndlessWithBreak.class"));   
//    }
    @Test(timeout = 2000)
    public void test63() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"ExceptionTableInSystem.class"));
        assertEquals(Integer.valueOf(4),analyzer.analyzeClassfiles().get("ExceptionTableInSystem.class"));   
    }
    @Test(timeout = 2000)
    public void test64() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"IfInSystem.class"));
        assertEquals(Integer.valueOf(2),analyzer.analyzeClassfiles().get("IfInSystem.class"));   
    }
    @Test(timeout = 2000)
    public void test65() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"CommentInside1.class"));
        assertEquals(Integer.valueOf(2),analyzer.analyzeClassfiles().get("CommentInside1.class"));   
    }
    @Test(timeout = 2000)
    public void test66() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"CommentInside2.class"));
        assertEquals(Integer.valueOf(2),analyzer.analyzeClassfiles().get("CommentInside2.class"));   
    }
    @Test(timeout = 2000)
    public void test67() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"CommentInside3.class"));
        assertEquals(Integer.valueOf(2),analyzer.analyzeClassfiles().get("CommentInside3.class"));   
    }
    @Test(timeout = 2000)
    public void test68() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"OnlyClass.class"));
        assertEquals(Integer.valueOf(1),analyzer.analyzeClassfiles().get("OnlyClass.class"));   
    }
    @Test(timeout = 2000)
    public void test69() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"WhileTrue1.class"));
        assertEquals(Integer.valueOf(2),analyzer.analyzeClassfiles().get("WhileTrue1.class"));   
    }
    @Test(timeout = 2000)
    public void test70() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"WhileTrue2.class"));
        assertEquals(Integer.valueOf(3),analyzer.analyzeClassfiles().get("WhileTrue2.class"));   
    }
    @Test(timeout = 2000)
    public void test71() throws Exception {
        ComplexityAnalyzer analyzer = new MyComplexityAnalyzer().setRootdir(Paths.get(path.toAbsolutePath().toString()+"\\"+"WhileTrue3.class"));
        Map<String, Integer> have = analyzer.analyzeClassfiles();
        assertEquals(Integer.valueOf(3),have.get("WhileTrue3.class"));   
    }   
}