package edu.hm.bartolov.a08_mvc.control;

import edu.hm.bartolov.a08_mvc.logic.Auctioneer;

/**
 * Abstract Controller.
 * @author Eduard
 */
public abstract class Controller extends Thread{
    
    /**
     * The Auctioneer.
     */
    private final Auctioneer auctioneer;
    
    /**
     * Constructor.
     * to set Deamon true
     * @param auctioneer Auctioneer
     */
    Controller(Auctioneer auctioneer){
        this.auctioneer = auctioneer;
        this.setDaemon(true);
    }
    
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
        
        if(className.startsWith("console"))
            return new ConsoleController(auctioneer);
        if(className.startsWith("robot"))
            return new RobotTrader(auctioneer, args);
        if(className.startsWith("sheik"))
            return new AlgorithmicSheik(auctioneer, args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        if(className.startsWith("network"))
            return new NetworkController(auctioneer, args[0]);
        
        throw new IllegalArgumentException();
    }

    Auctioneer getAuctioneer() {
        return auctioneer;
    }
    
    
    
}
