package edu.hm.bartolov.a06_factory;

import edu.hm.cs.rs.arch.a05_decorator.Counter;
import java.util.HashMap;
import java.util.Map;

/**
 * Abstract Factory class.
 *
 * @author Eduard Bartolovic, Felix Peither
 */
public abstract class CounterFactory {
      
    /**
     * A map where already produced Factories are stored.
     */
    private static final Map<String, CounterFactory> FACTORYMAPS = new HashMap<>();
    
    /**
     * Abstract make method.
     * 
     * To be implemented by the child classes.
     * 
     * @param string string
     * @param args varargs
     * @return fakeCounter
     * @throws ReflectiveOperationException for the reflective counter
     */
    public abstract Counter make(String string,int... args) throws ReflectiveOperationException;
    
    /**
     * Abstract make method.
     * 
     * To be implemented by the child classes.
     * 
     * @param counter Counter
     * @param string string
     * @param arg int
     * @return fakeCounter
     * @throws ReflectiveOperationException for the reflective counter
     */
    public abstract Counter make(Counter counter,String string,int arg) throws ReflectiveOperationException;
    
    /**
     * Get a Factory with the System property Factory.type as a resource.
     * 
     * @return a new Factory or an already produced one.
     */
    public static CounterFactory get(){
        
        final String type = System.getProperty("Factory.type");
            
        if (type == null) {
            throw new IllegalArgumentException("no valid Factory type");
        }
        
        return getMyFactory(addCounterFactory(type));
    }
    
    /**
     * Gets a Factory from a factory type.
     * 
     * @param factoryType The type of factory which is to be get as a String
     * @return new Factory, if there already is one in the FACTORYMAPS
     * returns the already produces Factory
     */
    private static CounterFactory getMyFactory(String factoryType) {

        if (FACTORYMAPS.keySet().contains(factoryType))
            return FACTORYMAPS.get(factoryType);
        
        final CounterFactory myFactory;
        switch (factoryType) {
            case "FakeCounterFactory":
                myFactory = new FakeCounterFactory();
                break;
            case "SwitchedCounterFactory":
                myFactory = new SwitchedCounterFactory();
                break;
//            case "ReflectiveCounterFactory":
//                myFactory = new ReflectiveCounterFactory();
//                break;
            case "MetaCounterFactory":
                myFactory = new MetaCounterFactory();
                break;
            default:
                throw new IllegalArgumentException("Please enter a valid Factory type.");
        }
        
        FACTORYMAPS.put(factoryType, myFactory);
        
        return myFactory;
    }
    
    /**
     * If absent, adds the suffix "CounterFactory" to the type name of the 
     * System property.
     * 
     * @param typename The value of the System property Factory.type
     * @return the exdented type name if "CounterFactory" is absend
     */
    private static String addCounterFactory(String typename){
        if(typename.contains("CounterFactory"))
            return typename;
        
        return typename+"CounterFactory";
    }
}
