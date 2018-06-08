package edu.hm.bartolov.a08_mvc;

import edu.hm.bartolov.a08_mvc.datastore.writeable.MutableArtwork;
import edu.hm.bartolov.a08_mvc.datastore.writeable.MutableOfferings;
import edu.hm.bartolov.a08_mvc.view.Viewer;

/**
 *
 * @author Edo
 */
public class Main {
    
    public static void main(String... args){
        MutableArtwork aw1 = MutableArtwork.make("TEST1", 20);
        MutableArtwork aw2 = MutableArtwork.make("TEST2", 21);
        
        MutableOfferings offer = MutableOfferings.make(aw1, aw2);
    
        Viewer spectator = Viewer.make("spectator", offer);
        offer.setBid(55);
        offer.setBidder("hallo");
        offer.notifyObservers();
        spectator.update(offer, new Object());
        
    }
    
}
