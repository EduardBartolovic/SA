package edu.hm.peither_bartolov.a05_decoratorpattern.base;

import edu.hm.cs.rs.arch.a05_decorator.Counter;
import java.util.NoSuchElementException;

/**
 * Base Counter.
 * @author Felix Peither, Eduard Bartolovic
 */
public class LoopCounter implements Counter{
    /**
     * will save the ints.
     */
    private final int[] list;
    
    /**
     * saving the position which element will be red out.
     */
    private int currentPosition;
    
    /**
     * Constructor.
     * @param args int varargs
     */
    public LoopCounter(int... args){
        currentPosition = 0;
        if (args.length == 0) {
            throw new NoSuchElementException();
        }
        
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
