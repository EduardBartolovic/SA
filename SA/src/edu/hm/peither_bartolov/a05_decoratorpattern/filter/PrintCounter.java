package edu.hm.peither_bartolov.a05_decoratorpattern.filter;

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
        System.out.print(""+super.read()+character);
        super.tick();
        return this;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.character;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PrintCounter other = (PrintCounter) obj;
        if (this.character != other.character) {
            return false;
        }
        return super.equals(obj);
    }
    
    
    
}
