package edu.hm.bartolov.a08_mvc.datastore.writeable;

public interface MutableArtwork {
    
   public static MutableArtwork make(String title,int initialPrice){
        return null;
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
