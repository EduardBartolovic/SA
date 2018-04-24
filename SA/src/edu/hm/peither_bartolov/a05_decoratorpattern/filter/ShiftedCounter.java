package edu.hm.peither_bartolov.a05_decoratorpattern.filter;

import edu.hm.peither_bartolov.a05_decoratorpattern.Counter;

/**
 *
 * @author Edo
 */
public class ShiftedCounter extends Filter{
    
    private final int shift;
    
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
    
    
    
}
