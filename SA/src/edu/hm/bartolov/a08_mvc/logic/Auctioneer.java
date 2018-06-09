package edu.hm.bartolov.a08_mvc.logic;

import edu.hm.bartolov.a08_mvc.datastore.writeable.MutableOfferings;

/**
 *
 * @author Eduard
 */
public interface Auctioneer {
    
    
    public static Auctioneer make(MutableOfferings offerings){
        return new AuctionLogic(offerings);
    }
    
    boolean placebid(String bidder, int amount);
    
    
}
