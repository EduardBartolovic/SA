package edu.hm.bartolov.a08_mvc.datastore.writeable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class OfferingsData extends MutableOfferings{
    
    private final Set<MutableArtwork> artworks;
    
    private int stepsRemaining;
    
    private String bidder;
    
    private int bid;

    protected OfferingsData(MutableArtwork... artworks) {
        this.artworks = new HashSet<>(Arrays.asList(artworks));
    }
    
    protected OfferingsData(Set<MutableArtwork> artworks) {
        this.artworks = new HashSet<>(artworks);
    }
    
    protected OfferingsData(List<MutableArtwork> artworks) {
        this.artworks = new HashSet<>(artworks);
    }
    
    @Override
    public Stream<MutableArtwork> getArtworks() {
        return artworks.stream();
    }

    @Override
    public  int getStepsRemaining() {
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
        super.setChanged();
        
    }

    @Override
    public void setBidder(String bidder) {

        this.bidder = bidder;
        super.setChanged();
        
    }

    @Override
    public void setBid(int bid) {
        if(bid<0)
            throw new IllegalArgumentException();
      
        this.bid = bid;
        super.setChanged();  
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.artworks);
        hash = 53 * hash + this.stepsRemaining;
        hash = 53 * hash + Objects.hashCode(this.bidder);
        hash = 53 * hash + this.bid;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OfferingsData other = (OfferingsData) obj;
        if (this.stepsRemaining != other.stepsRemaining) {
            return false;
        }
        if (this.bid != other.bid) {
            return false;
        }
        if (!Objects.equals(this.bidder, other.bidder)) {
            return false;
        }
        return Objects.equals(this.artworks, other.artworks);
    }
    
    
    
    
    
    
}
