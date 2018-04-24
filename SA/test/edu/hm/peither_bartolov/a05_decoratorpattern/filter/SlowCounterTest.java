package edu.hm.peither_bartolov.a05_decoratorpattern.filter;

import edu.hm.peither_bartolov.a05_decoratorpattern.Counter;
import edu.hm.peither_bartolov.a05_decoratorpattern.base.LoopCounter;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Edo
 */
public class SlowCounterTest {
    
    public SlowCounterTest() {
    }

    
    
    
    @Test(expected = IllegalArgumentException.class)
    public void testTick1() {
        final Counter counter = new SlowCounter(new LoopCounter(1,2,3),0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testTick2() {
        final Counter counter = new SlowCounter(new LoopCounter(1,2,3),-1);
    }
    
    @Test
    public void testTick3() {
        final Counter counter = new SlowCounter(new LoopCounter(1,2,3),1);
        assertEquals(1,counter.read());
        assertEquals(1,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(3,counter.tick().read());
        assertEquals(3,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(2,counter.tick().read());
    }
    
}
