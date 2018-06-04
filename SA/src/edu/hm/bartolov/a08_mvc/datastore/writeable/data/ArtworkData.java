
package edu.hm.bartolov.a08_mvc.datastore.writeable.data;

import edu.hm.bartolov.a08_mvc.datastore.writeable.MutableArtwork;

public class ArtworkData extends MutableArtwork{
    
    
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
    public synchronized String getTitle() {
        return title;
    }

    @Override
    public synchronized int getInitialPrice() {
        return initialPrice;
    }

    @Override
    public synchronized boolean isAuctioned() {
        return auctioned;
    }

    @Override
    public synchronized String getBuyer() {
        return buyer;
    }

    @Override
    public synchronized int getSoldPrice() {
        return soldPrice;
    }

    @Override
    public synchronized void setAuctioned(boolean auctioned) {
        synchronized(getDataStore()){
            this.auctioned = auctioned;
            super.setChanged();
        }
    }

    @Override
    public synchronized void setBuyer(String buyer) {
        if( buyer == null || "".equals(buyer)) 
            throw new IllegalArgumentException(); 
        synchronized(getDataStore()){
            this.buyer = buyer;
            super.setChanged();
        }
    }

    @Override
    public synchronized void setSoldPrice(int soldPrice) {
        if( soldPrice < 0) 
            throw new IllegalArgumentException();
        synchronized(getDataStore()){
            this.soldPrice = soldPrice;
            super.setChanged();
        }
    }
    
    
    
    
}
