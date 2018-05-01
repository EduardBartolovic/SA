package edu.hm.peither_bartolov.a05_decoratorpattern.filter;

import edu.hm.cs.rs.arch.a05_decorator.Counter;

/**
 * Filter to shift the read value.
 * @author Edo
 */
public class ShiftedCounter extends Filter{
    /**
     * shifting by that value.
     */
    private final int shift;
    
    /**
     * Constructor.
     * @param counter Counter
     * @param shift int
     */
    public ShiftedCounter(Counter counter, int shift) {
        super(counter);
        
        if(shift < 0)
            throw new IllegalArgumentException();
        
        this.shift = shift;
    }

    @Override
    public int read() {
        return super.read()+shift;
    }

    @Override
    public Counter tick() {
        super.tick();
        return this;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.shift;
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
        final ShiftedCounter other = (ShiftedCounter) obj;
        if (this.shift != other.shift) {
            return false;
        }
        return super.equals(obj);
    }
    
    
    
    
    
}
