package edu.hm.bartolov.a08_mvc.datastore.writeable;

import edu.hm.bartolov.a08_mvc.datastore.readonly.Offerings;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 * @author Edo
 */
public abstract class MutableOfferings extends Offerings implements Changable{

    protected MutableOfferings(){
        
    }
    
    public static MutableOfferings make(MutableArtwork... artworks){
        return new OfferingsData(Arrays.asList(artworks));
    }

    public abstract void setStepsRemaining(int stepsRemaining);

    public abstract void setBidder(String bidder);

    public abstract void setBid(int bid);

    @Override
    public abstract Stream<MutableArtwork> getArtworks();
    
    @Override
    public synchronized void setChanged(){
        super.setChanged();
    }
}
