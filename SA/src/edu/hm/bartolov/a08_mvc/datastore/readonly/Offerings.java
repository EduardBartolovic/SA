package edu.hm.bartolov.a08_mvc.datastore.readonly;

import java.util.Observable;
import java.util.stream.Stream;

/**
 * 
 * @author Computer
 */
public abstract class Offerings extends Observable{
    
    /**
     * getter.
     * @return artworks
     */
    public abstract Stream<? extends Artwork> getArtworks();

    /**
     * getter.
     * @return artworks remainingSteps
     */
    public abstract int getStepsRemaining();

    /**
     * getter.
     * @return bidder
     */
    public abstract String getBidder();

    /**
     * getter.
     * @return bid
     */
    public abstract int getBid();

    
    
}
