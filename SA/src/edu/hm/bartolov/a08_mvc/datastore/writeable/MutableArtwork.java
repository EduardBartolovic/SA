package edu.hm.bartolov.a08_mvc.datastore.writeable;

import edu.hm.bartolov.a08_mvc.datastore.writeable.data.ArtworkData;

public interface MutableArtwork {
    
   public static MutableArtwork make(String title,int initialPrice){
        return new ArtworkData(title, initialPrice);
    } 
   
   
   String getTitle();
   
   int getInitialPrice();
   
   boolean isAuctioned();
   
   String getBuyer();
   
   int getSoldPrice();
   
   void setAuctioned(boolean auctioned);
   
   void setBuyer(String buyer);
   
   void setSoldPrice(int soldPrice);
}
