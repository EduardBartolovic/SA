package edu.hm.bartolov.a08_mvc.datastore.writeable;

import java.util.stream.Stream;

/**
 *
 * @author Edo
 */
public interface MutableOfferings {
    
    public static MutableOfferings make(MutableArtwork... artworks){
        return null;
    }
    
   
    Stream<ArtworkData> getArtworks();

    int getStepsRemaining();

    String getBidder();

    int getBid();

    void setStepsRemaining(int stepsRemaining);

    void setBidder(String bidder);

    void setBid(int bid);
}
