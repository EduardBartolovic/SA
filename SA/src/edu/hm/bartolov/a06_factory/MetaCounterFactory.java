
package edu.hm.bartolov.a06_factory;

import edu.hm.cs.rs.arch.a05_decorator.Counter;

/**
 * will always produce a factory.
 * @author Eduard
 */
public class MetaCounterFactory extends CounterFactory{
    
    /**
     * trying to producing Counter.
     * @param typename string
     * @param args varargs
     * @return counterCounter
     */
    @Override
    public Counter make(String typename, int... args) {
        
       
        Counter counter;
        try{
            final SwitchedCounterFactory sFactory = new SwitchedCounterFactory();
            counter = sFactory.make(typename, args);
            
        }catch(IllegalArgumentException illExce){

                final FakeCounterFactory fFactory = new FakeCounterFactory();
                counter = fFactory.make("");
            
        }
        return counter;
    }
    
     /**
     * trying to producing decorated Counter.
     * @param counter Counter
     * @param typename string
     * @param arg int
     * @return counterCounter
     */
    @Override
    public Counter make(Counter counter,String typename, int arg) {
        
        Counter factory;
        
        try{
            factory = new SwitchedCounterFactory().make(counter,typename, arg);
        }catch(IllegalArgumentException illExce){
            factory = new FakeCounterFactory().make("");
        }
        
        return factory;
    }
    
}
