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
class AlgorithmicSheik extends Controller{
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
     * Constructor for the sheik.
     * 
     * @param auctioneer selfexplaining.
     * @param name of picture.
     * @param max amount bid.
     * @param gap waiting time.
     */
    AlgorithmicSheik( Auctioneer auctioneer, String name, int max, int gap) {
        super(auctioneer);
        this.name = name;
        this.max = max;
        //getting the systempropeties
        final int delay = Integer.parseInt(
                Optional.ofNullable(System.getProperty("auction.delay")).orElse(DEFAULTDELAY));
        this.gap = delay*DELAY_TIMES_CONST-gap;
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
            final Offerings offerings = getAuctioneer().getOfferings();
            while(auctionStillRunning.apply(offerings.getArtworks())){
                if(search.apply(offerings.getArtworks())){
                    Thread.sleep(gap);
                    if((offerings.getBidder()== null||!offerings.getBidder().equals(sheikName)) && offerings.getBid()<=max){
                        getAuctioneer().placeBid(sheikName, getAuctioneer().getOfferings().getBid()+1);
                    }
                }
                
            } 
        }catch(NoSuchElementException | InterruptedException exce){
            System.out.println("ERROR");
        }  
    }  
}
