package edu.hm.bartolov.a08_mvc.logic;

import edu.hm.bartolov.a08_mvc.datastore.readonly.Offerings;
import edu.hm.bartolov.a08_mvc.datastore.writeable.MutableArtwork;
import edu.hm.bartolov.a08_mvc.datastore.writeable.MutableOfferings;

/**
 *
 * @author Eduard
 */
public class AuctionLogic implements Auctioneer{

    private static final int DEFAULTDELAY = 1000;
    
    private final MutableOfferings offerings;
    
    private boolean wasBid = false;

    public AuctionLogic(MutableOfferings offerings) {
        this.offerings = offerings;
    }
    
    
    @Override
    public synchronized boolean placebid(String bidder, int amount) {
        if(bidder==null || "".equals(bidder))
            throw new IllegalArgumentException();
        
        final boolean moreThanLastBid = amount > offerings.getBid();
        if(moreThanLastBid){
            offerings.setBid(amount);
            offerings.setBidder(bidder);
            wasBid = true;
        }
        
        return moreThanLastBid;
    }
    
    
    @Override
    public void run(){
        
      offerings.getArtworks()
              .filter( art -> !art.isAuctioned())  //only get Artworks which arent sold yet
              .forEach((MutableArtwork art)-> {
                  offerings.setStepsRemaining(5);
                  while(offerings.getStepsRemaining()>0){ //auction
                      offerings.notifyObservers();
                      if(getBidder()){  
                          offerings.setStepsRemaining(5); //reset counter
                      }else{
                          offerings.setStepsRemaining(offerings.getStepsRemaining()-1);
                      }
                  }
                  offerings.notifyObservers();
                  
                  if(offerings.getBidder()!=null){  // artwork sold
                      art.setAuctioned(true);
                      art.setBuyer(offerings.getBidder());
                      art.setSoldPrice(offerings.getBid());
                  }
                  
                  offerings.setBidder(null);
                  offerings.setBid(0);
                  System.out.println("next art");
              });
                
      offerings.notifyObservers();        
    }
    
    private boolean getBidder(){
        try {
            Thread.sleep(DEFAULTDELAY);
        } catch (InterruptedException ex) {
            System.out.println("ERROR");
        }
        final boolean bidded = wasBid;
        wasBid = false;
        return bidded;
    }

    @Override
    public Offerings getOfferings() {
       return offerings;
    }
    
    
    
}
