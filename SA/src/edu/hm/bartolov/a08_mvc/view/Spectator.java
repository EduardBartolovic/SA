
package edu.hm.bartolov.a08_mvc.view;

import edu.hm.bartolov.a08_mvc.datastore.readonly.Artwork;
import edu.hm.bartolov.a08_mvc.datastore.readonly.Offerings;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Optional;
import java.util.function.BiConsumer;

/**
 *
 * @author Edo
 */
public class Spectator extends Viewer{

    /**
     * 
     */
//    private static final Map<Integer,BiConsumer<String,Integer>> NOBID = new HashMap<>();
//    
//    private static final Map<Integer,BiConsumer<String,Integer>> BID = new HashMap<>();
    
    private final Offerings offerings;
    
    private final PrintWriter printer;
    
    Spectator(Offerings offerings, PrintWriter pw) {
        
        this.offerings = offerings;
        printer = pw;
        offerings.addObserver(this);
//        
//        NOBID.put(0,(String title , Integer price) -> {pw.printf(title+Callout.Done.getFormatNobid(),price);});
//        NOBID.put(1,(String title , Integer price) -> {pw.printf(title+Callout.Going2nd.getFormatNobid(),price);});
//        NOBID.put(2,(String title , Integer price) -> {pw.printf(title+Callout.Going1st.getFormatNobid(),price);});
//        NOBID.put(3,(String title , Integer price) -> {pw.printf(title+Callout.Remaining3.getFormatNobid(),price);});
//        NOBID.put(4,(String title , Integer price) -> {pw.printf(title+Callout.Remaining4.getFormatNobid(),price);});
//        NOBID.put(5,(String title , Integer price) -> {pw.printf(title+Callout.NewBid.getFormatNobid(),price);});
//        
//        
//        BID.put(0,(String title , Integer price) -> {pw.printf(title+Callout.Done.getFormatBid(),price);});
//        BID.put(1,(String title , Integer price) -> {pw.printf(title+Callout.Going2nd.getFormatBid(),price);});
//        BID.put(2,(String title , Integer price) -> {pw.printf(title+Callout.Going1st.getFormatBid(),price);});
//        BID.put(3,(String title , Integer price) -> {pw.printf(title+Callout.Remaining3.getFormatBid(),price);});
//        BID.put(4,(String title , Integer price) -> {pw.printf(title+Callout.Remaining4.getFormatBid(),price);});
//        BID.put(5,(String title , Integer price) -> {pw.printf(title+Callout.NewBid.getFormatBid(),price);});
          
    }
    
    @Override
    public void update(Observable o, Object arg) {
        
        message(offerings.getArtworks() //get all Artworks in offerings
                .filter( art -> art.isAuctioned())           //only get Artworks which arent sold yet
                .findFirst());                                 //get the first you find
        
    }
    
    private void message(Optional<? extends Artwork> optionalArtwork){
        
        if(optionalArtwork.isPresent()){
            final Artwork artwork = optionalArtwork.get();
            final Callout callout = Callout.values()[offerings.getStepsRemaining()];
            
            
            if(offerings.getBidder() == null){
                printer.printf(artwork.getTitle() + ": " + callout.getFormatNobid() + "\n", artwork.getInitialPrice());
//                NOBID.get(getDataStore().getStepsRemaining()).accept(artwork.getTitle(),artwork.getInitialPrice());
                printer.flush();
            }else{
                printer.printf(artwork.getTitle() + ": " + callout.getFormatBid() + "\n", offerings.getBid());
//                BID.get(getDataStore().getStepsRemaining()).accept(artwork.getTitle(),getDataStore().getBid());
                printer.flush();

            }
        }
        
    }
    
}
