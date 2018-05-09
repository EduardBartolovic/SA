package edu.hm.bartolov.a06_factory;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CounterFactoryPoolingTest {

    @Test (expected = IllegalArgumentException.class)
    public void CounterFactoryMissingPropertyTest(){
        //arrange
        System.clearProperty("Factory.type");
        final CounterFactory sut = CounterFactory.get();
    }

    @Test
    public void CounterFactoryInstanceOfTest1(){
        //arrange
        System.setProperty("Factory.type", "Switched");
        //act
        final CounterFactory sut = CounterFactory.get();
        assertTrue(sut instanceof SwitchedCounterFactory);
    }

    @Test
    public void CounterFactoryInstanceOfTest1_1(){
        //arrange
        System.setProperty("Factory.type", "SwitchedCounterFactory");
        //act
        final CounterFactory sut = CounterFactory.get();
        assertTrue(sut instanceof SwitchedCounterFactory);
    }

    @Test
    public void CounterFactoryInstanceOfTest2(){
        //arrange
        System.setProperty("Factory.type", "Meta");
        //act
        final CounterFactory sut = CounterFactory.get();
        assertTrue(sut instanceof MetaCounterFactory);
    }

    @Test
    public void CounterFactoryInstanceOfTest2_1(){
        //arrange
        System.setProperty("Factory.type", "MetaCounterFactory");
        //act
        final CounterFactory sut = CounterFactory.get();
        assertTrue(sut instanceof MetaCounterFactory);
    }

    @Test
    public void CounterFactoryInstanceOfTest3(){
        //arrange
        System.setProperty("Factory.type", "Fake");
        //act
        final CounterFactory sut = CounterFactory.get();
        assertTrue(sut instanceof FakeCounterFactory);
    }

    @Test
    public void CounterFactoryInstanceOfTest3_1(){
        //arrange
        System.setProperty("Factory.type", "FakeCounterFactory");
        //act
        final CounterFactory sut = CounterFactory.get();
        assertTrue(sut instanceof FakeCounterFactory);
    }

    @Test
    public void CounterFactoryPoolingTest1(){
        //arrange
        System.setProperty("Factory.type", "Switched");
        //act
        final CounterFactory sut = CounterFactory.get();
        final CounterFactory sut2 = CounterFactory.get();
        assertTrue(sut == sut2);
    }

    @Test
    public void CounterFactoryPoolingTest2(){
        //arrange
        System.setProperty("Factory.type", "Meta");
        //act
        final CounterFactory sut = CounterFactory.get();
        final CounterFactory sut2 = CounterFactory.get();
        assertTrue(sut == sut2);
    }

    @Test
    public void CounterFactoryPoolingTest3(){
        //arrange
        System.setProperty("Factory.type", "Fake");
        //act
        final CounterFactory sut = CounterFactory.get();
        final CounterFactory sut2 = CounterFactory.get();
        assertTrue(sut == sut2);
    }

    @Test
    public void CounterFactoryTest1(){
        //arrange
        System.setProperty("Factory.type", "Fake");
        final CounterFactory factory = CounterFactory.get();
        final CounterFactory factory1 = CounterFactory.get();
        //act

        Assert.assertEquals(factory,factory1);
    }

    @Test
    public void CounterFactoryTest2(){
        //arrange
        System.setProperty("Factory.type", "Meta");
        final CounterFactory factory = CounterFactory.get();
        final CounterFactory factory1 = CounterFactory.get();
        //act

        Assert.assertEquals(factory,factory1);
    }

    @Test
    public void CounterFactoryTest3(){
        //arrange
        System.setProperty("Factory.type", "Switched");
        final CounterFactory factory = CounterFactory.get();
        final CounterFactory factory1 = CounterFactory.get();
        //act

        Assert.assertEquals(factory,factory1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void CounterFactoryTest4(){
        //arrange
        System.setProperty("Factory.type", "gibtsnicht");
        final CounterFactory factory = CounterFactory.get();
    }

    @Test (expected = IllegalArgumentException.class)
    public void CounterFactoryTest5(){
        //arrange
        final CounterFactory factory = CounterFactory.get();
    }

    @Test
    public void CounterFactoryTest6(){
        //arrange
        System.setProperty("Factory.type", "Fake");
        final CounterFactory factory = CounterFactory.get();
        System.setProperty("Factory.type", "Meta");
        final CounterFactory factory1 = CounterFactory.get();
        Assert.assertNotEquals(factory,factory1);
    }

    @Test
    public void CounterFactoryTest7() throws ReflectiveOperationException{
        //arrange
        System.setProperty("Factory.type", "Fake");
        final CounterFactory factory = CounterFactory.get();
        System.setProperty("Factory.type", "Meta");
        final CounterFactory factory1 = CounterFactory.get();
        System.setProperty("Factory.type", "Fake");
        factory1.make("U");
        final CounterFactory factory2 = CounterFactory.get();
        Assert.assertEquals(factory,factory2);
    }
}