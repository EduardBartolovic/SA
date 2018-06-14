package edu.hm.bartolov.a08_mvc.control;

import edu.hm.bartolov.a08_mvc.logic.Auctioneer;

/**
 *
 * @author Eduard
 */
public abstract class Controller extends Thread{
    
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
        
        throw new IllegalArgumentException();
    }
    
}
