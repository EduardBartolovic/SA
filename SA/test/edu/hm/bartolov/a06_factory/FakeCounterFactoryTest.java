
package edu.hm.bartolov.a06_factory;

import edu.hm.cs.rs.arch.a05_decorator.Counter;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    
    
    @Test
    public void FakeCounterTest1() throws ReflectiveOperationException{
        //arrange
        System.setProperty("Factory.type", "Fake");
        final Counter sut = CounterFactory.get().make("");
        //act
        final List<Integer> correct = Arrays.asList(0,0,0,0,0,0);
        final List<Integer> result = new ArrayList<>();
        for(int i = 0; i < 6; i++){
            result.add(sut.read());
            sut.tick();
        }
        //assert
        assertEquals(correct,result);
    }

    @Test
    public void FakeCounterTest2() throws ReflectiveOperationException{
        //arrange
        System.setProperty("Factory.type", "Fake");
        final Counter sut = CounterFactory.get().make(null,"",0);
        //act
        final List<Integer> correct = Arrays.asList(0,0,0,0,0,0);
        final List<Integer> result = new ArrayList<>();
        for(int i = 0; i < 6; i++){
            result.add(sut.read());
            sut.tick();
        }
        //assert
        assertEquals(correct,result);
    }

    @Test
    public void FakeCounterPoolingTest() throws ReflectiveOperationException{
        //arrange
        System.setProperty("Factory.type", "Fake");
        final Counter sut = CounterFactory.get().make("");
        final Counter sut2 = CounterFactory.get().make(null,"",0);
        //assert
        assertTrue(sut == sut2);
    }
}
