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
        } else if (readCounter == 2) {
            final long secondTime = System.currentTimeMillis();
            if (firstTime == secondTime) {
                counterPositionAt = 0;
            }
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.counterPositionAt;
        hash = 97 * hash + (int) (this.firstTime ^ (this.firstTime >>> 32));
        hash = 97 * hash + this.readCounter;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClearCounter other = (ClearCounter) obj;
        if (this.counterPositionAt != other.counterPositionAt) {
            return false;
        }
        if (this.firstTime != other.firstTime) {
            return false;
        }
        return this.readCounter == other.readCounter;
    }
    
    
    
}
