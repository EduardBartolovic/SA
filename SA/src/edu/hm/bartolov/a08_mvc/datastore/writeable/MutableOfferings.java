package edu.hm.bartolov.a08_mvc.datastore.writeable;

import edu.hm.bartolov.a08_mvc.datastore.readonly.Offerings;
import java.util.stream.Stream;

/**
 *
 * @author Eduard Bartolovic, Felix Peither
 */
public abstract class MutableOfferings extends Offerings {
    
    /**
     * Factory method for offerings.
     * @param artworks a bunch of artworks
     * @return new offeringsData
     */
    public static MutableOfferings make(MutableArtwork... artworks){
        return new OfferingsData(artworks);
    }

    /**
     * change the steps remaining for an auction.
     * @param stepsRemaining the new steps remaining
     */
    public abstract void setStepsRemaining(int stepsRemaining);

    /**
     * set the current bidder of the auctioned artwork.
     * @param bidder 
     */
    public abstract void setBidder(String bidder);

    /**
     * set the current bid on the auctioned artwork.
     * @param bid 
     */
    public abstract void setBid(int bid);

    @Override
    public abstract Stream<MutableArtwork> getArtworks();

    
    public void modified(){
        super.setChanged();
    }
    
}
