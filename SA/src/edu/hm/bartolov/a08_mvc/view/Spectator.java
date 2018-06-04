
package edu.hm.bartolov.a08_mvc.view;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edo
 */
public class Spectator extends Viewer{

    Spectator(Object object) {
        super(null);
        
        new Thread(()-> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Spectator.class.getName()).log(Level.SEVERE, null, ex);
            }
           update(null,null);
        }).start();
    }
    
    @Override
    public void update(Observable o, Object arg) {
        
        System.out.print("Its so quiet. I have a bad feeling...");
    }
    
}
