package edu.hm.bartolov.a08_mvc.control;

import edu.hm.bartolov.a08_mvc.datastore.readonly.Artwork;
import edu.hm.bartolov.a08_mvc.datastore.readonly.Offerings;
import edu.hm.bartolov.a08_mvc.logic.Auctioneer;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Sheik.
 * @author Eduard
 */
public class AlgorithmicSheik extends Controller{
    /**
     * Default wait time.
     */
    private static final String DEFAULTDELAY = "1000";
    
    /**
     * Contant to multiply the delay with.
     */
    private static final int DELAY_TIMES_CONST = 5;
    
    /**
     * name of picture targeted.
     */
    private final String name;
    
    /**
     * bidder name.
     */
    private final String sheikName;
    
    /**
     * max amount of bidding.
     */
    private final int max;
    
    /**
     * waitingTime.
     */
    private final int gap;
    
    /**
     * Auctionner.
     */
    private final Auctioneer auctioneer;

    /**
     * Constructor for the sheik.
     * 
     * @param auctioneer selfexplaining.
     * @param name of picture.
     * @param max amount bid.
     * @param gap waiting time.
     */
    protected AlgorithmicSheik( Auctioneer auctioneer, String name, int max, int gap) {
        this.name = name;
        this.max = max;
        //getting the systempropeties
        final int delay = Integer.parseInt(
                Optional.ofNullable(System.getProperty("auction.delay")).orElse(DEFAULTDELAY));
        this.gap = delay*DELAY_TIMES_CONST-gap;
        this.auctioneer = auctioneer;
        sheikName = "Sheik-"+(max+gap);
    }
    
    

    @Override
    public void run() {
        
        final Function<Stream<? extends Artwork>,Boolean> search = 
                (Stream<? extends Artwork> artworks) -> artworks.filter( art -> !art.isAuctioned())  //only get Artworks which arent sold yet
                        .findFirst()                      //get the first you find
                        .get()      
                        .getTitle()         //get the title
                        .startsWith(name);      //criteria
        
        final Function<Stream<? extends Artwork>,Boolean> auctionStillRunning = 
                (Stream<? extends Artwork> artworks) -> artworks.filter( art -> !art.isAuctioned())  //only get Artworks which arent sold yet
                .findAny()
                .isPresent();
        
        try{
            final Offerings offerings = auctioneer.getOfferings();
            while(auctionStillRunning.apply(offerings.getArtworks())){
                if(search.apply(offerings.getArtworks())){
                    Thread.sleep(gap);
                    if((offerings.getBidder()== null||!offerings.getBidder().equals(sheikName)) && offerings.getBid()<=max){
                        auctioneer.placeBid(sheikName, auctioneer.getOfferings().getBid()+1);
                    }
                }
                
            } 
        }catch(NoSuchElementException exce){
            exce.printStackTrace();
        } catch (InterruptedException exce) {
            exce.printStackTrace();
        }  
    }  
}
