package edu.hm.peither_bartolov.a05_decoratorpattern.filter;

import edu.hm.cs.rs.arch.a05_decorator.Counter;
import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.counter);
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
        final Filter other = (Filter) obj;
        return Objects.equals(this.counter, other.counter);
    }
    
    
}
