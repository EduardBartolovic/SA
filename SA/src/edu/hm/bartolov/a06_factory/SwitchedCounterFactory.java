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

/**
 * Counter Factory.
 * @author Eduard Bartolovic
 */
public class SwitchedCounterFactory extends CounterFactory{

    /**
     * filter Counters.
     */
    private final Map<String,BiFunction<Counter,Integer,Counter>> filterMap;
    
    /**
     * baseCounters.
     */
    private final Map<String,Function<int[],Counter>> baseMap;

    /**
     * Constructor.
     */
    public SwitchedCounterFactory() {
        baseMap = new HashMap<>();
        filterMap = new HashMap<>();
        
        
        fillBaseMap();
        fillFilterMap();
    }
    
    /**
     * filling Maps.
     */
    private void fillFilterMap(){
        filterMap.put("JumpCounter",(counter,arg)->{return new JumpCounter(counter,arg);});
        filterMap.put("LimitedCounter",(counter,arg)->{return new LimitedCounter(counter,arg);});
        filterMap.put("PrintCounter",(counter,arg)->{return new PrintCounter(counter,(char)arg.intValue());});
        filterMap.put("ShiftedCounter",(counter,arg)->{return new ShiftedCounter(counter,arg);});
        filterMap.put("SlowCounter",(counter,arg)->{return new SlowCounter(counter,arg);});
    }
    
    /**
     * filling Maps.
     */
    private void fillBaseMap(){
        baseMap.put("UCounter",args->{ if(args.length != 0) throw new IllegalArgumentException();
        return new UCounter();});
        
        baseMap.put("LoopCounter",args->{if(args.length == 0) throw new IllegalArgumentException();
        return new LoopCounter(args);});
        
        baseMap.put("NaryCounter",args->{if(args.length != 1) throw new IllegalArgumentException();
        return new NaryCounter(args[0]);});
        
        baseMap.put("ClearCounter",args->{if(args.length != 0) throw new IllegalArgumentException(); 
        return new ClearCounter();});    
    }
    
    
     /**
      * for base Counter.
      * @param typename String
      * @param args int...
      * @return Counter
      */
    @Override
    public Counter make(String typename, int... args) {
        if(args == null)
            throw new IllegalArgumentException();
        
        final String type = addCounter(typename);
        
        if(baseMap.containsKey(type))
            return baseMap.get(type).apply(args);
        
        throw new IllegalArgumentException();
    }
    
    /**
     * for FilterCounter.
     * @param counter counter
     * @param typename string
     * @param arg int
     * @return Counter
     */
    @Override
    public Counter make(Counter counter,String typename, int arg) {
        
        final String type = addCounter(typename);
        
        if(filterMap.containsKey(type))
            return filterMap.get(type).apply(counter,arg);
        
        throw new IllegalArgumentException();
    }
    
    /**
     * adding Counter if neccessary.
     * @param typename String
     * @return String
     */
    private String addCounter(String typename){
        if(typename==null)
            throw new IllegalArgumentException();
        
        if(typename.contains("Counter"))
            return typename;
        
        return typename+"Counter";
    }
    
}
