package edu.hm.peither_bartolov.a05_decoratorpattern.filter;

import edu.hm.peither_bartolov.a05_decoratorpattern.Counter;
import java.util.function.IntPredicate;

/**
 *
 * @author Edo
 */
public class SelectedCounter extends Filter{
    
    final IntPredicate predicate;
    
    public SelectedCounter(Counter counter , IntPredicate predicate) {
        super(counter);
        
        if(predicate == null)
            throw new NullPointerException();
        
        this.predicate = predicate;
    }

    @Override
    public int read() {
        if(predicate.test(super.read()))
            return super.read();
        return 0;
    }
    
    
    
}
