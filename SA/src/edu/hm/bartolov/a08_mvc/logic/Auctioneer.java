package edu.hm.bartolov.a08_mvc.logic;

import edu.hm.bartolov.a08_mvc.datastore.readonly.Offerings;
import edu.hm.bartolov.a08_mvc.datastore.writeable.MutableOfferings;

/**
 * abstract Auctioneer.
 * @author Eduard Bartolovic, Felix Peither
 */
public interface Auctioneer extends Runnable{

    /**
     * Factory.
     * @param offerings MuatbleOfferings
     * @return Auctioneer
     */
    static Auctioneer make(MutableOfferings offerings){
        return new AuctionLogic(offerings);
    }
    
    /**
     * To place a bid.
     * 
     * @param bidder the bidder
     * @param amount the amount of the bid
     * @return true if the bid is accepted, false otherwise
     */
    boolean placeBid(String bidder, int amount);
    
    /**
     * Get all offerings.
     * @return offerings
     */
    Offerings getOfferings();
}
