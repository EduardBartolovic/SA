
package edu.hm.peither_bartolov.a05_decoratorpattern;

import edu.hm.peither_bartolov.a05_decoratorpattern.base.LoopCounter;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Edo
 */
public class LoopCounterTest {
    
    public LoopCounterTest() {
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
    
}
