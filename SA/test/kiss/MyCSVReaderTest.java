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
    
    final public static String FILE1 = "./CSVTestFile1.txt";
    final public static String FILE2 = "./CSVTestFile2.txt";
    final public static String FILE3 = "./CSVTestFile3.txt";
    final public static String FILE4 = "./CSVTestFile4.txt";
    final public static String FILE5 = "./CSVTestFile5.txt";
    final public static String FILE6 = "./CSVTestFile6.txt";
    
    
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
        
        final String[][] expResult = new String[][]{new String[]{"1","23","4","5","6","78","9"}};
        
        Assert.assertArrayEquals(expResult, result);
    }
    
    @Test(timeout = 1000)
    public void testReadEntwerteEntwerter6() throws Exception {
        final Reader reader = new FileReader(FILE5);
        final MyCSVReader sut = new MyCSVReader();
        final String[][] result = sut.read(reader);
        
        final String[][] expResult = new String[][]{new String[]{"1","\\","3","4","5","6","7","8","9"}};
       
        Assert.assertArrayEquals(expResult, result);
    }
    
}
