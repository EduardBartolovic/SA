package edu.hm.bartolov.a08_mvc;

import edu.hm.bartolov.a08_mvc.datastore.writeable.MutableArtwork;
import edu.hm.bartolov.a08_mvc.datastore.writeable.data.ArtworkData;
import edu.hm.bartolov.a08_mvc.datastore.writeable.data.OfferingsData;
import edu.hm.bartolov.a08_mvc.view.Viewer;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Edo
 */
public class Main {
    
    public static void main(String... args){
        
        
        final Set<MutableArtwork> artworks = new HashSet<>();
        final ArtworkData art1 = new ArtworkData("1", 1);
        artworks.add(art1);
        final ArtworkData art2 = new ArtworkData("2", 2);
        artworks.add(art2);
        final ArtworkData art3 = new ArtworkData("3", 3);
        artworks.add(art3);
        final ArtworkData art4 = new ArtworkData("4", 4);
        artworks.add(art4);
        final ArtworkData art5 = new ArtworkData("5", 5);
        artworks.add(art5);
        final ArtworkData art6 = new ArtworkData("6", 6);
        artworks.add(art6);
        
       
        final OfferingsData offerings = new OfferingsData(artworks);
        
        final Viewer view1 = Viewer.make("Spectator", offerings, (Object) null);
        offerings.addObserver(view1);
        
    }
    
}
