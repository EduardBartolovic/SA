
package edu.hm.bartolov.a08_mvc.datastore.writeable;

import java.util.Objects;

/**
 * Artwork.
 * @author Felix, Eduard
 */
public class ArtworkData extends MutableArtwork {
    
    /**
     * Title of the artwork.
     */
    private final String title;
    
    /**
     * The Initial price of the artwork.
     */
    private final int initialPrice;
    
    /**
     * Boolean, is true if the artwork has been sold, false otherwise.
     */
    private boolean auctioned;
    
    /**
     * The specific buyer of this artwork.
     */
    private String buyer;
    
    /**
     * The price for which the artwork has been sold.
     */
    private int soldPrice;
    
    /**
     * Object to communicate changes.
     */
    private MutableOfferings changable;

    /**
     * Contructor.
     * @param title title of the new artwork
     * @param initialPrice initial prive of the artwork
     */
    protected ArtworkData(String title, int initialPrice) {
        if(initialPrice < 0 || title == null || "".equals(title)) 
            throw new IllegalArgumentException(); 
        
        this.title = title;
        this.initialPrice = initialPrice;
        auctioned = false;
        buyer = null;
        soldPrice = 0;
        changable = null;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getInitialPrice() {
        return initialPrice;
    }

    @Override
    public boolean isAuctioned() {
        return auctioned;
    }

    @Override
    public String getBuyer() {
        return buyer;
    }

    @Override
    public int getSoldPrice() {
        return soldPrice;
    }

    @Override
    public void setAuctioned(boolean auctioned) {
        this.auctioned = auctioned;
        setChanged();
    }

    @Override
    public void setBuyer(String buyer) {
        if( buyer == null || "".equals(buyer)) 
            throw new IllegalArgumentException(); 
        this.buyer = buyer;
        setChanged();
    }

    @Override
    public void setSoldPrice(int soldPrice) {
        if( soldPrice < 0) 
            throw new IllegalArgumentException();
        this.soldPrice = soldPrice;
        setChanged();
    }

    @Override
    public void setChanged() {
        if(changable != null)
            changable.setChanged();
    }
    
    @Override
    public void setChangable(MutableOfferings changable){
        this.changable = changable;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.title);
        hash = 97 * hash + this.initialPrice;
        hash = 97 * hash + (this.auctioned ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.buyer);
        hash = 97 * hash + this.soldPrice;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        
        if (obj == null)
            return false;
        
        if (getClass() != obj.getClass())
            return false;
        
        final ArtworkData other = (ArtworkData) obj;
        if (this.initialPrice != other.initialPrice)
            return false;
        
        if (this.auctioned != other.auctioned)
            return false;
       
        if (this.soldPrice != other.soldPrice) 
            return false;
        
        if (!Objects.equals(this.title, other.title))
            return false;
        
        return Objects.equals(this.buyer, other.buyer);
    }
    
    
    
    
}
