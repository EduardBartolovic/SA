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
public class JumpCounterTest {
    
    public JumpCounterTest() {
    }

    @Test()
    public void testTick1() {
        final Counter counter = new JumpCounter(new LoopCounter(1,2,3),0);
        assertEquals(1,counter.read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testTick2() {
        final Counter counter = new JumpCounter(new LoopCounter(1,2,3),-1);
    }
    
    @Test
    public void testTick3() {
        final Counter counter = new JumpCounter(new LoopCounter(0,1,2,3),1);
        assertEquals(0,counter.read());
        assertEquals(1,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(3,counter.tick().read());
        assertEquals(0,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(3,counter.tick().read());
        assertEquals(0,counter.tick().read());
    }
    
    @Test
    public void testTick4() {
        final Counter counter = new JumpCounter(new UCounter(),2);
        assertEquals(0,counter.read());
        assertEquals(2,counter.tick().read());
        assertEquals(4,counter.tick().read());
        assertEquals(6,counter.tick().read());
        assertEquals(8,counter.tick().read());
        assertEquals(10,counter.tick().read());
        assertEquals(12,counter.tick().read());
        assertEquals(14,counter.tick().read());
        assertEquals(16,counter.tick().read());
    }
    
    @Test
    public void testTick5() {
        final Counter counter = new JumpCounter(new LoopCounter(1,2,3),2);
        assertEquals(1,counter.read());
        assertEquals(3,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(3,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(3,counter.tick().read());
        assertEquals(2,counter.tick().read());
    }
    
    @Test
    public void testTick6() {
        final Counter counter = new JumpCounter(new JumpCounter(new UCounter(),2),3);
        assertEquals(0,counter.read());
        assertEquals(6,counter.tick().read());
        assertEquals(12,counter.tick().read());
        assertEquals(18,counter.tick().read());
        assertEquals(24,counter.tick().read());
        assertEquals(30,counter.tick().read());
        assertEquals(36,counter.tick().read());
        assertEquals(42,counter.tick().read());
    }
    
    @Test(expected = NullPointerException.class)
    public void testTick7() {
        final Counter counter = new JumpCounter(null,100);
    }
    
     @Test
    public void testTick8() {
        final Counter counter = new JumpCounter(new NaryCounter(2),2);
        assertEquals(0,counter.read());
        assertEquals(10,counter.tick().read());
        assertEquals(100,counter.tick().read());
        assertEquals(110,counter.tick().read());
        assertEquals(1000,counter.tick().read());
        assertEquals(1010,counter.tick().read());
        assertEquals(1100,counter.tick().read());
        assertEquals(1110,counter.tick().read());
    }

    @Test
    public void testTick9() {
        final Counter counter = new JumpCounter(new NaryCounter(2),3);
        assertEquals(0,counter.read());
        assertEquals(11,counter.tick().read());
        assertEquals(110,counter.tick().read());
        assertEquals(1001,counter.tick().read());
        assertEquals(1100,counter.tick().read());
        assertEquals(1111,counter.tick().read());
    }
    
}
