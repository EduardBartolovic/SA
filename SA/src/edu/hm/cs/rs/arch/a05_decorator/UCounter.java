/* (C) 2018, R. Schiedermeier, rs@cs.hm.edu
 * Oracle Corporation Java 1.8.0_121, Linux i386 4.14.15
 * tura: Intel Atom N270/1600 MHz, 2 Core(s), 2009 MByte RAM
 **/
package edu.hm.cs.rs.arch.a05_decorator;

/**
 * Elementarer Zaehler, der ab 0 in Einerschritten hochzaehlt.
 *
 * @author Reinhard Schiedermeier, rs@cs.hm.edu
 * @version 2016-05-18
 */
public class UCounter implements Counter {
    /** Aktueller Zaehlerstand. */
    private int currentValue = 0;

    @Override public int read() {
        return currentValue;
    }

    @Override public UCounter tick() {
        currentValue++;
        return this;
    }

}