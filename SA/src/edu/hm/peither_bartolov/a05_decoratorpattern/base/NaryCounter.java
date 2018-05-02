package edu.hm.peither_bartolov.a05_decoratorpattern.base;

import edu.hm.cs.rs.arch.a05_decorator.Counter;

/**
 * The nary counter which counts in a number system 
 * of the users choosing.
 * 
 * @author Eduard Bartolovic, Felix Peither
 */
public class NaryCounter implements Counter{

     /**
     * highest type of the number system.
     */
    private static final int MAX_NUMBER_SYSTEM = 9;
    
    /**
     * lowest type of the number system.
     */
    private static final int MIN_NUMBER_SYSTEM = 2;
    
    /**
     * an integer which indicate the used number system.
     */
    private final int numberSystem;
    
    /**
     * the current value of this counter.
     */
    private int currentPositionAt;
    
    /**
     * Public Contructor for the NaryCounter.
     * 
     * @param numberSystem an int which specifies the number system used
     */
    public NaryCounter(int numberSystem) {
        if (numberSystem < MIN_NUMBER_SYSTEM || numberSystem > MAX_NUMBER_SYSTEM) {
            throw new IllegalArgumentException("Please choose a number system between 2 and 9!");
        }
        currentPositionAt = 0;
        this.numberSystem =  numberSystem;
    }
    
    @Override
    public int read() {
        return currentPositionAt;
    }

    @Override
    public Counter tick() {
        final char[] numberPartsAsChars = Integer.toString(currentPositionAt).toCharArray();
        final int[] numberParts = new int[numberPartsAsChars.length];
        for (int index = 0; index < numberPartsAsChars.length; index++) {
            final String currentNumberPart = Character.toString(numberPartsAsChars[index]);
            numberParts[index] = Integer.parseInt(currentNumberPart);
        }
        numberParts[numberParts.length-1]++;
        currentPositionAt = calculateCurrentPosition(numberParts);
        int powerTo = numberParts.length-1;
        for (Integer numberPart: numberParts) {
            currentPositionAt += (int)(Math.pow(10, powerTo) * numberPart);
            powerTo--;
        }
        return this;
    }
    
    /**
     * calculate the next position of the counter.
     * 
     * @param numberParts the int[] of the old position
     * @return the new position
     */
    private int calculateCurrentPosition(int...numberParts) {
        int currentPosition = 0;
        int overflow = 0;
        for (int index = numberParts.length-1; index >= 0; index--) {
            if (overflow == 1) {
                numberParts[index]++;
                overflow = 0;
            }
            if (numberParts[index] == numberSystem) {
                overflow = 1;
                numberParts[index] = 0;
            }
            if (index == 0 && overflow == 1) {
                currentPosition = (int)Math.pow(10, numberParts.length);
            }
            
        }
        return currentPosition;
    }

    
    
}
