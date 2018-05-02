package edu.hm.bartolov.a05_decoratorpattern.filter;

import edu.hm.cs.rs.arch.a05_decorator.Counter;
import edu.hm.cs.rs.arch.a05_decorator.UCounter;
import edu.hm.bartolov.a05_decoratorpattern.base.LoopCounter;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Edo
 */
public class SelectedCounterTest {
    
    public SelectedCounterTest() {
    }

    
    @Test(expected = NullPointerException.class)
    public void testTick1() {
        final Counter counter = new SelectedCounter(new LoopCounter(1,2,3),null);
    }
    
    @Test
    public void testTick2() {
        final Counter counter = new SelectedCounter(new UCounter(),n-> n%3==0);
        assertEquals(0,counter.read());
        assertEquals(3,counter.tick().read());
        assertEquals(6,counter.tick().read());
        assertEquals(9,counter.tick().read());
        assertEquals(12,counter.tick().read());
        assertEquals(15,counter.tick().read());
        assertEquals(18,counter.tick().read());
        assertEquals(21,counter.tick().read());
        assertEquals(24,counter.tick().read());
    }
    
    @Test
    public void testTick3() {
        final Counter counter = new SelectedCounter(new UCounter(),n-> n%1000==0);
        assertEquals(0,counter.read());
        assertEquals(1000,counter.tick().read());
        assertEquals(2000,counter.tick().read());
        assertEquals(3000,counter.tick().read());
        assertEquals(4000,counter.tick().read());
    }
    
    @Test
    public void testTick4() {
        final Counter counter = new SelectedCounter(new UCounter(),n-> true);
        assertEquals(0,counter.read());
        assertEquals(1,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(3,counter.tick().read());
        assertEquals(4,counter.tick().read());
    }
    
    @Test(expected = NullPointerException.class)
    public void testTick5() {
        final Counter counter = new SelectedCounter(null,n -> true);
    }
    
    @Test
    public void testTick6() {
        final Counter counter = new SelectedCounter(new UCounter(),n-> n%15 == 0);
        assertEquals(0,counter.read());
        assertEquals(15,counter.tick().tick().tick().read());
        assertEquals(30,counter.tick().tick().tick().read());
        assertEquals(45,counter.tick().tick().tick().read());
        assertEquals(60,counter.tick().tick().tick().read());
    }
    
    @Test(expected = NullPointerException.class)
    public void testTick0() {
        final Counter counter = new SelectedCounter(null, n-> n%3==0);
    }

    @Test
    public void testTick7() {
        final Counter counter = new SelectedCounter(new UCounter(),n-> n%2 == 0);

        assertEquals(0,counter.read());
        assertEquals(2,counter.tick().read());
        assertEquals(4,counter.tick().read());
        assertEquals(6,counter.tick().read());
        assertEquals(8,counter.tick().read());
        assertEquals(10,counter.tick().read());


    }

    @Test
    public void testTick8() {
        final Counter counter = new SelectedCounter(new UCounter(), n -> n > 1000);
        assertEquals(1001, counter.read());
        assertEquals(1002, counter.tick().read());
    }

    @Test
    public void testTick9() {
        final Counter counter = new SelectedCounter(new UCounter(),n-> n%3==1);
        assertEquals(1,counter.read());
        assertEquals(4,counter.tick().read());
        assertEquals(7,counter.tick().read());
        assertEquals(10,counter.tick().read());
    }
    
    @Test
    public void testTick10() {
        final Counter counter = new SelectedCounter(new UCounter(),n-> n%15 == 0);
        assertEquals(0,counter.read());
        assertEquals(15,counter.tick().tick().tick().read());
        assertEquals(30,counter.tick().tick().tick().read());
        assertEquals(45,counter.tick().tick().tick().read());
        assertEquals(60,counter.tick().tick().tick().read());
    }

    @Test
    public void testTick11() {
        final Counter counter = new SelectedCounter(new UCounter(),n-> n == Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE,counter.read());
    }

    @Test
    public void testTick12() {
        final Counter counter = new SelectedCounter(new UCounter(),n-> n%2 == 0);
        System.out.println(0%2);

        assertEquals(0,counter.read());
        assertEquals(2,counter.tick().read());
        assertEquals(4,counter.tick().read());
        assertEquals(6,counter.tick().read());
        assertEquals(8,counter.tick().read());
        assertEquals(10,counter.tick().read());


    }

    @Test
    public void testTick13() {
        final Counter counter = new SelectedCounter(new UCounter(), n -> n > 1000);
        assertEquals(1001, counter.read());
        assertEquals(1002, counter.tick().read());
    }

    @Test
    public void testTick14() {
        final Counter counter = new SelectedCounter(new UCounter(),n-> n%3==1);
        assertEquals(1,counter.read());
        assertEquals(4,counter.tick().read());
        assertEquals(7,counter.tick().read());
        assertEquals(10,counter.tick().read());
    }
}
