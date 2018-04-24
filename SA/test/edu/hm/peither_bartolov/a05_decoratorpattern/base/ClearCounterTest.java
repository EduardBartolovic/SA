package edu.hm.peither_bartolov.a05_decoratorpattern.base;

import edu.hm.peither_bartolov.a05_decoratorpattern.Counter;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Edo
 */
public class ClearCounterTest {
    
    public ClearCounterTest() {
    }

    @Test
    public void testTick1() throws InterruptedException {
        final Counter counter = new ClearCounter();
        assertEquals(0,counter.read());
        Thread.sleep(100);
        assertEquals(1,counter.tick().read());
        Thread.sleep(100);
        assertEquals(2,counter.tick().read());
        Thread.sleep(100);
        assertEquals(3,counter.tick().read());
        Thread.sleep(100);
        assertEquals(4,counter.tick().read());
        Thread.sleep(100);
        assertEquals(5,counter.tick().read());
   
    }
    
}
