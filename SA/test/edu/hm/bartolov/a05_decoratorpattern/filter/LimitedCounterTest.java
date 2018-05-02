package edu.hm.bartolov.a05_decoratorpattern.filter;

import edu.hm.cs.rs.arch.a05_decorator.Counter;
import edu.hm.cs.rs.arch.a05_decorator.UCounter;
import edu.hm.bartolov.a05_decoratorpattern.base.LoopCounter;
import edu.hm.bartolov.a05_decoratorpattern.base.NaryCounter;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Edo
 */
public class LimitedCounterTest {
    
    public LimitedCounterTest() {
    }

    @Test()
    public void testTick1() {
        final Counter counter = new LimitedCounter(new LoopCounter(1,2,3),0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testTick2() {
        final Counter counter = new LimitedCounter(new LoopCounter(1,2,3),-1);
    }
    
    @Test
    public void testTick3() {
        final Counter counter = new LimitedCounter(new LoopCounter(0,1,2,3),1);
        assertEquals(0,counter.read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(0,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(0,counter.tick().read());
    }
    
    @Test
    public void testTick4() {
        final Counter counter = new LimitedCounter(new LoopCounter(0,1,2,3),1);
        assertEquals(0,counter.read());
        assertEquals(0,counter.read());
        assertEquals(0,counter.read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(0,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
    }
    
    @Test
    public void testTick5() {
        final Counter counter = new LimitedCounter(new UCounter(),7);
        assertEquals(0,counter.read());
        assertEquals(1,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(3,counter.tick().read());
        assertEquals(4,counter.tick().read());
        assertEquals(5,counter.tick().read());
        assertEquals(6,counter.tick().read());
        assertEquals(7,counter.tick().read());
        assertEquals(7,counter.tick().read());
        assertEquals(7,counter.tick().read());
        assertEquals(7,counter.tick().read());
        assertEquals(7,counter.tick().read());
        assertEquals(7,counter.tick().read());
    }
    @Test
    public void testTick6() {
        final Counter counter = new LimitedCounter(new LoopCounter(1,2,3),2);
        assertEquals(1,counter.read());
        assertEquals(2,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(1,counter.tick().read());
    }
    
    @Test(expected = NullPointerException.class)
    public void testTick7() {
        final Counter counter = new LimitedCounter(null,100);
    }
    
    @Test
    public void testTick8() {
        final Counter counter = new LimitedCounter(new NaryCounter(2), 3);
        assertEquals(0, counter.read());
        assertEquals(1, counter.tick().read());
        assertEquals(3, counter.tick().read());
        assertEquals(3, counter.tick().read());
    }

    
}
