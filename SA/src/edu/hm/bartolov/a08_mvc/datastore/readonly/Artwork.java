package edu.hm.bartolov.a08_mvc.datastore.readonly;

public abstract class Artwork {
    
   abstract String getTitle();
   
   abstract int getInitialPrice();
   
   abstract boolean isAuctioned();
   
   abstract String getBuyer();
   
   abstract int getSoldPrice();
    
}
