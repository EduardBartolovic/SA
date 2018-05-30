
package edu.hm.bartolov.a08_mvc.datastore.readonly;

import edu.hm.bartolov.a08_mvc.datastore.writeable.MutableArtwork;
import java.util.stream.Stream;


public abstract class Offerings {
    
    abstract Stream<MutableArtwork> getArtworks();

    abstract int getStepsRemaining();

    abstract String getBidder();

    abstract int getBid();
}
