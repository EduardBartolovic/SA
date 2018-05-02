/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hm.bartolov.a05_decoratorpattern.base;

import edu.hm.cs.rs.arch.a05_decorator.Counter;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Computer
 */
public class NaryCounterTest {
    
    @Test
    public void testNaryTick1() {
        final Counter counter = new NaryCounter(3);
        assertEquals(0, counter.read());
        assertEquals(1, counter.tick().read());
        assertEquals(2, counter.tick().read());
        assertEquals(10, counter.tick().read());
        assertEquals(11, counter.tick().read());
        assertEquals(12, counter.tick().read());
        assertEquals(20, counter.tick().read());
        assertEquals(21, counter.tick().read());
        assertEquals(22, counter.tick().read());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNaryTick2() {
        final Counter counter = new NaryCounter(0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNaryTick3() {
        final Counter counter = new NaryCounter(1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNaryTick4() {
        final Counter counter = new NaryCounter(10);
    }
    
    @Test
    public void testNaryTick5() {
        final Counter counter = new NaryCounter(2);
        assertEquals(0, counter.read());
        assertEquals(1, counter.tick().read());
        assertEquals(10, counter.tick().read());
        assertEquals(11, counter.tick().read());
        assertEquals(11, counter.read());
        assertEquals(11, counter.read());
        assertEquals(11, counter.read());
        assertEquals(11, counter.read());
        assertEquals(11, counter.read());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNaryTick6() {
        final Counter counter = new NaryCounter(-1);
    }
    
}
