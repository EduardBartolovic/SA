package edu.hm.peither_bartolov.a05_decoratorpattern.filter;

import edu.hm.cs.rs.arch.a05_decorator.Counter;
import java.util.function.IntPredicate;

/**
 * Filter to filter specified by a predicate.
 * @author Eduard
 */
public class SelectedCounter extends Filter{
   /**
    * filter condition
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
    public Counter tick() {
        do{
            super.tick();
        }while(!predicate.test(super.read())); // do it till value is right
        
        return this;
    }
    
    
    
    
    
}
