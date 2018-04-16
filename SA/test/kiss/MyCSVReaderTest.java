package kiss;

import edu.hm.peither_bartolov.a01_csvreader.MyCSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Edo
 */
public class MyCSVReaderTest {
    
//    public static final String LOCATION = "C:\\Users\\Computer\\Documents\\NetBeansProjects\\SA\\SA\\test\\kiss\\";
    public static final String LOCATION = "C:\\Users\\Edo\\Documents\\NetBeansProjects\\SA\\SA\\test\\kiss\\";
//    public static final String LOCATION = "C:\\Users\\Eduard\\Documents\\NetBeansProjects\\SA\\SA\\test\\kiss\\";
    
    public static final String FILE1 = LOCATION+"CSVTestFile1.txt";
    public static final String FILE2 = LOCATION+"CSVTestFile2.txt";
    public static final String FILE3 = LOCATION+"CSVTestFile3.txt";
    public static final String FILE4 = LOCATION+"CSVTestFile4.txt";
    public static final String FILE5 = LOCATION+"CSVTestFile5.txt";
    public static final String FILE6 = LOCATION+"CSVTestFile6.txt";
    public static final String FILE7 = LOCATION+"CSVTestFile7.txt";
    public static final String FILE8 = LOCATION+"CSVTestFile8.txt";
    public static final String FILE9 = LOCATION+"CSVTestFile9.txt";
    public static final String FILE10 = LOCATION+"CSVTestFile10.txt";
    public static final String FILE11 = LOCATION+"CSVTestFile11.txt";
    public static final String FILE12 = LOCATION+"CSVTestFile12.txt";
    public static final String FILE13 = LOCATION+"CSVTestFile13.txt";
    public static final String FILE14 = LOCATION+"CSVTestFile14.txt";
    public static final String FILE15 = LOCATION+"CSVTestFile15.txt";
    public static final String FILE16 = LOCATION+"CSVTestFile16.txt";
    public static final String FILE17 = LOCATION+"CSVTestFile17.txt";
    public static final String FILE18 = LOCATION+"CSVTestFile18.txt";
    public static final String FILE19 = LOCATION+"CSVTestFile19.txt";
    public static final String FILE20 = LOCATION+"CSVTestFile20.txt";
        
    public MyCSVReaderTest() {
    }

    @Test(timeout = 1000)
    public void testReadsimple1() throws Exception {
        final Reader reader = new FileReader(FILE1);
        final MyCSVReader sut = new MyCSVReader();
        final String[][] result = sut.read(reader);
        
        final String[][] expResult = new String[][]{new String[]{"1","2","3","4","5","6","7","8","9"}};
        
        Assert.assertArrayEquals(expResult, result);
    }
    
    @Test(timeout = 1000)
    public void testRead2simpleTwoLines() throws Exception {
        final Reader reader = new FileReader(FILE2);
        final MyCSVReader sut = new MyCSVReader();
        final String[][] result = sut.read(reader);
        
        final String[][] expResult = new String[][]{new String[]{"1","2","3","4","5","6","7","8","9"},
                                                    new String[]{"1","2","3","4","5","6","7","8","9"}};
        
        Assert.assertArrayEquals(expResult, result);
    }
    
    @Test(timeout = 1000)
    public void testRead3simple50Lines() throws Exception {
        final Reader reader = new FileReader(FILE3);
        final MyCSVReader sut = new MyCSVReader();
        final String[][] result = sut.read(reader);
        
        final String[][] expResult = new String[][]{
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            new String[]{"1","2","3","4","5","6","7","8","9"},
            };
        
        Assert.assertArrayEquals(expResult, result);
    }
    
    @Test(timeout = 1000,expected = IllegalArgumentException.class)
    public void testReadEmptyError4() throws Exception {
        final Reader reader = new FileReader(FILE4);
        final MyCSVReader sut = new MyCSVReader();
        sut.read(reader);
    }
    
    @Test(timeout = 1000)
    public void testReadEntwerteKomma5() throws Exception {
        final Reader reader = new FileReader(FILE5);
        final MyCSVReader sut = new MyCSVReader();
        final String[][] result = sut.read(reader);
        
        final String[][] expResult = new String[][]{new String[]{"1","2,3","4","5","6","7,8","9"}};
        
        Assert.assertArrayEquals(expResult, result);
    }
    
    @Test//(timeout = 1000)
    public void testReadEntwerteEntwerter6() throws Exception {
        final Reader reader = new FileReader(FILE6);
        final MyCSVReader sut = new MyCSVReader();
        final String[][] result = sut.read(reader);
        
        final String[][] expResult = new String[][]{new String[]{"1","\\","3","4","5","6","7","8","9"}};
       
        Assert.assertArrayEquals(expResult, result);
    }
    
    @Test(timeout = 1000)
    public void testReadEntwerteEnter7() throws Exception {
        final Reader reader = new FileReader(FILE7);
        final MyCSVReader sut = new MyCSVReader();
        final String[][] result = sut.read(reader);
        
        final String[][] expResult = new String[][]{new String[]{"1","2","3","4","5\n6","7","8","9"}};
       
        Assert.assertArrayEquals(expResult, result);
    }
    
    @Test(timeout = 1000)
    public void testReadDoppelEntwerter8() throws Exception {
        final Reader reader = new FileReader(FILE8);
        final MyCSVReader sut = new MyCSVReader();
        final String[][] result = sut.read(reader);
        
        final String[][] expResult = new String[][]{new String[]{"1","2","3","4","5\\"},new String[]{"6","7","8","9"}};
       
        Assert.assertArrayEquals(expResult, result);
    }
    
    @Test(timeout = 1000)
    public void testReadDoppelEntwerter9() throws Exception {
        final Reader reader = new FileReader(FILE9);
        final MyCSVReader sut = new MyCSVReader();
        final String[][] result = sut.read(reader);
        
        final String[][] expResult = new String[][]{
            new String[]{"12","34"},
            new String[]{"12","34","56"},
            new String[]{"12","34","56","78"}};
       
        Assert.assertArrayEquals(expResult, result);
    }
    
    @Test(timeout = 1000)
    public void testReadleinEndEntwerter10() throws Exception {
        final Reader reader = new FileReader(FILE10);
        final MyCSVReader sut = new MyCSVReader();
        final String[][] result = sut.read(reader);
        
        final String[][] expResult = new String[][]{
            new String[]{"12","34\n56","78"},
            new String[]{"90"}};
       
        Assert.assertArrayEquals(expResult, result);
    }
    
    @Test(timeout = 1000)
    public void testReadKommaEntwerter11() throws Exception {
        final Reader reader = new FileReader(FILE11);
        final MyCSVReader sut = new MyCSVReader();
        final String[][] result = sut.read(reader);
        
        final String[][] expResult = new String[][]{
            new String[]{"hallo","dies","ist","ein"},
            new String[]{"text","in","csv"},
            new String[]{"format",",mit"},
            new String[]{"kommasetzung"}};
       
        Assert.assertArrayEquals(expResult, result);
    }
    
    @Test//(timeout = 1000)
    public void testReadVerschiedeneEntwerter12() throws Exception {
        final Reader reader = new FileReader(FILE12);
        final MyCSVReader sut = new MyCSVReader();
        final String[][] result = sut.read(reader);
        
        final String[][] expResult = new String[][]{
            new String[]{"dies","ist","ein","test,\nmit","\\verschiedenen\\"},
            new String[]{"Entwertern."}};
       
        Assert.assertArrayEquals(expResult, result);
    }
    
    @Test(timeout = 1000,expected = IllegalArgumentException.class)
    public void testReadEnterfehltamEnde13() throws Exception {
        final Reader reader = new FileReader(FILE13);
        final MyCSVReader sut = new MyCSVReader();
        sut.read(reader);
    }
    
    @Test(timeout = 1000,expected = IllegalArgumentException.class)
    public void testReadBackSlashamEnde14() throws Exception {
        final Reader reader = new FileReader(FILE14);
        final MyCSVReader sut = new MyCSVReader();
        sut.read(reader);
    }
    
    @Test(timeout = 1000)
    public void testReadLeer15() throws Exception {
        final Reader reader = new FileReader(FILE15);
        final MyCSVReader sut = new MyCSVReader();
        final String[][] result = sut.read(reader);
        
        final String[][] expResult = new String[][]{
            new String[]{"","","","",""}};
       
        Assert.assertArrayEquals(expResult, result);
    }
    
    @Test(timeout = 1000)
    public void testReadLeermitEnter16() throws Exception {
        final Reader reader = new FileReader(FILE16);
        final MyCSVReader sut = new MyCSVReader();
        final String[][] result = sut.read(reader);
        
        final String[][] expResult = new String[][]{
            new String[]{"","","","",""},
            new String[]{"","","","",""}};
       
        Assert.assertArrayEquals(expResult, result);
    }
    
    @Test(timeout = 1000)
    public void testReadBackSlashanfangundueberall17() throws Exception {
        final Reader reader = new FileReader(FILE17);
        final MyCSVReader sut = new MyCSVReader();
        final String[][] result = sut.read(reader);
        
        final String[][] expResult = new String[][]{
            new String[]{",",",",",",",",","}};
       
        Assert.assertArrayEquals(expResult, result);
    }
    
    @Test(timeout = 1000)
    public void testReadTripleBackSlashueberall18() throws Exception {
        final Reader reader = new FileReader(FILE18);
        final MyCSVReader sut = new MyCSVReader();
        final String[][] result = sut.read(reader);
        
        final String[][] expResult = new String[][]{
            new String[]{"\\,\\" , "\\"}};
       
        Assert.assertArrayEquals(expResult, result);
    }
    
    @Test(timeout = 1000)
    public void testReadTripleBackSlashEnter19() throws Exception {
        final Reader reader = new FileReader(FILE19);
        final MyCSVReader sut = new MyCSVReader();
        final String[][] result = sut.read(reader);
        final String[][] expResult = new String[][]{
            new String[]{"\\,\\\nf"}};
        
        Assert.assertArrayEquals(expResult, result);
    }
    
    
    //Tests from Michi
    @Test(timeout = 1000, expected = IllegalArgumentException.class)
    public void testEmptyCSVFile20() throws IOException {
        final String sut = "";
        new MyCSVReader().read(new StringReader(sut));
    }

    @Test(timeout = 1000, expected = IllegalArgumentException.class)
    public void testNoNewLineAtEnd21() throws IOException {
        final String sut = "bla";
        new MyCSVReader().read(new StringReader(sut));
    }

    @Test(timeout = 1000, expected = IllegalArgumentException.class)
    public void testNoNewLineAtEnd22() throws IOException {
        final String sut = "bla,bla";
        new MyCSVReader().read(new StringReader(sut));
    }

    @Test(timeout = 1000, expected = IllegalArgumentException.class)
    public void testNoNewLineAtEnd23() throws IOException {
        final String sut = "bla,bla\nbla";
        new MyCSVReader().read(new StringReader(sut));
    }

    @Test(timeout = 1000, expected = IllegalArgumentException.class)
    public void testNoNewLineAtEnd24() throws IOException {
        final String sut = "bla\\\n";
        new MyCSVReader().read(new StringReader(sut));
    }

    @Test(timeout = 1000, expected = IllegalArgumentException.class)
    public void testOnlyEscapedAtEnd25() throws IOException {
        final String sut = "\\";
        new MyCSVReader().read(new StringReader(sut));
    }

    @Test(timeout = 1000, expected = IllegalArgumentException.class)
    public void testOnlyEscapedAtEnd26() throws IOException {
        final String sut = "bla\\";
        new MyCSVReader().read(new StringReader(sut));
    }

    @Test(timeout = 1000, expected = IllegalArgumentException.class)
    public void testOnlyEscapedAtEnd27() throws IOException {
        final String sut = "bla,bla\\";
        new MyCSVReader().read(new StringReader(sut));
    }

    @Test(timeout = 1000, expected = IllegalArgumentException.class)
    public void testOnlyEscapedAtEnd28() throws IOException {
        final String sut = "bla,bla\nbla\\";
        new MyCSVReader().read(new StringReader(sut));
    }

    @Test(timeout = 1000, expected = IllegalArgumentException.class)
    public void testOnlyEscapedAtEnd29() throws IOException {
        final String sut = "bla\n\\";
        new MyCSVReader().read(new StringReader(sut));
    }
    
    //End from Tests of Michi
    
    @Test(timeout = 1000)
    public void testStuff30() throws IOException {
        final String sut = "Hello, World!\n AnyBody, out there?\n";
        final String[][] result = new MyCSVReader().read(new StringReader(sut));
        
        final String[][] expResult = new String[][]{
            new String[]{"Hello" , " World!"},
            new String[]{" AnyBody" , " out there?"}};
       
        Assert.assertArrayEquals(expResult, result);
    }
    
    @Test(timeout = 1000)
    public void testStuff31() throws IOException {
        final String sut = "a\n";
        final String[][] result = new MyCSVReader().read(new StringReader(sut));
        
        final String[][] expResult = new String[][]{
            new String[]{"a"}};
       
        Assert.assertArrayEquals(expResult, result);
    }
    
    @Test//(timeout = 1000)
    public void testStuff32() throws IOException {
        final String sut = "\n";
        final String[][] result = new MyCSVReader().read(new StringReader(sut));
        
        final String[][] expResult = new String[][]{
            new String[0]};
       
        Assert.assertArrayEquals(expResult, result);
    }
    
    @Test(timeout = 1000)
    public void testStuff33() throws IOException {
        final String sut = "\\a\n";
        final String[][] result = new MyCSVReader().read(new StringReader(sut));
        
        final String[][] expResult = new String[][]{
            new String[]{"a"}};
       
        Assert.assertArrayEquals(expResult, result);
    }
    
    @Test(timeout = 1000)
    public void testStuff34() throws IOException {
        final String sut = "a\nb\n";
        final String[][] result = new MyCSVReader().read(new StringReader(sut));
        
        final String[][] expResult = new String[][]{
            new String[]{"a"},
            new String[]{"b"}};
       
        Assert.assertArrayEquals(expResult, result);
    }
    
    @Test(timeout = 1000)
    public void testStuff35() throws IOException {
        final String sut = "a\n\\,b\n";
        final String[][] result = new MyCSVReader().read(new StringReader(sut));
        
        final String[][] expResult = new String[][]{
            new String[]{"a"},
            new String[]{",b"}};
       
        Assert.assertArrayEquals(expResult, result);
    }
    
    @Test(timeout = 1000 , expected = IllegalArgumentException.class)
    public void testStuff36() throws IOException {
        final String sut = "a\n\\,b\\n";
        final String[][] result = new MyCSVReader().read(new StringReader(sut));
 
    }
    
        @Test(timeout = 1000)
    public void testStuff37() throws IOException {
        final String sut = "a\n\\,b                               \n";
        final String[][] result = new MyCSVReader().read(new StringReader(sut));
 
    }
    
    @Test//(timeout = 1000)
    public void testStuff38() throws IOException {
        final Reader reader = new FileReader(FILE20);
        final MyCSVReader sut = new MyCSVReader();
        final String[][] result = sut.read(reader);
    }
}
