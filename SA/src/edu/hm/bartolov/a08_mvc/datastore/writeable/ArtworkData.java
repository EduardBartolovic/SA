
package edu.hm.bartolov.a08_mvc.datastore.writeable;


public class ArtworkData extends MutableArtwork implements Changable{
    
    private final String title;
    
    private final int initialPrice;
    
    private boolean auctioned;
    
    private String buyer;
    
    private int soldPrice;
    
    private Changable changable;

    ArtworkData(String title, int initialPrice) {
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
        this.auctioned = auctioned;
        setChanged();
    }

    @Override
    public synchronized void setBuyer(String buyer) {
        if( buyer == null || "".equals(buyer)) 
            throw new IllegalArgumentException(); 
        this.buyer = buyer;
        setChanged();
    }

    @Override
    public synchronized void setSoldPrice(int soldPrice) {
        if( soldPrice < 0) 
            throw new IllegalArgumentException();
        this.soldPrice = soldPrice;
        setChanged();
    }

    @Override
    public void setChanged() {
        changable.setChanged();
    }
    
    void setChangable(Changable changable){
        this.changable = changable;
    }
    
    
}
