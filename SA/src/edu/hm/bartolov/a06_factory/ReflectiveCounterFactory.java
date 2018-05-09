package edu.hm.bartolov.a06_factory;

import edu.hm.cs.rs.arch.a05_decorator.Counter;
import java.lang.reflect.Constructor;
import java.util.stream.Stream;

/**
 * A reflection Factory.
 * @author Felix Peither, Eduard Bartolovic
 */
public class ReflectiveCounterFactory extends CounterFactory{
    
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
        final Counter counter;
        try{
            if(args.length == 0)
                counter = Counter.class.cast(constructor.newInstance());
            else if(constructor.isVarArgs())
                counter = Counter.class.cast(constructor.newInstance(args));
            else
                counter = Counter.class.cast(constructor.newInstance(args[0]));
            
        }catch(ReflectiveOperationException exe){
            throw new IllegalArgumentException();
        }
        
        return counter;
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
        
        final Class<?> type = getClassType(typename);
        
        final Counter newCounter;
        try{
            newCounter = Counter.class.cast(Stream.of(type.getDeclaredConstructors())
                                    .filter(ctor -> ctor.getParameterTypes().length == 2)
                                    .peek(ctor -> ctor.setAccessible(true))
                                    .findAny()
                                    .orElseThrow(IllegalArgumentException::new)                               
                                    .newInstance(counter,arg));
        
        }catch(ReflectiveOperationException exe){
            throw new IllegalArgumentException();
        }
        return newCounter;
    }
    
    
    private Class<?> getClassType(String typename){
        final Class<?> type;
        try{
            if(typename.contains("Counter"))
                type =  Class.forName(PATHFILTER+typename);
            else
                type = Class.forName(PATHFILTER+typename+"Counter");
            
        }catch(ClassNotFoundException exce){
            throw new IllegalArgumentException("class does not exist");
        }
        
        return type;
    }

}
