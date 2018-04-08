package edu.hm.software_architektur.a02_staticanalyzer;

import java.awt.List;

public class ExtendsImplements extends List implements Runnable { 

    @Override
    public void run() {
        System.out.println("42");
    }
    
}
