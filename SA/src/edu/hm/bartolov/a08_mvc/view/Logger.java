package edu.hm.bartolov.a08_mvc.view;

import java.util.Observable;

/**
 *
 * @author Computer
 */
public class Logger extends Viewer{
    
    Logger(Object... args) {
        super(null);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("I don't know what I'm doing!");
    }
}
