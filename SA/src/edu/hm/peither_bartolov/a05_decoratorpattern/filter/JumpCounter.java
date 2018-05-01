package edu.hm.peither_bartolov.a05_decoratorpattern.filter;

import edu.hm.cs.rs.arch.a05_decorator.Counter;

/**
 * Counter which is always skipping a definded amount of numbers.
 * @author Eduard
 */
public class JumpCounter extends Filter{
    /**
     * amount of values to skip.
     */
    private final int jump;
    
    /**
     * Constructor.
     * @param counter a upper Counter.
     * @param jump amount of values to skip.
     */
    public JumpCounter(Counter counter,int jump) {
        super(counter);
        
        if(jump < 0)
            throw new IllegalArgumentException();
        
        this.jump = jump;
    }

    @Override
    public Counter tick() {
        for(int counter = 0; counter < jump ; counter++)
            super.tick();
        return this;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.jump;
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
        final JumpCounter other = (JumpCounter) obj;
        if (this.jump != other.jump) {
            return false;
        }
        return super.equals(obj);
    }
    
    
    
}
