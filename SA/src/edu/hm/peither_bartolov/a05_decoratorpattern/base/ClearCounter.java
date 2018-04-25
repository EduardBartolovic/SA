package edu.hm.peither_bartolov.a05_decoratorpattern.base;

import edu.hm.cs.rs.arch.a05_decorator.Counter;

/**
 * The clear counter which resets the counter after read is called
 * three times within the same millisecond.
 * 
 * @author Eduard Bartolovic, Felix Peither
 */
public class ClearCounter implements Counter{

    /**
     * the current value of this counter.
     */
    private int currentValue;
    
    /**
     * the time read was called for the first time.
     */
    private long firstTime;
    
    /**
     * number of times read was called.
     */
    private int readCounter;
    
    /**
     * Constructor for the ClearCounter.
     */
    public ClearCounter() {
        currentValue = 0;
        readCounter = 0;
    }
    
    @Override
    public int read() {
        if (readCounter == 0) {
            firstTime = System.currentTimeMillis();
            readCounter++;
        } else if (readCounter == 2) {
            final long secondTime = System.currentTimeMillis();
//            final long deltaTime = secondTime - firstTime;
//            if (deltaTime <= 1000) {
            if (firstTime == secondTime) {
                currentValue = 0;
            }
        } else {
            readCounter++;
        }
        return currentValue;
    }

    @Override
    public Counter tick() {
        currentValue++;
        readCounter = 0;
        return this;
    }
    
}
