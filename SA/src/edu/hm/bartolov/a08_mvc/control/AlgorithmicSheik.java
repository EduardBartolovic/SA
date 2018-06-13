package edu.hm.bartolov.a08_mvc.control;

import edu.hm.bartolov.a08_mvc.datastore.readonly.Artwork;
import edu.hm.bartolov.a08_mvc.logic.Auctioneer;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author Edo
 */
public class AlgorithmicSheik extends Controller{
    
    private final String name;
    
    private final String sheikName;
    
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
        sheikName = "Sheik-"+(max+gap);
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
                Thread.sleep(4000);
                if(!auctioneer.getOfferings().getBidder().equals(sheikName) && auctioneer.getOfferings().getBid()<max)
                    auctioneer.placebid(sheikName, auctioneer.getOfferings().getBid()+1);

            } 
        }catch(NoSuchElementException exce){
            
        } catch (InterruptedException ex) {
            Logger.getLogger(AlgorithmicSheik.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
    
}
