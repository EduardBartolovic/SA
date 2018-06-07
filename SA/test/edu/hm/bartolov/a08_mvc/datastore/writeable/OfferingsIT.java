package edu.hm.bartolov.a08_mvc.datastore.writeable;

import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Edo
 */
public class OfferingsIT {
    
    public OfferingsIT() {
    }

    @Test(timeout = 2000)
    public void test1Smoke() {
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
        
        offerings.setBid(1);
        offerings.setBidder("Hans");
        
        
        assertEquals(offerings.getBid(),1);
        assertEquals(offerings.getBidder(),"Hans");
        
    }
    
    @Test(timeout = 2000,expected = IllegalArgumentException.class)
    public void test2Smoke() {
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
        
        offerings.setBid(-1);
        
    }
    
    @Test(timeout = 2000)
    public void test3NewBidder() {
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
        
        offerings.setBid(1);
        offerings.setBidder("Hans");
        
        
        offerings.setBid(5);
        offerings.setBidder("Markus");
        
        assertEquals(offerings.getBid(),5);
        assertEquals(offerings.getBidder(),"Markus");
        
    }
    
    
    @Test(timeout = 2000)
    public void test4() { // not ready+++++++++++++++++++++++++++++++++++++++++++
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
        
        MutableArtwork a1 = offerings.getArtworks().findFirst().get();
        
    }
    
    
    
    
}
