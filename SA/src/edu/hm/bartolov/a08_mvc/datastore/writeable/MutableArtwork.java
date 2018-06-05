package edu.hm.bartolov.a08_mvc.datastore.writeable;

import edu.hm.bartolov.a08_mvc.datastore.readonly.Artwork;
import edu.hm.bartolov.a08_mvc.datastore.writeable.data.ArtworkData;

public abstract class MutableArtwork implements Artwork {
    
    public static MutableArtwork make(String title,int initialPrice){
       return new ArtworkData(title, initialPrice);
    }

    public abstract void setAuctioned(boolean auctioned);
   
    public abstract void setBuyer(String buyer);
   
    public abstract void setSoldPrice(int soldPrice);
}
