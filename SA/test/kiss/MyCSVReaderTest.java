/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    public MyCSVReaderTest() {
    }

    @Test(timeout = 1000)
    public void testReadsimple1() throws Exception {
        final Reader reader = new FileReader("./CSVTestFile1");
        final MyCSVReader sut = new MyCSVReader();
        final String[][] result = sut.read(reader);
        
        final String[][] expResult = new String[][]{new String[]{"1","2","3","4","5","6","7","8","9"}};
        
        Assert.assertArrayEquals(expResult, result);
    }
    
    @Test(timeout = 1000)
    public void testRead2simpleTwoLines() throws Exception {
        final Reader reader = new FileReader("./CSVTestFile2");
        final MyCSVReader sut = new MyCSVReader();
        final String[][] result = sut.read(reader);
        
        final String[][] expResult = new String[][]{new String[]{"1","2","3","4","5","6","7","8","9"},
                                                    new String[]{"1","2","3","4","5","6","7","8","9"}};
        
        Assert.assertArrayEquals(expResult, result);
    }
    
    @Test(timeout = 1000)
    public void testRead3simple50Lines() throws Exception {
        final Reader reader = new FileReader("./CSVTestFile3");
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
    
}
