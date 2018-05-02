package edu.hm.bartolov.a05_decoratorpattern.base;

import edu.hm.cs.rs.arch.a05_decorator.Counter;
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
    
    @Test
    public void testTick2() throws InterruptedException {
        final Counter counter = new ClearCounter();
        assertEquals(0,counter.read());
        assertEquals(1,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(3,counter.tick().read());
        assertEquals(4,counter.tick().read());
        assertEquals(5,counter.tick().read());
        counter.read();
        counter.read();
        assertEquals(0,counter.read());
        assertEquals(1,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(3,counter.tick().read());
        counter.read();
        counter.read();
        assertEquals(0,counter.read());
    }
    
    @Test
    public void Test1() throws InterruptedException {
        Counter counter = new ClearCounter();
        assertEquals(0,counter.read());            // 0
        assertEquals(1,counter.tick().read());     // 1
        assertEquals(2,counter.tick().read());     // 2
        assertEquals(2,counter.read());            // 2

        assertEquals(0,counter.read());            // 0
        assertEquals(1,counter.tick().read());      // 1
        assertEquals(2,counter.tick().read());      // 2
        assertEquals(2,counter.read());           // 2

        Thread.sleep(2);

        assertEquals(2,counter.read());           // 2
        assertEquals(3,counter.tick().read());    // 3
    }

    @Test
    public void Test2() throws InterruptedException {
        Counter counter = new ClearCounter();
        assertEquals(0,counter.read());
        assertEquals(0,counter.read());
        assertEquals(0,counter.read());
        assertEquals(0,counter.read());
        assertEquals(0,counter.read());
        assertEquals(0,counter.read());
        assertEquals(0,counter.read());
    }

    @Test
    public void Test3() throws InterruptedException {
        Counter counter = new ClearCounter();
        assertEquals(0,counter.read());
        assertEquals(0,counter.read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.read());
        assertEquals(0,counter.read());
        assertEquals(0,counter.read());
        assertEquals(0,counter.read());
    }
    
}
