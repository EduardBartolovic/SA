package edu.hm.bartolov.a08_mvc.datastore.writeable;

import edu.hm.bartolov.a08_mvc.datastore.readonly.Artwork;

/**
 * ABC for ArtworkData.
 * 
 * @author Eduard Bartolovic, Felix Peither
 */
public abstract class MutableArtwork implements Artwork{
    
    /**
     * Factory method for Artworks.
     * @param title title of the new artwork
     * @param initialPrice initial prive of the artwork
     * @return new ArtworkData
     */
    public static MutableArtwork make(String title,int initialPrice){
       return new ArtworkData(title, initialPrice);
    }

    /**
     * set the artwork as sold or not.
     * @param auctioned true if sold, false otherwise
     */
    public abstract void setAuctioned(boolean auctioned);
   
    /**
     * set the buyer of this artwork.
     * @param buyer the buyer of this artwork
     */
    public abstract void setBuyer(String buyer);
   
    /**
     * set the selling price of this artwork.
     * @param soldPrice the price this artwork has been sold for1
     */
    public abstract void setSoldPrice(int soldPrice);
}
