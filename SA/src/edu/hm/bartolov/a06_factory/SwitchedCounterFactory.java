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
     * Function to produce Counter.
     */
    private static final Function<int[],Counter> UCOUNTERFACTORY = (int... args) -> {
        if(args.length == 0)
            return new UCounter();
        
        throw new IllegalArgumentException();
    };
    
    /**
     * Function to produce Counter.
     */
    private static final Function<int[],Counter> LOOPCOUNTERFACTORY = (int... args) -> {
        if(args.length != 0)
            return new LoopCounter(args);
        
        throw new IllegalArgumentException();
    };
    
    /**
     * Function to produce Counter.
     */
    private static final Function<int[],Counter> NARYCOUNTERFACTORY = (int... args) -> {
        if(args.length == 1)
            return new NaryCounter(args[0]);
        
        throw new IllegalArgumentException();
    };
    
    /**
     * Function to produce Counter.
     */
    private static final Function<int[],Counter> CLEARCOUNTERFACTORY = (int... args) -> {
        if(args.length == 0)
            return new ClearCounter();
        
        throw new IllegalArgumentException();
    };    
    
    /**
     * BiFunction to produce FilterCounter.
     */
    private static final BiFunction<Counter,Integer,Counter> PRINTCOUNTERFACTORY = (Counter counter, Integer arg) -> new PrintCounter(counter,(char)arg.intValue());
    
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
        filterMap.put("JumpCounter",JumpCounter::new);
        filterMap.put("LimitedCounter",LimitedCounter::new);
        filterMap.put("PrintCounter",PRINTCOUNTERFACTORY);
        filterMap.put("ShiftedCounter",ShiftedCounter::new);
        filterMap.put("SlowCounter",SlowCounter::new);
    }
    
    /**
     * filling Maps.
     */
    private void fillBaseMap(){
        baseMap.put("UCounter",UCOUNTERFACTORY);
        
        baseMap.put("LoopCounter",LOOPCOUNTERFACTORY);
        
        baseMap.put("NaryCounter",NARYCOUNTERFACTORY);
        
        baseMap.put("ClearCounter",CLEARCOUNTERFACTORY);    
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
