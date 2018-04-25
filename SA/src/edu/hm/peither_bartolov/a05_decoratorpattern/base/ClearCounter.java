package edu.hm.peither_bartolov.a05_decoratorpattern.base;

import edu.hm.cs.rs.arch.a05_decorator.Counter;

public class ClearCounter implements Counter{

    private int currentValue = 0;
    
    private long firstTime = 0;
    
    private int readCounter = 0;
    
    @Override
    public int read() {
        if (readCounter == 0) {
            firstTime = System.currentTimeMillis();
            readCounter++;
        } else if (readCounter == 2) {
            final long secondTime = System.currentTimeMillis();
//            final long deltaTime = secondTime - firstTime;
//            if (deltaTime <= 1000) {
            if (firstTime == secondTime) {
                currentValue = 0;
            }
        } else {
            readCounter++;
        }
        return currentValue;
    }

    @Override
    public Counter tick() {
        currentValue++;
        readCounter = 0;
        return this;
    }
    
}
