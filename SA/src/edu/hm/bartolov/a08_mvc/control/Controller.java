package edu.hm.bartolov.a08_mvc.control;

import edu.hm.bartolov.a08_mvc.logic.Auctioneer;

/**
 * Abstract Controller 
 * @author Eduard
 */
public abstract class Controller extends Thread{
    
    /**
     * Factory Methode
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
        else if("robot-".equals(className.substring(0,6)))
            return new RobotTrader(auctioneer, args);
        else if("sheik-".equals(className.substring(0,6)))
            return new AlgorithmicSheik(auctioneer, args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        else if("Network-".equals(className.substring(0, 8)))
            return new NetworkController(auctioneer, args[0]);
        throw new IllegalArgumentException();
    }
    
}
