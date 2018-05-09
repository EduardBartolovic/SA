package edu.hm.bartolov.a06_factory;

import edu.hm.cs.rs.arch.a05_decorator.Counter;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstract Factory class.
 *
 * @author Eduard Bartolovic, Felix Peither
 */
public abstract class CounterFactory {
    
    private static final List<CounterFactory> myFactories = new ArrayList<>();
    
    public static CounterFactory get(){
        
        final String type = System.getProperty("Factory.type");
            
        if (type == null) {
            throw new IllegalArgumentException("no valid Factory type");
        }
        
        return getMyFactory(addCounterFactory(type));
    }
    
    private static CounterFactory getMyFactory(String factoryType) {
        CounterFactory myFactory;
        
        switch (factoryType) {
            case "FakeCounterFactory":
                myFactory = new FakeCounterFactory();
                break;
            case "SwitchedCounterFactory":
                myFactory = new SwitchedCounterFactory();
                break;
            case "ReflectiveCounterFactory":
                myFactory = new ReflectiveCounterFactory();
                break;
            default:
                throw new IllegalArgumentException("Please enter a valid Factory type.");
        }
        
        
        if (myFactories.contains(myFactory)) {
            myFactory = myFactories.get(myFactories.indexOf(myFactory));
        } else {
            myFactories.add(myFactory);
        }
        
        return myFactory;
    }
    
    private static String addCounterFactory(String typename){
        if(typename.contains("CounterFactory"))
            return typename;
        
        return typename+"CounterFactory";
    }
            
        
    /**
     * producing Counter.
     * @param string string
     * @param args varargs
     * @return fakeCounter
     */
    public Counter make(String string,int... args) throws ReflectiveOperationException {
        return null;
    }
    
    /**
     * producing Counter.
     * @param counter
     * @param string
     * @param arg
     * @return fakeCounter
     */
    public Counter make(Counter counter,String string,int arg) throws ReflectiveOperationException {
        return null;
    }
    
}
