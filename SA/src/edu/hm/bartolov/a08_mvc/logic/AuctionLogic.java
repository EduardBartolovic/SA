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
     * starting steps of auction.
     */
    private static final int RESETSTEPS = 5;
    
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
    AuctionLogic(MutableOfferings offerings) {
        
        //getting the systempropeties
        delay = Integer.parseInt(
                Optional.ofNullable(System.getProperty("auction.delay")).orElse(DEFAULTDELAY));
        
        this.offerings = offerings;
    }
    
    
    @Override
    public synchronized boolean placeBid(String bidder, int amount) {
        if(bidder==null || "".equals(bidder))
            throw new IllegalArgumentException();
        
        if(offerings.getBid()==0|| amount <= offerings.getBid())
            return false;
                    
        offerings.setBid(amount);
        offerings.setBidder(bidder);
        wasBid = true;
//            try {
//                Thread.sleep(30);
//            } catch (InterruptedException ex) {
//                System.out.println("ERROR in Logic");
//            }
        
        return true;
    }
    
    
    @Override
    public void run(){
        
      offerings.getArtworks()
              .sequential()
              .forEach((MutableArtwork art)-> {
//                  System.out.println("Next Artwork: "+art);
                  offerings.setBid(art.getInitialPrice());
                  offerings.setStepsRemaining(RESETSTEPS);
                  
                  while(offerings.getStepsRemaining()>0){ //auction
                      offerings.notifyObservers();
                      if(getBidder()){
                          offerings.setStepsRemaining(RESETSTEPS); //reset counter
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
      
//      offerings.getArtworks().foreach(System.out::println);
      
//      System.out.println("Auction is over. see you next time :)");
    }
    
    /**
     * get the new bid.
     * @return true if there was a new bid
     */
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
