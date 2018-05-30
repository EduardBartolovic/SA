package edu.hm.bartolov.a08_mvc.datastore.readonly;

public interface Artwork {
    
   String getTitle();
   
   int getInitialPrice();
   
   boolean isAuctioned();
   
   String getBuyer();
   
   int getSoldPrice();
    
}
