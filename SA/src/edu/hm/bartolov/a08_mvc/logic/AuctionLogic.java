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
              .sequential()
              .forEach((MutableArtwork art)-> {
                  System.out.println("Next Artwork: "+art);
                  offerings.setBid(art.getInitialPrice());
                  offerings.setStepsRemaining(5);
                  boolean wasbid = false; //
                  while(offerings.getStepsRemaining()>0){ //auction
                      wasbid = getBidder();
                      offerings.notifyObservers();
                      if(wasbid){
                          offerings.setStepsRemaining(5); //reset counter
                      }else{
                          offerings.setStepsRemaining(offerings.getStepsRemaining()-1);
                      }
                  }
                  offerings.notifyObservers();
                  
                  if(wasbid){  // artwork sold
                      art.setBuyer(offerings.getBidder());
                      art.setSoldPrice(offerings.getBid());
                      System.out.println("Sold to: "+offerings.getBidder());
                  }
                  art.setAuctioned(true);
                  
                  offerings.setBidder(null);
                  offerings.setBid(0);
              });
                
      offerings.notifyObservers();
      
      System.out.println("Auction is over. see you next time :)");
    }
    
    private boolean getBidder(){
        
        final long startTime = System.currentTimeMillis();
        while(System.currentTimeMillis()-startTime<DEFAULTDELAY){
            if(wasBid)
                break;
        }
        final boolean bidded = isWasBid();
        wasBid = false;
        return bidded;
    }
    
    
    

    @Override
    public Offerings getOfferings() {
       return offerings;
    }

    private synchronized boolean isWasBid() {
        return wasBid;
    }
    
    
    
}
