package edu.hm.bartolov.a08_mvc.datastore.writeable;

import edu.hm.bartolov.a08_mvc.datastore.writeable.data.OfferingsData;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 * @author Edo
 */
public interface MutableOfferings {
    
    public static MutableOfferings make(MutableArtwork... artworks){
        return new OfferingsData(Arrays.asList(artworks));
    }
    
   
    Stream<MutableArtwork> getArtworks();

    int getStepsRemaining();

    String getBidder();

    int getBid();

    void setStepsRemaining(int stepsRemaining);

    void setBidder(String bidder);

    void setBid(int bid);
}
