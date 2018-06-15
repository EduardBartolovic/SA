package edu.hm.bartolov.a08_mvc.control;

import edu.hm.bartolov.a08_mvc.datastore.readonly.Artwork;
import edu.hm.bartolov.a08_mvc.datastore.readonly.Offerings;
import edu.hm.bartolov.a08_mvc.logic.Auctioneer;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author Eduard
 */
public class AlgorithmicSheik extends Controller{
    
    private static final String DEFAULTDELAY = "1000";
    
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
        //getting the systempropeties
        final int delay = Integer.parseInt(
                Optional.ofNullable(System.getProperty("auction.delay")).orElse(DEFAULTDELAY));
        this.gap = (delay*5)-gap;
        this.auctioneer = auctioneer;
        sheikName = "Sheik-"+(max+gap);
    }
    
    

    @Override
    public void run() {
        
        final Function<Stream<? extends Artwork>,Boolean> search = 
                (Stream<? extends Artwork> t) -> t.filter( art -> !art.isAuctioned())  //only get Artworks which arent sold yet
                        .findFirst()                      //get the first you find
                        .get()      
                        .getTitle()         //get the title
                        .startsWith(name);      //criteria
        
        final Function<Stream<? extends Artwork>,Boolean> auctionStillRunning = 
                (Stream<? extends Artwork> t) -> t.filter( art -> !art.isAuctioned())  //only get Artworks which arent sold yet
                .findAny()
                .isPresent();
        
        try{
            final Offerings offerings = auctioneer.getOfferings();
            while(auctionStillRunning.apply(offerings.getArtworks())){
                if(search.apply(offerings.getArtworks())){
                    Thread.sleep(gap);
                    if((offerings.getBidder()== null||!offerings.getBidder().equals(sheikName)) && offerings.getBid()<=max){
                        auctioneer.placebid(sheikName, auctioneer.getOfferings().getBid()+1);
                    }
                }
                
            } 
        }catch(NoSuchElementException exce){
            
        } catch (InterruptedException ex) {
            Logger.getLogger(AlgorithmicSheik.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
    
}
