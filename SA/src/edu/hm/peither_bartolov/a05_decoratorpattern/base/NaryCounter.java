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
     * an integer which indicate the used number system.
     */
    private final int numberSystem;
    
    /**
     * the current value of this counter.
     */
    private int currentValue = 0;
    
    public NaryCounter(int numberSystem) {
        if (numberSystem < 2 || numberSystem > 9) {
            throw new IllegalArgumentException("Please choose a number system between 2 and 9!");
        }
        this.numberSystem =  numberSystem;
    }
    
    @Override
    public int read() {
        return currentValue;
    }

    @Override
    public Counter tick() {
        char[] numberPartsAsChars = Integer.toString(currentValue).toCharArray();
        int[] numberParts = new int[numberPartsAsChars.length];
        for (int index = 0; index < numberPartsAsChars.length; index++) {
            final String value = "" + numberPartsAsChars[index];
            numberParts[index] = Integer.parseInt(value);
        }
        numberParts[numberParts.length-1]++;
        currentValue = 0;
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
                currentValue = (int)Math.pow(10, numberParts.length);
            }
            
        }
        int powerTo = numberParts.length-1;
        for (int index = 0; index < numberParts.length; index++) {
            currentValue += (int)(Math.pow(10, powerTo) * numberParts[index]);
            powerTo--;
        }
        return this;
    }
    
}
