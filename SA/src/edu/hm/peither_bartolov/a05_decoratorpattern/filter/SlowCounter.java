package edu.hm.peither_bartolov.a05_decoratorpattern.filter;

import edu.hm.peither_bartolov.a05_decoratorpattern.Counter;

/**
 *
 * @author Edo
 */
public class SlowCounter extends Filter{
    
    private final int delay;
    private int counter = 0;
    
    public SlowCounter(Counter counter,int delay) {
        super(counter);
        if(delay <= 0)
            throw new IllegalArgumentException();
        this.delay = delay;
    }

    @Override
    public Counter tick() {
        if(counter == delay){
            counter = 0;
            super.tick();
        }else{
            counter++;
        }
        
        return this;
    }
    
    
    
}
