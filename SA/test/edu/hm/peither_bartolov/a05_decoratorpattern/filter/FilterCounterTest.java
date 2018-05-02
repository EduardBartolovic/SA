package edu.hm.bartolov.a05_decoratorpattern.filter;
import edu.hm.cs.rs.arch.a05_decorator.Counter;
import edu.hm.cs.rs.arch.a05_decorator.UCounter;
import edu.hm.bartolov.a05_decoratorpattern.base.LoopCounter;
import edu.hm.bartolov.a05_decoratorpattern.base.NaryCounter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FilterCounterTest {
    /**
     * FUNCTIONAL TESTS - FILTER COUNTER
     */
    @Test
    public void ShiftedCounterTest1() {
        //Arrange
        final Counter sut = new ShiftedCounter(new UCounter(), 2);
        //Act
        final List<Integer> test = new ArrayList<>(
                Arrays.asList(2,3,4,5,6));
        final List<Integer> result = new ArrayList<>();
        for(int k = 0; k < 5; k++) {
            result.add(sut.read());
            sut.tick();
        }
        //Assert
        assertEquals(test, result);
    }

    @Test
    public void ShiftedCounterTest2() {
        //Arrange
        final Counter sut = new ShiftedCounter(new NaryCounter(3), 2);
        //Act
        final List<Integer> test = new ArrayList<>(
                Arrays.asList(2, 3, 4, 12, 13, 14, 22));
        final List<Integer> result = new ArrayList<>();
        for(int k = 0; k < 7; k++) {
            result.add(sut.read());
            sut.tick();
        }
        //Assert
        assertEquals(test, result);
    }

    @Test
    public void ShiftedCounterTest3() {
        //Arrange
        final Counter sut = new ShiftedCounter(new LoopCounter(-1,0,1), 4);
        //Act
        final List<Integer> test = new ArrayList<>(
                Arrays.asList(3, 4, 5, 3, 4, 5, 3));
        final List<Integer> result = new ArrayList<>();
        for(int k = 0; k < 7; k++) {
            result.add(sut.read());
            sut.tick();
        }
        //Assert
        assertEquals(test, result);
    }

    @Test
    public void JumpCounterTest1() {
        //Arrange
        final Counter sut = new JumpCounter(new UCounter(), 2);
        //Act
        final List<Integer> test = new ArrayList<>(
                Arrays.asList(0,2,4,6,8));
        final List<Integer> result = new ArrayList<>();
        for(int k = 0; k < 5; k++) {
            result.add(sut.read());
            sut.tick();
        }
        //Assert
        assertEquals(test, result);
    }

    @Test
    public void JumpCounterTest2() {
        //Arrange
        final Counter sut = new JumpCounter(new LoopCounter(1,2,3), 2);
        //Act
        final List<Integer> test = new ArrayList<>(
                Arrays.asList(1,3,2,1,3));
        final List<Integer> result = new ArrayList<>();
        for(int k = 0; k < 5; k++) {
            result.add(sut.read());
            sut.tick();
        }
        //Assert
        assertEquals(test, result);
    }

    @Test
    public void LimitedCounterTest1() {
        //Arrange
        final Counter sut = new LimitedCounter(new UCounter(), 2);
        //Act
        final List<Integer> test = new ArrayList<>(
                Arrays.asList(0,1,2,2,2));
        final List<Integer> result = new ArrayList<>();
        for(int k = 0; k < 5; k++) {
            result.add(sut.read());
            sut.tick();
        }
        //Assert
        assertEquals(test, result);
    }

    @Test
    public void LimitedCounterTest2() {
        //Arrange
        final Counter sut = new LimitedCounter(new JumpCounter(new UCounter(), 4), 2);
        //Act
        final List<Integer> test = new ArrayList<>(
                Arrays.asList(0,2,2,2,2));
        final List<Integer> result = new ArrayList<>();
        for(int k = 0; k < 5; k++) {
            result.add(sut.read());
            sut.tick();
        }
        //Assert
        assertEquals(test, result);
    }

    @Test
    public void LimitedCounterTest3() {
        //Arrange
        final Counter sut = new LimitedCounter(new JumpCounter(new UCounter(), 2), 3);
        //Act
        final List<Integer> test = new ArrayList<>(
                Arrays.asList(0,2,3,3,3));
        final List<Integer> result = new ArrayList<>();
        for(int k = 0; k < 5; k++) {
            result.add(sut.read());
            sut.tick();
        }
        //Assert
        assertEquals(test, result);
    }

    @Test
    public void LimitedCounterTest4() {
        //Arrange
        final Counter sut = new LimitedCounter(new LoopCounter(1,2,3,4,5),3);
        //Act
        final List<Integer> test = new ArrayList<>(
                Arrays.asList(1,2,3,3,3,1,2,3,3,3,1,2));
        final List<Integer> result = new ArrayList<>();
        for(int k = 0; k < 12; k++) {
            result.add(sut.read());
            sut.tick();
        }
        //Assert
        assertEquals(test, result);
    }


    @Test
    public void SlowCounterTest1() {
        //Arrange
        final Counter sut = new SlowCounter(new UCounter(), 2);
        //Act
        final List<Integer> test = new ArrayList<>(
                Arrays.asList(0,0,1,1,2));
        final List<Integer> result = new ArrayList<>();
        for(int k = 0; k < 5; k++) {
            result.add(sut.read());
            sut.tick();
        }
        //Assert
        assertEquals(test, result);
    }

    @Test
    public void SelectedCounterTest1() {
        //Arrange
        final Counter sut = new SelectedCounter(new UCounter(), n -> n % 3 == 1);
        //Act
        final List<Integer> test = new ArrayList<>(
                Arrays.asList(1,4,7,10,13));
        final List<Integer> result = new ArrayList<>();
        for(int k = 0; k < 5; k++) {
            result.add(sut.read());
            sut.tick();
        }
        //Assert
        assertEquals(test, result);
    }

    @Test
    public void SelectedCounterTest2() {
        //Arrange
        final Counter sut = new SelectedCounter(new LoopCounter(-2,-1,0,1,2), n -> n >= 0);
        //Act
        final List<Integer> test = new ArrayList<>(
                Arrays.asList(0,1,2,0,1));
        final List<Integer> result = new ArrayList<>();
        for(int k = 0; k < 5; k++) {
            result.add(sut.read());
            sut.tick();
        }
        //Assert
        assertEquals(test, result);
    }
}