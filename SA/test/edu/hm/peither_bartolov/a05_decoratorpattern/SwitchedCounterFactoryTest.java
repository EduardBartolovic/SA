/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hm.peither_bartolov.a05_decoratorpattern;

import edu.hm.cs.rs.arch.a05_decorator.Counter;
import edu.hm.cs.rs.arch.a05_decorator.UCounter;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Edo
 */
public class SwitchedCounterFactoryTest {
    
    public SwitchedCounterFactoryTest() {
    }

    @Test
    public void testMake1U() throws Exception {
        SwitchedCounterFactory factory = new SwitchedCounterFactory();
        Counter counter;
        counter = factory.make("U");
        
        assertEquals(0,counter.read());
        assertEquals(1,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(3,counter.tick().read());
        assertEquals(4,counter.tick().read());
        assertEquals(5,counter.tick().read());
        assertEquals(6,counter.tick().read());
        assertEquals(7,counter.tick().read());
        assertEquals(8,counter.tick().read());
        assertEquals(9,counter.tick().read());
        
    }
    
    @Test
    public void testMake2UCounter() throws Exception {
        SwitchedCounterFactory factory = new SwitchedCounterFactory();
        Counter counter;
        counter = factory.make("UCounter");
        
        assertEquals(0,counter.read());
        assertEquals(1,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(3,counter.tick().read());
        assertEquals(4,counter.tick().read());
        assertEquals(5,counter.tick().read());
        assertEquals(6,counter.tick().read());
        assertEquals(7,counter.tick().read());
        assertEquals(8,counter.tick().read());
        assertEquals(9,counter.tick().read());
    }
    
    @Test
    public void testMake2LoopCounter() throws Exception {
        SwitchedCounterFactory factory = new SwitchedCounterFactory();
        Counter counter;
        counter = factory.make("LoopCounter",1,2,3);
        
        assertEquals(1,counter.read());
        assertEquals(2,counter.tick().read());
        assertEquals(3,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(3,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(3,counter.tick().read());
        assertEquals(1,counter.tick().read());
    }
    
    @Test
    public void testMake3LoopCounter() throws Exception {
        SwitchedCounterFactory factory = new SwitchedCounterFactory();
        Counter counter;
        counter = factory.make("LoopCounter",1);
        
        assertEquals(1,counter.read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        
    }
    
    @Test
    public void testMake4LoopCounter() throws Exception {
        SwitchedCounterFactory factory = new SwitchedCounterFactory();
        Counter counter;
        counter = factory.make("LoopCounter",new int[]{1,2,3,4,5,7,8,9,999});
        
        assertEquals(1,counter.read());
        assertEquals(2,counter.tick().read());
        assertEquals(3,counter.tick().read());
        assertEquals(4,counter.tick().read());
        assertEquals(5,counter.tick().read());
        assertEquals(7,counter.tick().read());
        assertEquals(8,counter.tick().read());
        assertEquals(9,counter.tick().read());
        assertEquals(999,counter.tick().read());
        assertEquals(1,counter.tick().read());
    }
    
    @Test
    public void testMake5Loop() throws Exception {
        SwitchedCounterFactory factory = new SwitchedCounterFactory();
        Counter counter;
        counter = factory.make("Loop",1,2,3);
        
        assertEquals(1,counter.read());
        assertEquals(2,counter.tick().read());
        assertEquals(3,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(3,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(3,counter.tick().read());
        assertEquals(1,counter.tick().read());
    }
    
    @Test
    public void testMake6LoopCounter() throws Exception {
        SwitchedCounterFactory factory = new SwitchedCounterFactory();
        Counter counter;
        counter = factory.make("Loop",1);
        
        assertEquals(1,counter.read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        
    }
    
    @Test
    public void testMake7Loop() throws Exception {
        SwitchedCounterFactory factory = new SwitchedCounterFactory();
        Counter counter;
        counter = factory.make("Loop",new int[]{1,2,3,4,5,7,8,9,999});
        
        assertEquals(1,counter.read());
        assertEquals(2,counter.tick().read());
        assertEquals(3,counter.tick().read());
        assertEquals(4,counter.tick().read());
        assertEquals(5,counter.tick().read());
        assertEquals(7,counter.tick().read());
        assertEquals(8,counter.tick().read());
        assertEquals(9,counter.tick().read());
        assertEquals(999,counter.tick().read());
        assertEquals(1,counter.tick().read());
    }
    
    @Test
    public void testMake20() throws Exception {
        SwitchedCounterFactory factory = new SwitchedCounterFactory();
        Counter counter;
        counter = factory.make(new UCounter(),"Jump",3);
        
        assertEquals(0,counter.read());
        assertEquals(3,counter.tick().read());
        assertEquals(6,counter.tick().read());
        assertEquals(9,counter.tick().read());
        assertEquals(12,counter.tick().read());
        assertEquals(15,counter.tick().read());
        assertEquals(18,counter.tick().read());
        assertEquals(21,counter.tick().read());
        assertEquals(24,counter.tick().read());
        assertEquals(27,counter.tick().read());
    }
    
    @Test
    public void testMake21() throws Exception {
        SwitchedCounterFactory factory = new SwitchedCounterFactory();
        Counter counter;
        counter = factory.make(new UCounter(),"JumpCounter",3);
        
        assertEquals(0,counter.read());
        assertEquals(3,counter.tick().read());
        assertEquals(6,counter.tick().read());
        assertEquals(9,counter.tick().read());
        assertEquals(12,counter.tick().read());
        assertEquals(15,counter.tick().read());
        assertEquals(18,counter.tick().read());
        assertEquals(21,counter.tick().read());
        assertEquals(24,counter.tick().read());
        assertEquals(27,counter.tick().read());
        
    }
    
    
    
    
    
    
}
