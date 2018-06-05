package edu.hm.bartolov.a08_mvc;

import edu.hm.bartolov.a08_mvc.datastore.writeable.MutableArtwork;
import edu.hm.bartolov.a08_mvc.datastore.writeable.MutableOfferings;
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
        final MutableArtwork art1 = MutableArtwork.make("1", 1);
        artworks.add(art1);
        final MutableArtwork art2 = MutableArtwork.make("2", 2);
        artworks.add(art2);
        final MutableArtwork art3 = MutableArtwork.make("3", 3);
        artworks.add(art3);
        final MutableArtwork art4 = MutableArtwork.make("4", 4);
        artworks.add(art4);
        final MutableArtwork art5 = MutableArtwork.make("5", 5);
        artworks.add(art5);
        final MutableArtwork art6 = MutableArtwork.make("6", 6);
        artworks.add(art6);
       
        final MutableOfferings offerings = MutableOfferings.make(artworks.toArray(new MutableArtwork[6]));
        
        final Viewer view1 = Viewer.make("spectator", offerings, (Object) null);
        offerings.addObserver(view1);
        
    }
    
}
