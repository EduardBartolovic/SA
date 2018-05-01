package edu.hm.peither_bartolov.a05_decoratorpattern.filter;

import edu.hm.cs.rs.arch.a05_decorator.Counter;

/**
 * limiting a counter to defined. 
 * @author Eduard
 */
public class LimitedCounter extends Filter{
    /**
     * limit of counter.
     */
    private final int limit;
    
    /**
     * Constructor.
     * @param counter Counter
     * @param limit int
     */
    public LimitedCounter(Counter counter, int limit) {
        super(counter);
        
        if(limit < 0)
            throw new IllegalArgumentException();
        
        this.limit = limit;
    }

    @Override
    public int read() {
        final int readInt = super.read();
        if(readInt<limit)
            return readInt;
        return limit;
    }
    
    @Override
    public Counter tick() {
        super.tick();
        return this;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.limit;
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
        final LimitedCounter other = (LimitedCounter) obj;
        if (this.limit != other.limit) {
            return false;
        }
        return super.equals(obj);
    }
    
    
}
