
package edu.hm.bartolov.a08_mvc.datastore.writeable;

import java.util.Objects;


public class ArtworkData extends MutableArtwork implements Changable{
    
    private final String title;
    
    private final int initialPrice;
    
    private boolean auctioned;
    
    private String buyer;
    
    private int soldPrice;
    
    private Changable changable;

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
        if(changable!=null)
            setChanged();
    }

    @Override
    public void setBuyer(String buyer) {
        if( buyer == null || "".equals(buyer)) 
            throw new IllegalArgumentException(); 
        this.buyer = buyer;
        if(changable!=null)
            setChanged();
    }

    @Override
    public void setSoldPrice(int soldPrice) {
        if( soldPrice < 0) 
            throw new IllegalArgumentException();
        this.soldPrice = soldPrice;
        if(changable!=null)
            setChanged();
    }

    @Override
    public void setChanged() {
        changable.setChanged();
    }
    
    void setChangable(Changable changable){
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
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ArtworkData other = (ArtworkData) obj;
        if (this.initialPrice != other.initialPrice) {
            return false;
        }
        if (this.auctioned != other.auctioned) {
            return false;
        }
        if (this.soldPrice != other.soldPrice) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return Objects.equals(this.buyer, other.buyer);
    }
    
    
    
    
}
