package edu.hm.bartolov.a05_decoratorpattern.base;

import edu.hm.cs.rs.arch.a05_decorator.Counter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BasicCounterTest {
    /**
     * FUNCTIONAL TESTS - BASIC COUNTER
     */
    @Test
    public void LoopCounterBasicTest1() {
        //Arrange
        final Counter sut = new LoopCounter(0,-1,-2,3,2,1);
        //Act
        final List<Integer> test = new ArrayList<>(
                Arrays.asList(0,-1,-2,3,2,1,0,-1,-2,3,2,1,0,-1,-2,3));
        final List<Integer> result = new ArrayList<>();
        for(int k = 0; k < 16; k++) {
            result.add(sut.read());
            sut.tick();
        }
        //Assert
        assertEquals(test, result);
    }

    @Test
    public void LoopCounterBasicTest2() {
        //Arrange
        final Counter sut = new LoopCounter(0);
        //Act
        final List<Integer> test = new ArrayList<>(
                Arrays.asList(0,0,0,0,0));
        final List<Integer> result = new ArrayList<>();
        for(int k = 0; k < 5; k++) {
            result.add(sut.read());
            sut.tick();
        }
        //Assert
        assertEquals(test, result);
    }

    @Test
    public void LoopCounterBasicTest3() {
        //Arrange
        final Counter sut = new LoopCounter(0,1,2);
        //Act
        final List<Integer> test = new ArrayList<>(
                Arrays.asList(0,1,2,0,1,2,0,1,2));
        final List<Integer> result = new ArrayList<>();
        for(int k = 0; k < 9; k++) {
            result.add(sut.read());
            sut.tick();
        }
        //Assert
        assertEquals(test, result);
    }

    @Test
    public void NaryCounterBasicTest1() {
        //Arrange
        final Counter sut = new NaryCounter(2);
        //Act
        final List<Integer> test = new ArrayList<>(Arrays.asList(0,1,10,11,100,101,110,111,1000,1001,1010,1011,1100,1101,1110,1111));
        final List<Integer> result = new ArrayList<>();
        for(int k = 0; k < 16; k++) {
            result.add(sut.read());
            sut.tick();
        }
        //Assert
        assertEquals(test,result);
    }

    @Test
    public void NaryCounterBasicTest2() {
        //Arrange
        final Counter sut = new NaryCounter(7);
        //Act
        final List<Integer> test = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,10,11,12,13,14,15,16,20,21));
        final List<Integer> result = new ArrayList<>();
        for(int k = 0; k < 16; k++) {
            result.add(sut.read());
            sut.tick();
        }
        //Assert
        assertEquals(test,result);
    }

    @Test
    public void NaryCounterBasicTest3() {
        //Arrange
        final Counter sut = new NaryCounter(3);
        //Act
        final List<Integer> test = new ArrayList<>(Arrays.asList(0,1,2,10,11,12,20,21,22,100,101,102,110,111));
        final List<Integer> result = new ArrayList<>();
        for(int k = 0; k < 14; k++) {
            result.add(sut.read());
            sut.tick();
        }
        //Assert
        assertEquals(test,result);
    }

    @Test
    public void ClearCounterBasicTest1() {
        //Arrange
        final Counter sut = new ClearCounter();
        //Act
        final List<Integer> test = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6));
        final List<Integer> result = new ArrayList<>();
        for(int k = 0; k < 7; k++) {
            result.add(sut.read());
            sut.tick();
        }
        //Assert
        assertEquals(test,result);
    }

    @Test
    public void ClearCounterBasicTest2() throws InterruptedException{
        //Arrange
        final Counter sut = new ClearCounter();
        //Act
        final List<Integer> test = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6));
        final List<Integer> result = new ArrayList<>();
        for(int k = 0; k < 7; k++) {
            result.add(sut.read());
            sut.tick();
            sut.read();
            sut.read();
            Thread.sleep(2);
            sut.read();
        }
        //Assert
        assertEquals(test,result);
    }

    @Test
    public void ClearCounterBasicTest3() {
        //Arrange
        final Counter sut = new ClearCounter();
        //Act
        final List<Integer> test = new ArrayList<>(Arrays.asList(0,0,0,0,0,0,0));
        final List<Integer> result = new ArrayList<>();
        for(int k = 0; k < 7; k++) {
            result.add(sut.read());
            sut.tick();
            sut.read();
            sut.read();
        }
        //Assert
        assertEquals(test,result);
    }

    @Test
    public void ClearCounterBasicTest4() throws InterruptedException {
        //Arrange
        final Counter sut = new ClearCounter();
        //Act
        final List<Integer> test = new ArrayList<>(Arrays.asList(0,1,2,3,3,4,4,4,4,0));
        final List<Integer> result = new ArrayList<>();

        result.add(sut.read());
        result.add(sut.tick().read());
        result.add(sut.tick().read());
        result.add(sut.tick().read());
        result.add(sut.read());
        result.add(sut.tick().read());
        result.add(sut.read());
        Thread.sleep(2);
        result.add(sut.read());
        result.add(sut.read());
        result.add(sut.read());


        //Assert
        assertEquals(test,result);
    }

    @Test
    public void ClearCounterBasicTest5() throws InterruptedException {
        //Arrange
        final Counter sut = new ClearCounter();
        //Act
        final List<Integer> test = new ArrayList<>(Arrays.asList(0,1,2,3,3,4,4,4,4,5,5,0,0));
        final List<Integer> result = new ArrayList<>();

        result.add(sut.read());
        result.add(sut.tick().read());
        result.add(sut.tick().read());
        result.add(sut.tick().read());
        result.add(sut.read());
        result.add(sut.tick().read());
        result.add(sut.read());
        Thread.sleep(2);
        result.add(sut.read());
        result.add(sut.read());
        result.add(sut.tick().read());
        result.add(sut.read());
        result.add(sut.read());
        result.add(sut.read());


        //Assert
        assertEquals(test,result);
    }


}