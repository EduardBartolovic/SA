package edu.hm.bartolov.a08_mvc.datastore.writeable;

import edu.hm.bartolov.a08_mvc.datastore.readonly.Offerings;
import java.util.Arrays;

/**
 *
 * @author Edo
 */
public abstract class MutableOfferings extends Offerings{

    public MutableOfferings(){
        
    }
    
    public static MutableOfferings make(MutableArtwork... artworks){
        return new OfferingsData(Arrays.asList(artworks));
    }

    public abstract void setStepsRemaining(int stepsRemaining);

    public abstract void setBidder(String bidder);

    public abstract void setBid(int bid);
}
