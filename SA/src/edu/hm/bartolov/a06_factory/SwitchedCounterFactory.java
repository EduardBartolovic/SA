package edu.hm.bartolov.a06_factory;

import edu.hm.cs.rs.arch.a05_decorator.Counter;
import edu.hm.cs.rs.arch.a05_decorator.UCounter;
import edu.hm.bartolov.a05_decoratorpattern.base.ClearCounter;
import edu.hm.bartolov.a05_decoratorpattern.base.LoopCounter;
import edu.hm.bartolov.a05_decoratorpattern.base.NaryCounter;
import edu.hm.bartolov.a05_decoratorpattern.filter.JumpCounter;
import edu.hm.bartolov.a05_decoratorpattern.filter.LimitedCounter;
import edu.hm.bartolov.a05_decoratorpattern.filter.PrintCounter;
import edu.hm.bartolov.a05_decoratorpattern.filter.ShiftedCounter;
import edu.hm.bartolov.a05_decoratorpattern.filter.SlowCounter;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;


public class SwitchedCounterFactory extends CounterFactory{

    private final Map<String,BiFunction<Counter,Integer,Counter>> filterMap;
    
    private final Map<String,Function<int[],Counter>> baseMap;

    public SwitchedCounterFactory() {
        baseMap = new HashMap<>();
        filterMap = new HashMap<>();
        baseMap.put("UCounter",(args)->{ if(args.length != 0) throw new IllegalArgumentException(); return new UCounter();});
        baseMap.put("LoopCounter",(args)->{if(args.length == 0) throw new IllegalArgumentException(); return new LoopCounter(args);});
        baseMap.put("NaryCounter",(args)->{if(args.length != 1) throw new IllegalArgumentException(); return new NaryCounter(args[0]);});
        baseMap.put("ClearCounter",(args)->{if(args.length != 0) throw new IllegalArgumentException(); return new ClearCounter();});
        
        filterMap.put("JumpCounter",(counter,arg)->{return new JumpCounter(counter,arg);});
        filterMap.put("LimitedCounter",(counter,arg)->{return new LimitedCounter(counter,arg);});
        filterMap.put("PrintCounter",(counter,arg)->{return new PrintCounter(counter,(char)arg.intValue());});
        filterMap.put("ShiftedCounter",(counter,arg)->{return new ShiftedCounter(counter,arg);});
        filterMap.put("SlowCounter",(counter,arg)->{return new SlowCounter(counter,arg);});
        
    }
    
    
    
     /**
      * for base Counter.
      * @param typename
      * @param args
      * @return
      */
    public Counter make(String typename, int... args) {
        
        final String type = addCounter(typename);
        
        if(baseMap.containsKey(type))
            return baseMap.get(type).apply(args);
        
        throw new IllegalArgumentException("" + args[0]);
    }
    
    /**
     * for FilterCounter.
     * @param counter
     * @param typename
     * @param arg
     * @return
     */
    public Counter make(Counter counter,String typename, int arg) {
        
        final String type = addCounter(typename);
        
        if(filterMap.containsKey(type))
            return filterMap.get(type).apply(counter,arg);
        
        throw new IllegalArgumentException();
    }
    
    private String addCounter(String typename){
        if(typename.contains("Counter"))
            return typename;
        
        return typename+"Counter";
    }
    
}
