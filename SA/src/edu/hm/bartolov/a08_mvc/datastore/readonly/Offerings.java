package edu.hm.bartolov.a08_mvc.datastore.readonly;

import java.util.Observable;
import java.util.stream.Stream;


public abstract class Offerings extends Observable{
    
    public abstract Stream<? extends Artwork> getArtworks();

    public abstract int getStepsRemaining();

    public abstract String getBidder();

    public abstract int getBid();
}
