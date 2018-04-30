package edu.hm.software_architektur.a02_staticanalyzer;

public class Foo {
    Foo() {
        System.out.println(1);
    }
    
    @Override public String toString() {
        return this == new Foo()? "1": "";
    }
}
