package edu.hm.bartolov.a08_mvc.logic;

import edu.hm.bartolov.a08_mvc.datastore.readonly.Offerings;
import edu.hm.bartolov.a08_mvc.datastore.writeable.MutableOfferings;

/**
 *
 * @author Eduard
 */
public interface Auctioneer extends Runnable{

    public static Auctioneer make(MutableOfferings offerings){
        return new AuctionLogic(offerings);
    }
    
    boolean placebid(String bidder, int amount);
    
    Offerings getOfferings();
}
