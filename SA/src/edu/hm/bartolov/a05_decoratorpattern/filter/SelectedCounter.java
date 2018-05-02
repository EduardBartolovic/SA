package edu.hm.bartolov.a05_decoratorpattern.filter;

import edu.hm.cs.rs.arch.a05_decorator.Counter;
import java.util.function.IntPredicate;

/**
 * Filter to filter specified by a predicate.
 * @author Eduard
 */
public class SelectedCounter extends Filter{
   /**
    * filter condition.
    */
    private final IntPredicate predicate;
    
    /**
     * Constructor.
     * @param counter Counter
     * @param predicate IntPredicate
     */
    public SelectedCounter(Counter counter , IntPredicate predicate) {
        super(counter);
        
        if(predicate == null)
            throw new NullPointerException();
        
        this.predicate = predicate;
    }

    @Override
    public int read() {
        while(!predicate.test(super.read())){
            super.tick();
        }
        return super.read();
    }


    @Override
    public Counter tick() {
        super.tick();
        return this;
    }

    
    
}
