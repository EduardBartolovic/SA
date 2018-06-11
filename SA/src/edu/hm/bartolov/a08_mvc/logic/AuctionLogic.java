package edu.hm.bartolov.a08_mvc.logic;

import edu.hm.bartolov.a08_mvc.datastore.writeable.MutableArtwork;
import edu.hm.bartolov.a08_mvc.datastore.writeable.MutableOfferings;

/**
 *
 * @author Eduard
 */
public class AuctionLogic implements Auctioneer{

    private final MutableOfferings offerings;

    public AuctionLogic(MutableOfferings offerings) {
        this.offerings = offerings;
    }
    
    
    @Override
    public boolean placebid(String bidder, int amount) {
        if(bidder==null || "".equals(bidder))
            throw new IllegalArgumentException();
        
        final boolean moreThanLastBid = amount > offerings.getBid();
        if(moreThanLastBid){
            offerings.setBid(amount);
            offerings.setBidder(bidder);
            offerings.setStepsRemaining(5);
        }
        
        
        
        return moreThanLastBid;
    }
    
    
    public void run(){
        
      offerings.getArtworks()      
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
              });
                
      offerings.notifyObservers();        
    }
    
    private boolean getBidder(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println("ERROR");
        }
        return true;
    }
    
    
    
}
