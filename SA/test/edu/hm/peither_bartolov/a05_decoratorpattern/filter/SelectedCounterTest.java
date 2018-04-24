/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hm.peither_bartolov.a05_decoratorpattern.filter;

import edu.hm.peither_bartolov.a05_decoratorpattern.Counter;
import edu.hm.peither_bartolov.a05_decoratorpattern.base.LoopCounter;
import edu.hm.peither_bartolov.a05_decoratorpattern.base.UCounter;
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
        final Counter counter = new SelectedCounter(new UCounter(),n-> n%1000==0);
        assertEquals(0,counter.read());
        assertEquals(1000,counter.tick().read());
        assertEquals(2000,counter.tick().read());
        assertEquals(3000,counter.tick().read());
        assertEquals(4000,counter.tick().read());
    }
    
}