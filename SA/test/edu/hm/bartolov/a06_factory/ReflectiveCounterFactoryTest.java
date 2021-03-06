/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hm.bartolov.a06_factory;

import edu.hm.cs.rs.arch.a05_decorator.Counter;
import edu.hm.cs.rs.arch.a05_decorator.UCounter;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Edo
 */
public class ReflectiveCounterFactoryTest {
    
    public ReflectiveCounterFactoryTest() throws ReflectiveOperationException {
    }

    @Test
    public void testMake1U() throws Exception {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
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
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
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
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
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
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
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
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
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
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
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
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
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
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
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
    
    @Test(expected = IllegalArgumentException.class)
    public void testMake7UFalse() throws Exception {
        final ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        final Counter counter = factory.make("U",5);
        
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMake8UFalse() throws Exception {
        final ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        final Counter counter = factory.make("Loop");
        
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMake9UFalse() throws Exception {
        final ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        final Counter counter = factory.make("Nary");
        
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMake10False() throws Exception {
        final ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        final Counter counter = factory.make("42",5);
        
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMake18False() throws Exception {
        final ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        final Counter counter = factory.make(new UCounter(),"42",3);
        
    }
    
    
    
    @Test
    public void testMake20() throws Exception {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
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
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
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

    @Test (expected = IllegalArgumentException.class)
    public void ReflectiveCounterFactoryTest1() throws InterruptedException, ReflectiveOperationException, ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("U",0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void ReflectiveCounterFactoryTest2() throws InterruptedException, ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Clear",0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void ReflectiveCounterFactoryTest3() throws InterruptedException, ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Loop");
    }

    @Test (expected = IllegalArgumentException.class)
    public void ReflectiveCounterFactoryTest4() throws InterruptedException, ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Nary");
    }

    @Test (expected = IllegalArgumentException.class)
    public void ReflectiveCounterFactoryTest5() throws InterruptedException, ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Nary",1,2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void ReflectiveCounterFactoryTest6() throws InterruptedException, ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Except");
    }

    @Test (expected = IllegalArgumentException.class)
    public void ReflectiveCounterFactoryTest7() throws ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("U");
        counter = factory.make(counter,"Except", 0);
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test()
    public void LimitedCounter1() throws ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Loop", 0,1,2,3);
        counter = factory.make(counter,"LimitedCounter", 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void LimitedCounter2() throws ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Loop", 0,1,2,3);
        counter = factory.make(counter,"LimitedCounter", -1);
    }

    @Test
    public void LimitedCounter3() throws ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Loop", 0,1,2,3);
        counter = factory.make(counter,"LimitedCounter", 1);

        assertEquals(0,counter.read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(0,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(0,counter.tick().read());
    }

    @Test
    public void LimitedCounter4() throws ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Loop", 0,1,2,3);
        counter = factory.make(counter,"LimitedCounter", 1);

        assertEquals(0,counter.read());
        assertEquals(0,counter.read());
        assertEquals(0,counter.read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(0,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
    }

    @Test
    public void LimitedCounter5() throws ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("U");
        counter = factory.make(counter,"LimitedCounter", 7);

        assertEquals(0,counter.read());
        assertEquals(1,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(3,counter.tick().read());
        assertEquals(4,counter.tick().read());
        assertEquals(5,counter.tick().read());
        assertEquals(6,counter.tick().read());
        assertEquals(7,counter.tick().read());
        assertEquals(7,counter.tick().read());
        assertEquals(7,counter.tick().read());
        assertEquals(7,counter.tick().read());
        assertEquals(7,counter.tick().read());
        assertEquals(7,counter.tick().read());
    }
    @Test
    public void LimitedCounter6() throws ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Loop", 1,2,3);
        counter = factory.make(counter,"LimitedCounter", 2);

        assertEquals(1,counter.read());
        assertEquals(2,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(1,counter.tick().read());
    }

    @Test
    public void LimitedCounter7() throws ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("NaryCounter",2);
        counter = factory.make(counter,"LimitedCounter", 3);

        assertEquals(0, counter.read());
        assertEquals(1, counter.tick().read());
        assertEquals(3, counter.tick().read());
        assertEquals(3, counter.tick().read());
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test()
    public void JumpCounter1() throws ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Loop",1,2,3);
        counter = factory.make(counter,"Jump", 3);

        assertEquals(1,counter.read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());

    }

    @Test(expected = IllegalArgumentException.class)
    public void JumpCounter2() throws ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Loop",1,2,3);
        counter = factory.make(counter,"Jump", -1);
    }

    @Test
    public void JumpCounter3() throws ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Loop",0,1,2,3);
        counter = factory.make(counter,"Jump", 1);

        assertEquals(0,counter.read());
        assertEquals(1,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(3,counter.tick().read());
        assertEquals(0,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(3,counter.tick().read());
        assertEquals(0,counter.tick().read());
    }

    @Test
    public void JumpCounter4() throws ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("U");
        counter = factory.make(counter,"Jump", 2);

        assertEquals(0,counter.read());
        assertEquals(2,counter.tick().read());
        assertEquals(4,counter.tick().read());
        assertEquals(6,counter.tick().read());
        assertEquals(8,counter.tick().read());
        assertEquals(10,counter.tick().read());
        assertEquals(12,counter.tick().read());
        assertEquals(14,counter.tick().read());
        assertEquals(16,counter.tick().read());
    }

    @Test
    public void JumpCounter5() throws ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Loop",1,2,3);
        counter = factory.make(counter,"Jump", 2);

        assertEquals(1,counter.read());
        assertEquals(3,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(3,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(3,counter.tick().read());
        assertEquals(2,counter.tick().read());
    }

    @Test
    public void JumpCounter6() throws ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("U");
        counter = factory.make(counter,"Jump", 3);
        counter = factory.make(counter,"Jump", 2);

        assertEquals(0,counter.read());
        assertEquals(6,counter.tick().read());
        assertEquals(12,counter.tick().read());
        assertEquals(18,counter.tick().read());
        assertEquals(24,counter.tick().read());
        assertEquals(30,counter.tick().read());
        assertEquals(36,counter.tick().read());
        assertEquals(42,counter.tick().read());
    }

    @Test
    public void JumpCounter7() throws ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Nary",2);
        counter = factory.make(counter,"Jump", 2);

        assertEquals(0,counter.read());
        assertEquals(10,counter.tick().read());
        assertEquals(100,counter.tick().read());
        assertEquals(110,counter.tick().read());
        assertEquals(1000,counter.tick().read());
        assertEquals(1010,counter.tick().read());
        assertEquals(1100,counter.tick().read());
        assertEquals(1110,counter.tick().read());
    }

    @Test
    public void JumpCounter8() throws ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Nary",2);
        counter = factory.make(counter,"Jump", 3);

        assertEquals(0,counter.read());
        assertEquals(11,counter.tick().read());
        assertEquals(110,counter.tick().read());
        assertEquals(1001,counter.tick().read());
        assertEquals(1100,counter.tick().read());
        assertEquals(1111,counter.tick().read());
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test()
    public void ShiftedCounter1() throws ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Loop",1,2,3);
        counter = factory.make(counter,"Shifted", 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ShiftedCounter2() throws ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Loop",1,2,3);
        counter = factory.make(counter,"Shifted", -1);
    }

    @Test
    public void ShiftedCounter3() throws ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Loop",1,2,3);
        counter = factory.make(counter,"Shifted", 1);

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
    @Test
    public void ShiftedCounter4() throws ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Loop",1,2,3);
        counter = factory.make(counter,"Shifted", 11);

        assertEquals(12,counter.read());
        assertEquals(13,counter.tick().read());
        assertEquals(14,counter.tick().read());
        assertEquals(12,counter.tick().read());
        assertEquals(13,counter.tick().read());
        assertEquals(14,counter.tick().read());
        assertEquals(12,counter.tick().read());
        assertEquals(13,counter.tick().read());
        assertEquals(14,counter.tick().read());
    }
    @Test
    public void ShiftedCounter5() throws ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Nary",2);
        counter = factory.make(counter,"Shifted", 1);

        assertEquals(1,counter.read());
        assertEquals(2,counter.tick().read());
        assertEquals(11,counter.tick().read());
        assertEquals(12,counter.tick().read());
        assertEquals(101,counter.tick().read());
        assertEquals(102,counter.tick().read());
        assertEquals(111,counter.tick().read());
        assertEquals(112,counter.tick().read());
        assertEquals(1001,counter.tick().read());
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test(expected = IllegalArgumentException.class)
    public void SlowCounter1() throws ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Loop",1,2,3);
        counter = factory.make(counter,"Slow", 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void SlowCounter2() throws ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Loop",1,2,3);
        counter = factory.make(counter,"Slow", -1);
    }

    @Test
    public void SlowCounter3() throws ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Loop",1,2,3);
        counter = factory.make(counter,"Slow", 2);

        assertEquals(1,counter.read());
        assertEquals(1,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(3,counter.tick().read());
        assertEquals(3,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(2,counter.tick().read());
    }

    @Test
    public void SlowCounter4() throws ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("U");
        counter = factory.make(counter,"Slow", 2);

        assertEquals(0,counter.read());
        assertEquals(0,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(3,counter.tick().read());
        assertEquals(3,counter.tick().read());
        assertEquals(4,counter.tick().read());
    }

    @Test
    public void SlowCounter5() throws ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Loop",1,2,3);
        counter = factory.make(counter,"Slow", 1);

        assertEquals(1,counter.read());
        assertEquals(2,counter.tick().read());
        assertEquals(3,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(2,counter.tick().read());
    }

    @Test
    public void SlowCounter6() throws ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Nary",2);
        counter = factory.make(counter,"Slow", 2);

        assertEquals(0,counter.read());
        assertEquals(0,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(10,counter.tick().read());
        assertEquals(10,counter.tick().read());
        assertEquals(11,counter.tick().read());
        assertEquals(11,counter.tick().read());
        assertEquals(100,counter.tick().read());
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test
    public void ClearCounter1() throws InterruptedException, ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Clear");

        assertEquals(0,counter.read());            // 0
        assertEquals(1,counter.tick().read());     // 1
        assertEquals(2,counter.tick().read());     // 2
        assertEquals(2,counter.read());            // 2

        assertEquals(0,counter.read());            // 0
        assertEquals(1,counter.tick().read());      // 1
        assertEquals(2,counter.tick().read());      // 2
        assertEquals(2,counter.read());           // 2

        Thread.sleep(2);

        assertEquals(2,counter.read());           // 2
        assertEquals(3,counter.tick().read());    // 3
    }

    @Test
    public void ClearCounter2() throws InterruptedException, ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Clear");

        assertEquals(0,counter.read());
        assertEquals(0,counter.read());
        assertEquals(0,counter.read());
        assertEquals(0,counter.read());
        assertEquals(0,counter.read());
        assertEquals(0,counter.read());
        assertEquals(0,counter.read());
    }

    @Test
    public void ClearCounter3() throws InterruptedException, ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Clear");

        assertEquals(0,counter.read());
        assertEquals(0,counter.read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.read());
        assertEquals(0,counter.read());
        assertEquals(0,counter.read());
        assertEquals(0,counter.read());
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test
    public void LoopCounter1() throws ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Loop",1);
        assertEquals(1,counter.read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(1,counter.tick().read());
    }

    @Test
    public void LoopCounter2() throws ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Loop",1,2);
        assertEquals(1,counter.read());
        assertEquals(2,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(2,counter.tick().read());
    }

    @Test
    public void LoopCounter3() throws ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Loop",1,2,3);
        assertEquals(1,counter.read());
        assertEquals(2,counter.tick().read());
        assertEquals(3,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(2,counter.tick().read());
    }

    @Test
    public void LoopCounter4() throws ReflectiveOperationException{
        final int[] array = new int[]{1,2,3};
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Loop",array);
        assertEquals(1,counter.read());
        assertEquals(2,counter.tick().read());
        assertEquals(3,counter.tick().read());
        array[0] = 4;
        assertEquals(1,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(3,counter.tick().read());
    }

    @Test
    public void LoopCounter5() throws ReflectiveOperationException{
        final int[] array = new int[]{5,7,1,2,5};
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Loop",array);
        assertEquals(5,counter.read());
        assertEquals(7,counter.tick().read());
        assertEquals(1,counter.tick().read());
        assertEquals(2,counter.tick().read());
        assertEquals(5,counter.tick().read());
        assertEquals(5,counter.tick().read());
        assertEquals(7,counter.tick().read());
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test
    public void NaryCounter1() throws ReflectiveOperationException{
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Nary",3);
        assertEquals(0, counter.read());
        assertEquals(1, counter.tick().read());
        assertEquals(2, counter.tick().read());
        assertEquals(10, counter.tick().read());
        assertEquals(11, counter.tick().read());
        assertEquals(12, counter.tick().read());
    }

    @Test(expected = IllegalArgumentException.class)
    public void NaryCounter2() throws ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Nary",0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void NaryCounter3()  throws ReflectiveOperationException{
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Nary",1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void NaryCounter4() throws ReflectiveOperationException{
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Nary",10);
    }

    @Test
    public void NaryCounter5() throws ReflectiveOperationException {
        ReflectiveCounterFactory factory = new ReflectiveCounterFactory();
        Counter counter = factory.make("Nary",2);
        assertEquals(0, counter.read());
        assertEquals(1, counter.tick().read());
        assertEquals(10, counter.tick().read());
        assertEquals(11, counter.tick().read());
    }

    
}
