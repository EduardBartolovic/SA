package edu.hm.bartolov.a08_mvc.datastore.readonly;

import java.util.Observable;
import java.util.stream.Stream;

/**
 * 
 * @author Computer
 */
public abstract class Offerings extends Observable{
    
    /**
     * 
     * @return 
     */
    public abstract Stream<? extends Artwork> getArtworks();

    /**
     * 
     * @return 
     */
    public abstract int getStepsRemaining();

    /**
     * 
     * @return 
     */
    public abstract String getBidder();

    /**
     * 
     * @return 
     */
    public abstract int getBid();
}
