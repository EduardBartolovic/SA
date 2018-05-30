package edu.hm.bartolov.a08_mvc.datastore.readonly;

import edu.hm.bartolov.a08_mvc.datastore.writeable.MutableArtwork;
import java.util.stream.Stream;


public interface Offerings {
    
    Stream<MutableArtwork> getArtworks();

    int getStepsRemaining();

    String getBidder();

    int getBid();
}
