/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hm.bartolov.a05_decoratorpattern.filter;

import edu.hm.cs.rs.arch.a05_decorator.Counter;
import edu.hm.bartolov.a05_decoratorpattern.base.LoopCounter;
import edu.hm.bartolov.a05_decoratorpattern.base.NaryCounter;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Edo
 */
public class ShiftedCounterTest {
    
    public ShiftedCounterTest() {
    }

    @Test()
    public void testTick1() {
        final Counter counter = new ShiftedCounter(new LoopCounter(1,2,3),0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testTick2() {
        final Counter counter = new ShiftedCounter(new LoopCounter(1,2,3),-1);
    }
    
    @Test
    public void testTick3() {
        final Counter counter = new ShiftedCounter(new LoopCounter(1,2,3),1);
        assertEquals(2,counter.read());
        assertEquals(3,counter.tick().read());
        assertEquals(4,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(3,counter.tick().read());
        assertEquals(4,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(3,counter.tick().read());
        assertEquals(4,counter.tick().read());
    }
    
    @Test(expected = NullPointerException.class)
    public void testTick4() {
        final Counter counter = new ShiftedCounter(null,100);
    }
    
    @Test
    public void testTick5() {
        final Counter counter = new ShiftedCounter(new LoopCounter(1,2,3),11);
        assertEquals(12,counter.read());
        assertEquals(13,counter.tick().read());
        assertEquals(14,counter.tick().read());
        assertEquals(12,counter.tick().read());
        assertEquals(13,counter.tick().read());
        assertEquals(14,counter.tick().read());
        assertEquals(12,counter.tick().read());
        assertEquals(13,counter.tick().read());
        assertEquals(14,counter.tick().read());
    }
    @Test
    public void testTick6() {
        final Counter counter = new ShiftedCounter(new NaryCounter(2),1);
        assertEquals(1,counter.read());
        assertEquals(2,counter.tick().read());
        assertEquals(11,counter.tick().read());
        assertEquals(12,counter.tick().read());
        assertEquals(101,counter.tick().read());
        assertEquals(102,counter.tick().read());
        assertEquals(111,counter.tick().read());
        assertEquals(112,counter.tick().read());
        assertEquals(1001,counter.tick().read());
    }
    
}
