package edu.hm.peither_bartolov.a05_decoratorpattern.filter;

import edu.hm.cs.rs.arch.a05_decorator.Counter;

/**
 * slowing the lower Counter down.
 * @author Eduard
 */
public class SlowCounter extends Filter{
    /**
     * specified delay.
     */
    private final int delay;
    /**
     * the save how much delayed the class is.
     */
    private int counter = 1;
    
    /**
     * Constructor.
     * @param counter Counter
     * @param delay int
     */
    public SlowCounter(Counter counter,int delay) {
        super(counter);
        if(delay <= 0)
            throw new IllegalArgumentException();
        this.delay = delay;
    }

    @Override
    public Counter tick() {
        if(counter == delay){
            counter = 1;
            super.tick();
        }else{
            counter++;
        }
        
        return this;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.delay;
        hash = 61 * hash + this.counter;
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
        final SlowCounter other = (SlowCounter) obj;
        if (this.delay != other.delay) {
            return false;
        }
        if (this.counter != other.counter) {
            return false;
        }
        return super.equals(obj);
    }
    
    
    
}
