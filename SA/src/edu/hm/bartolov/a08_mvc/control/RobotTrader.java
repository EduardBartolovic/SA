
package edu.hm.bartolov.a08_mvc.control;

import edu.hm.bartolov.a08_mvc.logic.Auctioneer;

/**
 *
 * @author Eduard Bartolovic, Felix Peither
 */
public class RobotTrader extends Controller{
    
    /**
     * 
     */
    private final String[] millis;
    
    /**
     * 
     */
    private final Auctioneer auctioneer;

    /**
     * 
     * @param auctioneer
     * @param millis 
     */
    public RobotTrader(Auctioneer auctioneer, String... millis) {
        this.auctioneer = auctioneer;
        this.millis = new String[millis.length];
        System.arraycopy(millis, 0, this.millis, 0, millis.length);
    }
    
    @Override
    public void run() {
        
        
        
    }
}
