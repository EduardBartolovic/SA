package edu.hm.peither_bartolov.a05_decoratorpattern.filter;

import edu.hm.peither_bartolov.a05_decoratorpattern.Counter;

/**
 *
 * @author Edo
 */
public class JumpCounter extends Filter{
    
    private final int jump;
    
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
