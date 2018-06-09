package edu.hm.bartolov.a08_mvc.logic;

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
        }
        
        
        
        return moreThanLastBid;
    }
    
    
    
}
