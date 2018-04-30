package edu.hm.peither_bartolov.a06_factory;

import edu.hm.cs.rs.arch.a05_decorator.Counter;
import java.util.stream.Stream;


public class ReflectiveCounterFactory {
    
    private static final String PATH = "edu.hm.peither_bartolov.a05_decoratorpattern.";
    
     private static final String PATHFILTER = "edu.hm.peither_bartolov.a05_decoratorpattern.filter.";
    
     /**
      * for base Counter.
      * @param typename
      * @param args
      * @return
      * @throws ReflectiveOperationException 
      */
    public Counter make(String typename, int... args) throws ReflectiveOperationException {
        
        final Class<?> type;
        if(typename.contains("Counter")){
            type = Class.forName(PATH+typename);
        }else{
            type = Class.forName(PATH+typename+"Counter");
        }
        
        
        return Counter.class.cast(Stream.of(type.getDeclaredConstructors())
            .filter(ctor -> ctor.getParameterTypes().length == args.length)
            .peek(System.out::println)
            .peek(ctor -> ctor.setAccessible(true))
            .findAny()
            .orElseThrow(IllegalArgumentException::new)
            .newInstance(args)
        );
    }
    
    /**
     * for FilterCounter.
     * @param counter
     * @param typename
     * @param arg
     * @return
     * @throws ReflectiveOperationException 
     */
    public Counter make(Counter counter,String typename, int arg) throws ReflectiveOperationException {
        
        final Class<?> type;
        if(typename.contains("Counter")){
            type = Class.forName(PATHFILTER+typename);
        }else{
            type = Class.forName(PATHFILTER+typename+"Counter");
        }
        
        return Counter.class.cast(Stream.of(type.getDeclaredConstructors())
                                .peek(ctor -> ctor.setAccessible(true))
                                .findAny()
                                .orElseThrow(IllegalArgumentException::new)                               
                                .newInstance(counter,arg)
        );
    }
    
}
