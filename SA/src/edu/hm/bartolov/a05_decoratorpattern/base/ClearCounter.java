package edu.hm.bartolov.a05_decoratorpattern.base;

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
    private int counterPositionAt;
    
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
        counterPositionAt = 0;
        readCounter = 0;
    }
    
    @Override
    public int read() {
        if (readCounter == 0) {
            firstTime = System.currentTimeMillis();
            readCounter++;
        } else if (readCounter == 2 && firstTime == System.currentTimeMillis()) {
//            final long secondTime = System.currentTimeMillis();
//            if (firstTime == secondTime) {
//                counterPositionAt = 0;
//            }
            counterPositionAt = 0;
        } else if (readCounter == 2 && firstTime != System.currentTimeMillis()) {
            firstTime = System.currentTimeMillis();
            readCounter = 1;
        } else {
            readCounter++;
        }
        
        return counterPositionAt;
    }

    @Override
    public Counter tick() {
        counterPositionAt++;
        readCounter = 0;
        return this;
    }
 
}
