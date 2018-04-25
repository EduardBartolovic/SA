package edu.hm.peither_bartolov.a05_decoratorpattern.filter;

import edu.hm.cs.rs.arch.a05_decorator.Counter;

/**
 * abstract filterclass to minimize Code from Filters.
 * @author Eduard
 */
public abstract class Filter implements Counter{
    /**
     * saving the upper counter.
     */
    private final Counter counter;
    
    /**
     * Constructor.
     * @param counter 
     */
    public Filter(Counter counter){
        if(counter == null)
            throw new NullPointerException();
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
