
package edu.hm.bartolov.a08_mvc.control;

import edu.hm.bartolov.a08_mvc.logic.Auctioneer;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Eduard Bartolovic, Felix Peither
 */
public class RobotTrader extends Controller{
    
    /**
     * 
     */
    private static final String ROBOT_TRADER = "RobotTrader";
    
    /**
     * 
     */
    private final Map<Long, Integer> millisAndAmount;
    
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
        this.millisAndAmount = new TreeMap<>();
        fillMap(millis);
    }
    
    private void fillMap(String...millis) {
        for (String priceAndTime: millis) {
            String[] priceAndTimeCut = priceAndTime.split(":");
            long milliseconds = Long.parseLong(priceAndTimeCut[0]);
            int bid = Integer.parseInt(priceAndTimeCut[1]);
            millisAndAmount.put(milliseconds, bid);
        }
    }
    
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        for (Map.Entry<Long, Integer> entry: millisAndAmount.entrySet()) {
            boolean waitedEnough = false;
            while (!waitedEnough) {
                long timeWaited = System.currentTimeMillis() - startTime;
                if (timeWaited >= entry.getKey()) {
                    waitedEnough = true;
                    auctioneer.placeBid(ROBOT_TRADER, entry.getValue());
                }
            }
        }
    }
}
