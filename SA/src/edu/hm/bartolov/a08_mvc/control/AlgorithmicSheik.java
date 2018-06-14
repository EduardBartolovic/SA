package edu.hm.bartolov.a08_mvc.control;

import edu.hm.bartolov.a08_mvc.datastore.readonly.Artwork;
import edu.hm.bartolov.a08_mvc.datastore.readonly.Offerings;
import edu.hm.bartolov.a08_mvc.logic.Auctioneer;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author Eduard
 */
public class AlgorithmicSheik extends Controller{
    
    private static final int DEFAULTDELAY = 1000;
    
    private final String name;
    
    private final String sheikName;
    
    private final int max;
    
    private final int gap;
    
    /**
     * 
     */
    private final Auctioneer auctioneer;

    /**
     * 
     * @param auctioneer selfexplaining.
     * @param name of picture.
     * @param max amount bid.
     * @param gap waiting time.
     */
    public AlgorithmicSheik( Auctioneer auctioneer, String name, int max, int gap) {
        this.name = name;
        this.max = max;
        this.gap = (DEFAULTDELAY*5)-gap;
        this.auctioneer = auctioneer;
        sheikName = "Sheik-"+(max+gap);
    }
    
    

    @Override
    public void run() {
        
        final Function<Stream<? extends Artwork>,Boolean> search = 
                (Stream<? extends Artwork> t) -> t.filter( art -> art.isAuctioned())  //only get Artworks which arent sold yet
                        .findFirst()                      //get the first you find
                        .get()      
                        .getTitle()         //get the title
                        .startsWith(name);      //criteria
        
        try{
            final Offerings offerings = auctioneer.getOfferings();
            while(true){//search.apply(offerings.getArtworks())){
                Thread.sleep(gap);
                if((offerings.getBidder()== null||!offerings.getBidder().equals(sheikName)) && offerings.getBid()<max){
                    auctioneer.placebid(sheikName, auctioneer.getOfferings().getBid()+1);
                }                 
            } 
        }catch(NoSuchElementException exce){
            
        } catch (InterruptedException ex) {
            Logger.getLogger(AlgorithmicSheik.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
    
}
