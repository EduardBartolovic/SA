package edu.hm.bartolov.a08_mvc;

import edu.hm.bartolov.a08_mvc.datastore.writeable.MutableArtwork;
import edu.hm.bartolov.a08_mvc.datastore.writeable.MutableOfferings;
import edu.hm.bartolov.a08_mvc.view.Viewer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import static java.nio.charset.StandardCharsets.UTF_8;

/**
 *
 * @author Edo
 */
public class Main {
    
    public static void main(String... args){
        System.out.println("start auction");
        final MutableArtwork aw1 = MutableArtwork.make("TEST1", 20);
        final MutableArtwork aw2 = MutableArtwork.make("TEST2", 21);
        
        final MutableOfferings offer = MutableOfferings.make(aw1, aw2); 
        final PrintWriter printw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, UTF_8)));
        final Viewer spectator = Viewer.make("spectator", offer ,printw);
        
        offer.setBid(55);
        offer.setBidder("hallo");
        offer.setStepsRemaining(4);
        offer.notifyObservers();
        offer.setStepsRemaining(3);
        offer.notifyObservers();
        offer.setStepsRemaining(2);
        offer.notifyObservers();
        offer.setStepsRemaining(1);
        offer.notifyObservers();
        offer.setStepsRemaining(0);
        offer.notifyObservers();
        
        System.out.println("end auction");
    }
    
}
