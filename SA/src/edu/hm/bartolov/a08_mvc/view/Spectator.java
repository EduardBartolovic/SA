
package edu.hm.bartolov.a08_mvc.view;

import edu.hm.bartolov.a08_mvc.datastore.readonly.Artwork;
import edu.hm.bartolov.a08_mvc.datastore.readonly.Offerings;
import java.io.PrintWriter;
import java.util.Observable;
import java.util.Optional;

/**
 * Oberserver.
 * @author Eduard
 */
public class Spectator implements Viewer{
   
    /**
     * Offerings is Observable.
     */
    private final Offerings offerings;
    
    /**
     * Printwriter.
     */
    private final PrintWriter printer;
    
    /**
     * Constructor.
     * @param offerings
     * @param printw 
     */
    protected Spectator(Offerings offerings, PrintWriter printw) {
        
        this.offerings = offerings;
        printer = printw;
        offerings.addObserver(this);
        
    }
    
    @Override
    public void update(Observable obser, Object arg) {
        
        final Optional<? extends Artwork> optArt = offerings.getArtworks()             //get all Artworks in offerings
                                                    .filter( art -> !art.isAuctioned())  //only get Artworks which arent sold yet
                                                    .findFirst();                      //get the first you find
                
        
        if(optArt.isPresent()){
            final Artwork artwork = optArt.get();
            final Callout callout = Callout.values()[offerings.getStepsRemaining()];
            
            
            if(offerings.getBidder() == null){
                printer.printf(artwork.getTitle() + ": " + callout.getFormatNobid() + "\n", artwork.getInitialPrice());
            }else{
                printer.printf(artwork.getTitle() + ": " + callout.getFormatBid() + "\n", offerings.getBid());     
            }
            printer.flush();
        }
    }
    
    
}
