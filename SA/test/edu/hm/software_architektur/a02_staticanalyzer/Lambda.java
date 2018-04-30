package edu.hm.software_architektur.a02_staticanalyzer;

public class Lambda {
    public static void main(String... args) {
        Runnable r = () -> System.out.println(42);
        r.run();
    }
}
