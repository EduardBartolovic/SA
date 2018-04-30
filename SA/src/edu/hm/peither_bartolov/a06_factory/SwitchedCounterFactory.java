package edu.hm.peither_bartolov.a06_factory;

import edu.hm.cs.rs.arch.a05_decorator.Counter;
import edu.hm.cs.rs.arch.a05_decorator.UCounter;
import edu.hm.peither_bartolov.a05_decoratorpattern.base.LoopCounter;
import edu.hm.peither_bartolov.a05_decoratorpattern.base.NaryCounter;
import edu.hm.peither_bartolov.a05_decoratorpattern.filter.JumpCounter;
import edu.hm.peither_bartolov.a05_decoratorpattern.filter.LimitedCounter;
import edu.hm.peither_bartolov.a05_decoratorpattern.filter.PrintCounter;
import edu.hm.peither_bartolov.a05_decoratorpattern.filter.ShiftedCounter;
import edu.hm.peither_bartolov.a05_decoratorpattern.filter.SlowCounter;


public class SwitchedCounterFactory extends CounterFactory{
    
    private static final String PATH = "edu.hm.peither_bartolov.a05_decoratorpattern.";
    
     private static final String PATHFILTER = "edu.hm.peither_bartolov.a05_decoratorpattern.filter.";
    
     /**
      * for base Counter.
      * @param typename
      * @param args
      * @return
      */
    public Counter make(String typename, int... args) {
        
        final String type;
        if(typename.contains("Counter")){
            type = typename;
        }else{
            type = typename+"Counter";
        }
        
        if("UCounter".equals(type)){
            if(args.length != 0)
                throw new IllegalArgumentException();
            return new UCounter();
        }else if("LoopCounter".equals(type)){
            if(args.length < 1)
                throw new IllegalArgumentException();
            return new LoopCounter(args);
        }else if("NaryCounter".equals(type)){
            if(args.length != 1)
                throw new IllegalArgumentException();
            return new NaryCounter(args[0]);
        }
        
        throw new IllegalArgumentException();
    }
    
    /**
     * for FilterCounter.
     * @param counter
     * @param typename
     * @param arg
     * @return
     */
    public Counter make(Counter counter,String typename, int arg) {
                
        final String type;
        if(typename.contains("Counter")){
            type = typename;
        }else{
            type = typename+"Counter";
        }
        
        if("JumpCounter".equals(type)){
            return new JumpCounter(counter,arg);
        }else if("LimitedCounter".equals(type)){
            return new LimitedCounter(counter,arg);
        }else if("PrintCounter".equals(type)){
            return new PrintCounter(counter,(char)arg);
        }else if("ShiftedCounter".equals(type)){
            return new ShiftedCounter(counter,arg);
        }else if("SlowCounter".equals(type)){
            return new SlowCounter(counter,arg);
        }
        
        throw new IllegalArgumentException();
    }
    
}
