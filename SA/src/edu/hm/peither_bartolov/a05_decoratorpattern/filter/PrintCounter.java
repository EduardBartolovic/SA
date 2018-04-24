package edu.hm.peither_bartolov.a05_decoratorpattern.filter;

import edu.hm.peither_bartolov.a05_decoratorpattern.Counter;

public class PrintCounter extends Filter{
    
    private final char character;
    
    public PrintCounter(Counter counter, char character) {
        super(counter);
        this.character = character;
    }

    @Override
    public Counter tick() {
        System.out.print(super.read() + character);
        return super.tick();
    }
    
}
