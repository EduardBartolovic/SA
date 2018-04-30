package edu.hm.software_architektur.a02_staticanalyzer;

public interface Interface {
    static void foo() {
        System.out.println(1);
    }
    
    default void bar() {
        System.out.println(2);
    }
}
