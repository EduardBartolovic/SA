
package edu.hm.bartolov.a08_mvc.control;

import edu.hm.bartolov.a08_mvc.logic.Auctioneer;
import java.util.Map;
import java.util.TreeMap;

/**
 * The Robot Trader.
 * 
 * @author Eduard Bartolovic, Felix Peither
 */
public class RobotTrader extends Controller{
    
    /**
     * bidder name.
     */
    private final String name ;
    
    /**
     * waiting times and bit amounts.
     */
    private final Map<Long, Integer> millisAndAmount;
    

    /**
     * Constructor.
     * @param auctioneer Auctionner
     * @param millis times
     */
    RobotTrader(Auctioneer auctioneer, String... millis) {
        super(auctioneer);
        this.millisAndAmount = new TreeMap<>();
        fillMap(millis);
        final long sum = millisAndAmount.keySet().stream().reduce(Long::sum).orElse(Long.valueOf(0));
        name = "Robot-"+sum;
    }
    
    /**
     * filling map.
     * @param millis String...
     */
    private void fillMap(String...millis) {
        for (String priceAndTime: millis) {
            final String[] priceAndTimeCut = priceAndTime.split("=");
            final long milliseconds = Long.parseLong(priceAndTimeCut[0]);
            final int bid = Integer.parseInt(priceAndTimeCut[1]);
            millisAndAmount.put(milliseconds, bid);
        }
    }
    
    @Override
    public void run() {
        final long startTime = System.currentTimeMillis();
        millisAndAmount.entrySet().forEach( entry -> {
            boolean waitedEnough = false;
            while (!waitedEnough) {
                final long timeWaited = System.currentTimeMillis() - startTime;
                if (timeWaited >= entry.getKey()) {
                    waitedEnough = true;
                    getAuctioneer().placeBid(name, entry.getValue());
                }
            }
        });
    }
}
