package edu.hm.bartolov.a06_factory;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract Factory class.
 *
 * @author Eduard Bartolovic, Felix Peither
 */
public abstract class CounterFactory {
    
    private static List<CounterFactory> myFactories = new ArrayList<>();
    
    static CounterFactory get(){
        String type = System.getProperty("Factory.type");
            
        if (type == null) {
            throw new IllegalArgumentException("no valid Factory type");
        }
        
        type = addCounterFactory(type);
        
        if (!isValidFactoryType(type)) {
            throw new IllegalArgumentException("Please enter a valid Factory type.");
        }
        
        return getMyFactory(type);
    }
    
    private static boolean isValidFactoryType(String typeName) {
        boolean isValid = false;
        
        switch (typeName) {
            case "FakeCounterFactory":
                isValid = true;
                break;
            case "SwitchedCounterFactory":
                isValid = true;
                break;
            case "ReflectiveCounterFactory":
                isValid = true;
                break;
        }
        
        return isValid;
    }
    
    private static CounterFactory getMyFactory(String factoryType) {
        CounterFactory myFactory = null;
        
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
        }
        
        if (!myFactories.contains(myFactory)) {
            myFactories.add(myFactory);
        } else {
            myFactory = myFactories.get(myFactories.indexOf(myFactory));
        }
//        for (CounterFactory factory: myFactories) {
//            if (myFactory.getClass() == factory.getClass()) {
//                myFactory = factory;
//            } else {
//                myFactories.add(myFactory);
//            }
//        }
        
        return myFactory;
    }
    
    private static String addCounterFactory(String typename){
        if(typename.contains("CounterFactory"))
            return typename;
        
        return typename+"CounterFactory";
    }
            
            
}
