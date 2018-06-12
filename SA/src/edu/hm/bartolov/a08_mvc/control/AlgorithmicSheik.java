package edu.hm.bartolov.a08_mvc.control;

import edu.hm.bartolov.a08_mvc.logic.Auctioneer;

/**
 *
 * @author Edo
 */
public class AlgorithmicSheik extends Controller{
    
    
    private final String name;
    
    
    private final int max;
    
    private final int gap;
    
    /**
     * 
     */
    private final Auctioneer auctioneer;

    public AlgorithmicSheik( Auctioneer auctioneer, String name, int max, int gap) {
        this.name = name;
        this.max = max;
        this.gap = gap;
        this.auctioneer = auctioneer;
    }
    
    

    @Override
    public void run() {
        
        
        
        
        
        
        
    }
    
    
    
}
