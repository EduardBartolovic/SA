package edu.hm.peither_bartolov.a05_decoratorpattern.base;

import edu.hm.peither_bartolov.a05_decoratorpattern.Counter;


public class UCounter implements Counter{
    private int currentValue = 0;

    @Override 
    public int read() {
        return currentValue;
    }

    @Override 
    public UCounter tick() {
        currentValue++;
        return this;
    }
    
}
