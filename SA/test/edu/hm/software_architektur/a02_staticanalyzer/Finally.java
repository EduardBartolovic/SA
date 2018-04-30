package edu.hm.software_architektur.a02_staticanalyzer;

public class Finally {
    public static void main(String... args) {
        try {
            System.out.println(1);
        }
        finally {
            System.out.println(2);
        }
    }
}
