
package edu.hm.bartolov.a06_factory;

import edu.hm.cs.rs.arch.a05_decorator.Counter;

/**
 *
 * @author Eduard
 */
public class MetaCounterFactory extends CounterFactory{
    
    public Counter make(String typename, int... args) {
        
       
        Counter counter;
        try{
            final SwitchedCounterFactory sFactory = new SwitchedCounterFactory();
            counter = sFactory.make(typename, args);
            
        }catch(IllegalArgumentException illExce){
            try{
                final ReflectiveCounterFactory rFactory = new ReflectiveCounterFactory();
                counter = rFactory.make(typename,args);
            }catch(ReflectiveOperationException | IllegalArgumentException refIllExce){
                final FakeCounterFactory fFactory = new FakeCounterFactory();
                counter = fFactory.make();
            }
            
        }
        return counter;
    }
    
    public Counter make(Counter counter,String typename, int arg) {
        
        final SwitchedCounterFactory sFactory = new SwitchedCounterFactory();
        
        try{
            return sFactory.make(counter,typename, arg);
        }catch(IllegalArgumentException illExce){
            final FakeCounterFactory fFactory = new FakeCounterFactory();
            return fFactory.make();
        }
        
    }
    
}