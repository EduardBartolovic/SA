package edu.hm.bartolov.a05_decoratorpattern.base;

import edu.hm.cs.rs.arch.a05_decorator.Counter;
import edu.hm.cs.rs.arch.a05_decorator.UCounter;
import org.junit.Test;

import java.util.NoSuchElementException;

public class CounterExceptionTest {

    /**
     * EXCEPTION TESTS
     */
    @Test(expected = NoSuchElementException.class)
    public void LoopCounterExceptionTest() {
        //Arrange
        final Counter sut = new LoopCounter();
    }

    @Test(expected = IllegalArgumentException.class)
    public void NaryCounterExceptionTest1() {
        //Arrange
        final Counter sut = new NaryCounter(10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void NaryCounterExceptionTest2() {
        //Arrange
        final Counter sut = new NaryCounter(1);
    }

    @Test(expected = NullPointerException.class)
    public void PrintCounterExceptionTest1() {
        //Arrange
        final Counter sut = new PrintCounter(null,'\n');
    }

    @Test(expected = NullPointerException.class)
    public void ShiftedCounterExceptionTest1() {
        //Arrange
        final Counter sut = new ShiftedCounter(null,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ShiftedCounterExceptionTest2() {
        //Arrange
        final Counter sut = new ShiftedCounter(new UCounter(),-1);
    }

    @Test(expected = NullPointerException.class)
    public void JumpCounterExceptionTest1() {
        //Arrange
        final Counter sut = new JumpCounter(null,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void JumpCounterExceptionTest2() {
        //Arrange
        final Counter sut = new JumpCounter(new UCounter(),-1);
    }

    @Test(expected = NullPointerException.class)
    public void LimitedCounterExceptionTest1() {
        //Arrange
        final Counter sut = new JumpCounter(null,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void LimitedCounterExceptionTest2() {
        //Arrange
        final Counter sut = new JumpCounter(new UCounter(),-1);
    }

    @Test(expected = NullPointerException.class)
    public void SlowCounterExceptionTest1() {
        //Arrange
        final Counter sut = new SlowCounter(null,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void SlowCounterExceptionTest2() {
        //Arrange
        final Counter sut = new SlowCounter(new UCounter(),0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void SlowCounterExceptionTest3() {
        //Arrange
        final Counter sut = new SlowCounter(new UCounter(),-1);
    }

    @Test(expected = NullPointerException.class)
    public void SelectedCounterExceptionTest1() {
        //Arrange
        final Counter sut = new SelectedCounter(null, k -> k % 3 == 1);
    }

    @Test(expected = NullPointerException.class)
    public void SelectedCounterExceptionTest2() {
        //Arrange
        final Counter sut = new SelectedCounter(new UCounter(), null);
    }
}