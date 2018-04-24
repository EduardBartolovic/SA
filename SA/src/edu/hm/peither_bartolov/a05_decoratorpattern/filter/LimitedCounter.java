package edu.hm.peither_bartolov.a05_decoratorpattern.filter;

import edu.hm.peither_bartolov.a05_decoratorpattern.Counter;

/**
 *
 * @author Edo
 */
public class LimitedCounter extends Filter{
    
    private final int limit;
    
    public LimitedCounter(Counter counter, int limit) {
        super(counter);
        
        if(limit < 0)
            throw new IllegalArgumentException();
        
        this.limit = limit;
    }

    @Override
    public Counter tick() {
        if(super.read() < limit)
            super.tick();
        return this;
    }
    
    
}
