package edu.hm.peither_bartolov.a06_factory;

import edu.hm.cs.rs.arch.a05_decorator.Counter;
import java.lang.reflect.Constructor;
import java.util.stream.Stream;


public class ReflectiveCounterFactory {
    
    private static final String PATH = "edu.hm.peither_bartolov.a05_decoratorpattern.base.";
    
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
        try{
            if(typename.contains("Counter")){
                type = Class.forName(PATH+typename);
            }else{
                type = Class.forName(PATH+typename+"Counter");
            }
        }catch(ClassNotFoundException exce){
            throw new IllegalArgumentException("class does not exist");
        }
        
        final Constructor constructor = type.getDeclaredConstructors()[0];
        if(args.length == 0)
            return Counter.class.cast(constructor.newInstance());
       
        if(args.length == 1)
            return Counter.class.cast(constructor.newInstance(args[0]));
        
        return Counter.class.cast(constructor.newInstance(args));
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
        try{
            if(typename.contains("Counter")){
                type = Class.forName(PATHFILTER+typename);
            }else{
                type = Class.forName(PATHFILTER+typename+"Counter");
            }
        }catch(ClassNotFoundException exce){
            throw new IllegalArgumentException("class does not exist");
        }
        
        return Counter.class.cast(Stream.of(type.getDeclaredConstructors())
                                .peek(ctor -> ctor.setAccessible(true))
                                .findAny()
                                .orElseThrow(IllegalArgumentException::new)                               
                                .newInstance(counter,arg)
        );
    }
    
}
