
package edu.hm.bartolov.a06_factory;

import edu.hm.cs.rs.arch.a05_decorator.Counter;

/**
 * fake factory producing fake counter.
 * @author Eduard
 */
public class FakeCounterFactory extends CounterFactory{
    
    private final FakeCounter fCounter = new FakeCounter();
    
    /**
     * producing Counter.
     * @param string string
     * @param args varargs
     * @return fakeCounter
     */
    @Override
    public Counter make(String string,int... args) {
        return fCounter;
    }
    
    /**
     * producing Counter.
     * @param counter
     * @param string
     * @param arg
     * @return fakeCounter
     */
    @Override
    public Counter make(Counter counter,String string,int arg) {
        return fCounter;
    }
    
    
    /**
     * private fakeCounter class
     */
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