package edu.hm.peither_bartolov.a05_decoratorpattern.base;

import edu.hm.peither_bartolov.a05_decoratorpattern.Counter;
import java.util.NoSuchElementException;


public class LoopCounter implements Counter{
    private final int[] list;
    
    private int currentPosition = 0;
    
    public LoopCounter(int... args){
        if(args.length == 0)
            throw new NoSuchElementException();
        
        list = new int[args.length];
        System.arraycopy(args,0, list,0, args.length);
    }
    
    
    @Override 
    public int read() {
        return list[currentPosition];
    }

    @Override 
    public LoopCounter tick() {
        currentPosition = (currentPosition+1)%list.length;
        return this;
    }
}
