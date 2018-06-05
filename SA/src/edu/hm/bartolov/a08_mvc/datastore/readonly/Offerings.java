package edu.hm.bartolov.a08_mvc.datastore.readonly;

import java.util.stream.Stream;


public interface Offerings {
    
    Stream<? extends Artwork> getArtworks();

    int getStepsRemaining();

    String getBidder();

    int getBid();
}
