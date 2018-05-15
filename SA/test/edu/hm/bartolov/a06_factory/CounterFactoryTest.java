/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hm.bartolov.a06_factory;

import edu.hm.cs.rs.arch.a05_decorator.Counter;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Computer
 */
public class CounterFactoryTest {
    
    @Test
    public void counterFactoryGetTest1() {
        final CounterFactory cf = CounterFactory.get();
    }
    
}
