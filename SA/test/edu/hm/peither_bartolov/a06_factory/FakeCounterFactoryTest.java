
package edu.hm.peither_bartolov.a06_factory;

import edu.hm.cs.rs.arch.a05_decorator.Counter;
import org.junit.Assert;
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
        counter = factory.make();
        
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
        Counter counter1 = factory.make("Egal");
        Counter counter2 = factory.make("WirklichEgal",1);
        Counter counter3 = factory.make(counter1,"NochEgaler",1);

        Assert.assertEquals(counter1,counter2);
        Assert.assertEquals(counter1,counter3);
    }
    
}
