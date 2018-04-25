package edu.hm.peither_bartolov.a05_decoratorpattern;

import edu.hm.cs.rs.arch.a05_decorator.Counter;
import edu.hm.cs.rs.arch.a05_decorator.UCounter;
import edu.hm.peither_bartolov.a05_decoratorpattern.filter.JumpCounter;
import edu.hm.peither_bartolov.a05_decoratorpattern.filter.PrintCounter;
import edu.hm.peither_bartolov.a05_decoratorpattern.filter.SelectedCounter;

/**
 *
 * @author Edo
 */
public class Main {
    public static void main(String... args){
        Counter loopCounter = new UCounter();
        final Counter counter = new JumpCounter(new PrintCounter(new SelectedCounter(loopCounter,n -> n%2 == 0),'\n'),1);
        while(true)
            counter.tick();
        
    }
}
