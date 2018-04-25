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
    
    
    
}
