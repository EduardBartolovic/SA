package edu.hm.peither_bartolov.a05_decoratorpattern.filter;

import edu.hm.cs.rs.arch.a05_decorator.Counter;
import edu.hm.cs.rs.arch.a05_decorator.UCounter;
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
        final Counter counter = new SlowCounter(new LoopCounter(1,2,3),2);
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
    
    @Test
    public void testTick4() {
        final Counter counter = new SlowCounter(new UCounter(),2);
        assertEquals(0,counter.read());
        assertEquals(0,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(3,counter.tick().read());
        assertEquals(3,counter.tick().read());
        assertEquals(4,counter.tick().read());
        assertEquals(4,counter.tick().read());
        assertEquals(5,counter.tick().read());
    }
    
    @Test
    public void testTick5() {
        final Counter counter = new SlowCounter(new LoopCounter(1,2,3),1);
        assertEquals(1,counter.read());
        assertEquals(2,counter.tick().read());
        assertEquals(3,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(2,counter.tick().read());
    }
    
}
