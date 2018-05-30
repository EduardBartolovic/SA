
package edu.hm.bartolov.a08_mvc.datastore.writeable.data;

import edu.hm.bartolov.a08_mvc.datastore.writeable.MutableArtwork;

public class ArtworkData implements MutableArtwork{
    
    
    private final String title;
    
    private final int initialPrice;
    
    private boolean auctioned;
    
    private String buyer;
    
    private int soldPrice;

    public ArtworkData(String title, int initialPrice) {
        if(initialPrice < 0 || title == null || "".equals(title)) 
            throw new IllegalArgumentException(); 
        
        this.title = title;
        this.initialPrice = initialPrice;
        auctioned = false;
        buyer = null;
        soldPrice = 0;
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
    }

    @Override
    public void setBuyer(String buyer) {
        if( buyer == null || "".equals(buyer)) 
            throw new IllegalArgumentException(); 
        this.buyer = buyer;
    }

    @Override
    public void setSoldPrice(int soldPrice) {
        if( soldPrice < 0) 
            throw new IllegalArgumentException();
        this.soldPrice = soldPrice;
    }
    
    
    
    
}
