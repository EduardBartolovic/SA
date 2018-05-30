package edu.hm.bartolov.a08_mvc.datastore.writeable.data;

import edu.hm.bartolov.a08_mvc.datastore.writeable.MutableArtwork;
import edu.hm.bartolov.a08_mvc.datastore.writeable.MutableOfferings;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class OfferingsData implements MutableOfferings{
    
    private final Set<ArtworkData> artworks;
    
    private int stepsRemaining;
    
    private String bidder;
    
    private int bid;

    public OfferingsData(Collection<MutableArtwork> artworks) {
        this.artworks = new HashSet(artworks);
    }
    

    @Override
    public Stream<MutableArtwork> getArtworks() {
        return Stream.of(MutableArtwork.class.cast(artworks));
    }

    @Override
    public int getStepsRemaining() {
        return stepsRemaining;
    }

    @Override
    public String getBidder() {
        return bidder;
    }

    @Override
    public int getBid() {
        return bid;
    }

    @Override
    public void setStepsRemaining(int stepsRemaining) {
        if(stepsRemaining<0)
            throw new IllegalArgumentException();
        this.stepsRemaining = stepsRemaining;
    }

    @Override
    public void setBidder(String bidder) {
        this.bidder = bidder;
    }

    @Override
    public void setBid(int bid) {
        if(stepsRemaining<0)
            throw new IllegalArgumentException();
        this.bid = bid;
    }
    
    
    
    
    
    
}
