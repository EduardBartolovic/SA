package edu.hm.bartolov.a08_mvc.logic;

import edu.hm.bartolov.a08_mvc.datastore.readonly.Offerings;
import edu.hm.bartolov.a08_mvc.datastore.writeable.MutableArtwork;
import edu.hm.bartolov.a08_mvc.datastore.writeable.MutableOfferings;
import java.util.Optional;

/**
 * Auction Logic.
 * @author Eduard
 */
public class AuctionLogic implements Auctioneer{

    /**
     * defaultDelay.
     */
    private static final String DEFAULTDELAY = "1000";
    
    /**
     * Datastore.
     */
    private final MutableOfferings offerings;
    
    /**
     * was there a bid.
     */
    private boolean wasBid;
    
    /**
     * delay between notify.
     */
    private final int delay;

    /**
     * Constructor.
     * @param offerings Datastore.
     */
    protected AuctionLogic(MutableOfferings offerings) {
        
        //getting the systempropeties
        delay = Integer.parseInt(
                Optional.ofNullable(System.getProperty("auction.delay")).orElse(DEFAULTDELAY));
        
        this.offerings = offerings;
    }
    
    
    @Override
    public synchronized boolean placeBid(String bidder, int amount) {
        if(bidder==null || "".equals(bidder))
            throw new IllegalArgumentException();
        
        final boolean moreThanLastBid = amount > offerings.getBid();
        if(moreThanLastBid){
            offerings.setBid(amount);
            offerings.setBidder(bidder);
            wasBid = true;
//            try {
//                Thread.sleep(30);
//            } catch (InterruptedException ex) {
//                System.out.println("ERROR in Logic");
//            }
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
                      art.setBuyer(offerings.getBidder());
                      art.setSoldPrice(offerings.getBid());
                  }
                  art.setAuctioned(true);
                  
                  offerings.setBidder(null);
                  offerings.setBid(0);
              });
                
      offerings.notifyObservers();
      
      offerings.getArtworks()
              .peek(System.out::println)
              .count();
      
      System.out.println("Auction is over. see you next time :)");
    }
    
    private boolean getBidder(){
        
        final long startTime = System.currentTimeMillis();        
        while(System.currentTimeMillis()-startTime<delay){
            if(wasBid){
               break;
            }         
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
