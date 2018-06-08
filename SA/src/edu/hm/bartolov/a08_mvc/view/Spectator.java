
package edu.hm.bartolov.a08_mvc.view;

import edu.hm.bartolov.a08_mvc.datastore.readonly.Artwork;
import edu.hm.bartolov.a08_mvc.datastore.readonly.Offerings;
import java.io.PrintWriter;
import java.util.Observable;
import java.util.Optional;

/**
 *
 * @author Edo
 */
public class Spectator extends Viewer{
   
    private final Offerings offerings;
    
    private final PrintWriter printer;
    
    Spectator(Offerings offerings, PrintWriter pw) {
        
        this.offerings = offerings;
        printer = pw;
        offerings.addObserver(this);
        
    }
    
    @Override
    public void update(Observable o, Object arg) {
        
        message(offerings.getArtworks()                         //get all Artworks in offerings
                .filter( art -> art.isAuctioned())           //only get Artworks which arent sold yet
                .findFirst());                                 //get the first you find
        
    }
    
    private void message(Optional<? extends Artwork> optionalArtwork){
        
        if(optionalArtwork.isPresent()){
            final Artwork artwork = optionalArtwork.get();
            final Callout callout = Callout.values()[offerings.getStepsRemaining()];
            
            
            if(offerings.getBidder() == null){
                printer.printf(artwork.getTitle() + ": " + callout.getFormatNobid() + "\n", artwork.getInitialPrice());
                printer.flush();
            }else{
                printer.printf(artwork.getTitle() + ": " + callout.getFormatBid() + "\n", offerings.getBid());
                printer.flush();

            }
        }
        
    }
    
}
