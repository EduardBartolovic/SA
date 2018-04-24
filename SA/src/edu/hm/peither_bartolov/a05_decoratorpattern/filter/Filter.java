package edu.hm.peither_bartolov.a05_decoratorpattern.filter;

import edu.hm.peither_bartolov.a05_decoratorpattern.Counter;

public abstract class Filter implements Counter{
    
    private final Counter counter;
    
    public Filter(Counter counter){
        this.counter = counter;
    }
    
    @Override 
    public int read() {
        return counter.read();
    }

    @Override 
    public Counter tick() {
        return counter.tick();
    }
}
