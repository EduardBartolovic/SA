/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hm.peither_bartolov.a05_decoratorpattern.base;

import edu.hm.peither_bartolov.a05_decoratorpattern.Counter;
import edu.hm.peither_bartolov.a05_decoratorpattern.base.NaryCounter;
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
    }
    
}
