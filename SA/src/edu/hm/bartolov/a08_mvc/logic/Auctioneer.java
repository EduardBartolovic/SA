package edu.hm.bartolov.a08_mvc.logic;

import edu.hm.bartolov.a08_mvc.datastore.readonly.Offerings;
import edu.hm.bartolov.a08_mvc.datastore.writeable.MutableOfferings;

/**
 * abstract Auctioneer.
 * @author Eduard
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
    
    boolean placeBid(String bidder, int amount);
    
    Offerings getOfferings();
}
