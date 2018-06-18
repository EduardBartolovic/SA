package edu.hm.bartolov.a08_mvc.control;

import edu.hm.bartolov.a08_mvc.logic.Auctioneer;

/**
 * Abstract Controller.
 * @author Eduard
 */
public abstract class Controller extends Thread{
    
    /**
     * used for substring.
     */
    private static final int ROBOTSHEIKLENGTH = 6; 
    
    /**
     * used for substring.
     */
    private static final int NETWORKLENGTH = 8; 
    
    /**
     * Factory Methode.
     * @param which String
     * @param auctioneer Auctionner
     * @param args more Strings
     * @return Controller
     */
    public static Controller make(String which, Auctioneer auctioneer , String... args){
        if(which==null)
            throw new IllegalArgumentException();
        
        
        final String className = which.toLowerCase();
        
        if("console".equals(className))
            return new ConsoleController(auctioneer);
        
        if("robot-".equals(className.substring(0,ROBOTSHEIKLENGTH)))
            return new RobotTrader(auctioneer, args);
        if("sheik-".equals(className.substring(0,ROBOTSHEIKLENGTH)))
            return new AlgorithmicSheik(auctioneer, args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        if("Network-".equals(className.substring(0, NETWORKLENGTH)))
            return new NetworkController(auctioneer, args[0]);
        
        throw new IllegalArgumentException();
    }
    
}
