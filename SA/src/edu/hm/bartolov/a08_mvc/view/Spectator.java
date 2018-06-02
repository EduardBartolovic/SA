
package edu.hm.bartolov.a08_mvc.view;

import java.util.Observable;

/**
 *
 * @author Edo
 */
public class Spectator implements Viewer{

    private final Object object;

    Spectator(Object object) {
        this.object = object;
    }
    
    @Override
    public void update(Observable o, Object arg) {
        
        System.out.print("Its so quiet. I have a bad feeling...");
    }
    
}
