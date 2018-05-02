package edu.hm.bartolov.a05_decoratorpattern.filter;

import edu.hm.cs.rs.arch.a05_decorator.Counter;

/**
 * printing Counter.
 * @author Eduard
 */
public class PrintCounter extends Filter{
    /**
     * character to add.
     */
    private final char character;
    
    /**
     * Constructor.
     * @param counter Counter
     * @param character char
     */
    public PrintCounter(Counter counter, char character) {
        super(counter);
        this.character = character;
    }

    @Override
    public Counter tick() {
        System.out.print(new String()+super.read()+character);
        super.tick();
        return this;
    }


    
    
}
