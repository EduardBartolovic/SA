
package edu.hm.bartolov.a08_mvc.control;

import edu.hm.bartolov.a08_mvc.datastore.readonly.Artwork;
import edu.hm.bartolov.a08_mvc.logic.Auctioneer;
import java.io.IOException;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Bidding by Console. 
 * @author Eduard Bartolovic, Felix Peither
 */
public class ConsoleController extends Controller{
    
    /**
     * Name of this controller.
     */
    private static final String CONSOLE_CONTROLLER = "ConsoleController";
    
    /**
     * macimum length of the input bid.
     */
    private static final int LINE_LENGTH = 10;
    
    /**
     * The bytecode for a new line.
     */
    private static final byte[] NEW_LINE_BYTE = new byte[]{10};
    
    /**
     * The bytecode for a empty byte.
     */
    private static final byte[] EMPTY_BYTE = new byte[1];
    
    /**
     * Constant to shift the bid.
     */
    private static final int TIMES = 10;
    
    /**
     * the Auctioneer of this controller.
     */
    private final Auctioneer auctioneer;
    
    /**
     * Constructor.
     * @param auctioneer Auctioneer
     */
    protected ConsoleController(Auctioneer auctioneer) { 
        this.auctioneer = auctioneer; 
    } 
    
    @Override
    public void run() {
        
        final Function<Stream<? extends Artwork>,Boolean> auctionStillRunning = 
                (Stream<? extends Artwork> artworks) -> artworks.filter( art -> !art.isAuctioned())  //only get Artworks which arent sold yet
                .findAny()
                .isPresent();
        
        final byte[] inputBytes = new byte[LINE_LENGTH];
        
        while (auctionStillRunning.apply(auctioneer.getOfferings().getArtworks())) {
            int bid = 0;
            try {
                System.in.read(inputBytes);
            } catch (IOException ioe) {
                
            }
            
            for (int counter = 0; counter < LINE_LENGTH; counter++) {
                final char number = (char) inputBytes[counter];
                if (Character.isDigit(number)) {
                    bid *= TIMES;  
                    bid += Integer.parseInt(Character.toString(number)); 
                } else if (!Character.isDigit(number) && (int) number != NEW_LINE_BYTE[0] && number != EMPTY_BYTE[0]) {
                    throw new IllegalArgumentException("this is not a number: " + number);
                }
            }
            auctioneer.placeBid(CONSOLE_CONTROLLER, bid);
        }
        
    }
}

