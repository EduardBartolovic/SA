package edu.hm.peither_bartolov.a05_decoratorpattern.base;

import edu.hm.peither_bartolov.a05_decoratorpattern.Counter;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;


public class LoopCounter implements Counter{
    private final List<Integer> list;
    
    private int currentPosition = 0;
    
    public LoopCounter(Integer... args){
        if(args.length == 0)
            throw new NoSuchElementException();
        list = Arrays.asList(args);
    }
    
    
    @Override 
    public int read() {
        return list.get(currentPosition);
    }

    @Override 
    public LoopCounter tick() {
        currentPosition = (currentPosition+1)%list.size();
        return this;
    }
}
