
package edu.hm.bartolov.a05_decoratorpattern.base;

import edu.hm.cs.rs.arch.a05_decorator.Counter;
import java.util.NoSuchElementException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Edo
 */
public class LoopCounterTest {
    
    public LoopCounterTest() {
    }

    @Test(expected = NoSuchElementException.class)
    public void testSomeMethod0() {
        final Counter counter = new LoopCounter();
    }
    
    @Test
    public void testSomeMethod1() {
        final Counter counter = new LoopCounter(1);
        assertEquals(counter.read(),1);
        assertEquals(counter.tick().read(),1);
        assertEquals(counter.tick().read(),1);
        assertEquals(counter.tick().read(),1);
        assertEquals(counter.tick().read(),1);
    }
    
    @Test
    public void testSomeMethod2() {
        final Counter counter = new LoopCounter(1,2);
        assertEquals(counter.read(),1);
        assertEquals(counter.tick().read(),2);
        assertEquals(counter.tick().read(),1);
        assertEquals(counter.tick().read(),2);
        assertEquals(counter.tick().read(),1);
    }
    
    @Test
    public void testSomeMethod3() {
        final Counter counter = new LoopCounter(1,2,3);
        assertEquals(counter.read(),1);
        assertEquals(counter.tick().read(),2);
        assertEquals(counter.tick().read(),3);
        assertEquals(counter.tick().read(),1);
        assertEquals(counter.tick().read(),2);
        assertEquals(counter.tick().read(),3);
    }
    
    @Test
    public void testSomeMethod4() {
        final int[] array = new int[]{1,2,3};
        final Counter counter = new LoopCounter(array);
        assertEquals(1,counter.read());
        assertEquals(2,counter.tick().read());
        assertEquals(3,counter.tick().read());
        array[0] = 4;
        assertEquals(1,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(3,counter.tick().read());
    }
    
    @Test
    public void testSomeMethod5() {
        final int[] array = new int[]{5,7,1,2,5};
        final Counter counter = new LoopCounter(array);
        assertEquals(5,counter.read());
        assertEquals(7,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(5,counter.tick().read());
        assertEquals(5,counter.tick().read());
        assertEquals(7,counter.tick().read());
    }
    
}
