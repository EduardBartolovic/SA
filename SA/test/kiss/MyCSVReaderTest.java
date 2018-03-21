package kiss;

import java.io.FileReader;
import java.io.Reader;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Edo
 */
public class MyCSVReaderTest {
    
    //public static final String LOCATION = "C:\\Users\\Computer\\Documents\\NetBeansProjects\\SA\\SA\\test\\kiss\\";
    public static final String LOCATION = "C:\\Users\\Edo\\Documents\\NetBeansProjects\\SA\\SA\\test\\kiss\\";
    
    public static final String FILE1 = LOCATION+"CSVTestFile1.txt";
    public static final String FILE2 = LOCATION+"CSVTestFile2.txt";
    public static final String FILE3 = LOCATION+"CSVTestFile3.txt";
    public static final String FILE4 = LOCATION+"CSVTestFile4.txt";
    public static final String FILE5 = LOCATION+"CSVTestFile5.txt";
    public static final String FILE6 = LOCATION+"CSVTestFile6.txt";
    public static final String FILE7 = LOCATION+"CSVTestFile7.txt";
        
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
    
    @Test/*(timeout = 1000)*/
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
        
        final String[][] expResult = new String[][]{new String[]{"1","23","4","5","6","78","9"}};
        
        Assert.assertArrayEquals(expResult, result);
    }
    
    @Test(timeout = 1000)
    public void testReadEntwerteEntwerter6() throws Exception {
        final Reader reader = new FileReader(FILE6);
        final MyCSVReader sut = new MyCSVReader();
        final String[][] result = sut.read(reader);
        
        final String[][] expResult = new String[][]{new String[]{"1","\\","3","4","5","6","7","8","9"}};
       
        Assert.assertArrayEquals(expResult, result);
    }
    
    //++++++++++++++++++++++++++++++++++++++++++++++++++anschauen wegen , zwischen 5 und 6
    @Test(timeout = 1000)
    public void testReadEntwerteEnter7() throws Exception {
        final Reader reader = new FileReader(FILE7);
        final MyCSVReader sut = new MyCSVReader();
        final String[][] result = sut.read(reader);
        
        final String[][] expResult = new String[][]{new String[]{"1","2","3","4","56","7","8","9"}};
       
        Assert.assertArrayEquals(expResult, result);
    }
    //+++++++++++++++++++++++++++++++++++++++++
    
    
}
