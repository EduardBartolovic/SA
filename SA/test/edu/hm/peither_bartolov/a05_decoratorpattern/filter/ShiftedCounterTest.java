/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hm.peither_bartolov.a05_decoratorpattern.filter;

import edu.hm.cs.rs.arch.a05_decorator.Counter;
import edu.hm.peither_bartolov.a05_decoratorpattern.base.LoopCounter;
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
    
}
