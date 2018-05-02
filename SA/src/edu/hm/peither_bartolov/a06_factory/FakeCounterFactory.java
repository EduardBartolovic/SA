
package edu.hm.peither_bartolov.a06_factory;

import edu.hm.cs.rs.arch.a05_decorator.Counter;

/**
 *
 * @author Eduard
 */
public class FakeCounterFactory extends CounterFactory{
    
    
    public Counter make() {
        return new FakeCounter();
    }
    
    public Counter make(String string,int... args) {
        return new FakeCounter();
    }
    
    public Counter make(Counter counter,String string,int arg) {
        return new FakeCounter();
    }
    
    
    
    private class FakeCounter implements Counter{

        @Override
        public int read() {
            return 0;
        }

        @Override
        public Counter tick() {
            return this;
        }
    }
}