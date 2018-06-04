package edu.hm.bartolov.a08_mvc.datastore.writeable;

import edu.hm.bartolov.a08_mvc.datastore.readonly.Offerings;
import edu.hm.bartolov.a08_mvc.datastore.writeable.data.OfferingsData;
import java.util.Arrays;
import java.util.Collection;
import java.util.Observable;

/**
 *
 * @author Edo
 */
public abstract class MutableOfferings extends Observable implements Offerings{
    
    
    
    public MutableOfferings(Collection<MutableArtwork> artworks){
        
    }
    
    public static MutableOfferings make(MutableArtwork... artworks){
        return new OfferingsData(Arrays.asList(artworks));
    }
    
    public MutableOfferings getDataStore(){
        return null;
    }

    public abstract void setStepsRemaining(int stepsRemaining);

    public abstract void setBidder(String bidder);

    public abstract void setBid(int bid);
}
