package edu.hm.bartolov.a08_mvc.datastore.writeable;

import edu.hm.bartolov.a08_mvc.datastore.writeable.MutableArtwork;
import edu.hm.bartolov.a08_mvc.datastore.writeable.MutableOfferings;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class OfferingsData extends MutableOfferings{
    
    private final Set<MutableArtwork> artworks;
    
    private int stepsRemaining;
    
    private String bidder;
    
    private int bid;

    OfferingsData(Set<MutableArtwork> artworks) {
        super();
        this.artworks = new HashSet(artworks);
    }
    
    OfferingsData(List<MutableArtwork> artworks) {
        super();
        this.artworks = new HashSet(artworks);
    }
    

    @Override
    public Stream<MutableArtwork> getArtworks() {
        return artworks.stream();
    }

    @Override
    public synchronized  int getStepsRemaining() {
        return stepsRemaining;
    }

    @Override
    public synchronized String getBidder() {
        return bidder;
    }

    @Override
    public synchronized int getBid() {
        return bid;
    }

    @Override
    public synchronized void setStepsRemaining(int stepsRemaining) {
        if(stepsRemaining<0)
            throw new IllegalArgumentException();
      
        this.stepsRemaining = stepsRemaining;
        super.setChanged();
        
    }

    @Override
    public synchronized void setBidder(String bidder) {
      
        this.bidder = bidder;
        super.setChanged();
        
    }

    @Override
    public synchronized void setBid(int bid) {
        if(stepsRemaining<0)
            throw new IllegalArgumentException();
      
        this.bid = bid;
        super.setChanged();
        
        
    }
    
    
    
    
    
    
}
