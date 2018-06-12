package edu.hm.bartolov.a08_mvc.control;

import edu.hm.bartolov.a08_mvc.datastore.readonly.Artwork;
import edu.hm.bartolov.a08_mvc.logic.Auctioneer;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Stream;

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
        
        final Function<Stream<? extends Artwork>,Boolean> search = 
                (Stream<? extends Artwork> t) -> 
                        t.filter( art -> !art.isAuctioned())  //only get Artworks which arent sold yet
                        .findFirst()                      //get the first you find
                        .get()
                        .getTitle()
                        .startsWith(name);
        
        try{
            while(search.apply(auctioneer.getOfferings().getArtworks())){
                
                
            
            
            } 
        }catch(NoSuchElementException exce){
            
        }
        
        
        
    }
    
    
    
}
