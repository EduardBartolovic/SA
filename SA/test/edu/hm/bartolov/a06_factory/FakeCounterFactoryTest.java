
package edu.hm.bartolov.a06_factory;

import edu.hm.cs.rs.arch.a05_decorator.Counter;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Eduard
 */
public class FakeCounterFactoryTest {
    
    public FakeCounterFactoryTest() {
    }

    @Test
    public void testSomeMethod() {
        FakeCounterFactory factory = new FakeCounterFactory();
        Counter counter;
        counter = factory.make("faky");
        
        assertEquals(0,counter.read());
        assertEquals(0,counter.tick().read());
        assertEquals(0,counter.tick().read());
        assertEquals(0,counter.tick().read());
        assertEquals(0,counter.tick().read());
        assertEquals(0,counter.tick().read());
        assertEquals(0,counter.tick().read());
        assertEquals(0,counter.tick().read());
        assertEquals(0,counter.tick().read());
        assertEquals(0,counter.tick().read());
        
    }
    
    @Test
    public void FakeCounterFactoryTest1(){
        FakeCounterFactory factory = new FakeCounterFactory();
        Counter counter = factory.make("Egal");
        assertEquals(0,counter.read());
        assertEquals(0,counter.tick().read());
        assertEquals(0,counter.tick().read());
        assertEquals(0,counter.tick().read());
        assertEquals(0,counter.tick().read());
        assertEquals(0,counter.tick().read());
        assertEquals(0,counter.tick().read());
        assertEquals(0,counter.tick().read());
        assertEquals(0,counter.tick().read());
        assertEquals(0,counter.tick().read());
        counter = factory.make("WirklichEgal",1);
        assertEquals(0,counter.read());
        assertEquals(0,counter.tick().read());
        assertEquals(0,counter.tick().read());
        assertEquals(0,counter.tick().read());
        assertEquals(0,counter.tick().read());
        assertEquals(0,counter.tick().read());
        assertEquals(0,counter.tick().read());
        assertEquals(0,counter.tick().read());
        assertEquals(0,counter.tick().read());
        assertEquals(0,counter.tick().read());
        counter = factory.make(counter,"NochEgaler",1);
        assertEquals(0,counter.read());
        assertEquals(0,counter.tick().read());
        assertEquals(0,counter.tick().read());
        assertEquals(0,counter.tick().read());
        assertEquals(0,counter.tick().read());
        assertEquals(0,counter.tick().read());
        assertEquals(0,counter.tick().read());
        assertEquals(0,counter.tick().read());
        assertEquals(0,counter.tick().read());
        assertEquals(0,counter.tick().read());
    }
    
}
