
package edu.hm.bartolov.a08_mvc.view;

import edu.hm.bartolov.a08_mvc.datastore.readonly.Artwork;
import edu.hm.bartolov.a08_mvc.datastore.readonly.Offerings;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.function.BiConsumer;

/**
 *
 * @author Edo
 */
public class Spectator extends Viewer{

    private static final Map<Integer,BiConsumer<String,Integer>> NOBID = new HashMap<>();
    private static final Map<Integer,BiConsumer<String,Integer>> BID = new HashMap<>();
    
    
    final Offerings offerings;
    
    Spectator(Object object) {
        super(null);
        offerings = (Offerings) object;
        
        NOBID.put(0,(String title , Integer price) -> {System.out.printf(title+Callout.Done.getFormatNobid(),price);});
        NOBID.put(1,(String title , Integer price) -> {System.out.printf(title+Callout.Going2nd.getFormatNobid(),price);});
        NOBID.put(2,(String title , Integer price) -> {System.out.printf(title+Callout.Going1st.getFormatNobid(),price);});
        NOBID.put(3,(String title , Integer price) -> {System.out.printf(title+Callout.Remaining3.getFormatNobid(),price);});
        NOBID.put(4,(String title , Integer price) -> {System.out.printf(title+Callout.Remaining4.getFormatNobid(),price);});
        NOBID.put(5,(String title , Integer price) -> {System.out.printf(title+Callout.NewBid.getFormatNobid(),price);});
        
        
        BID.put(0,(String title , Integer price) -> {System.out.printf(title+Callout.Done.getFormatBid(),price);});
        BID.put(1,(String title , Integer price) -> {System.out.printf(title+Callout.Going2nd.getFormatBid(),price);});
        BID.put(2,(String title , Integer price) -> {System.out.printf(title+Callout.Going1st.getFormatBid(),price);});
        BID.put(3,(String title , Integer price) -> {System.out.printf(title+Callout.Remaining3.getFormatBid(),price);});
        BID.put(4,(String title , Integer price) -> {System.out.printf(title+Callout.Remaining4.getFormatBid(),price);});
        BID.put(5,(String title , Integer price) -> {System.out.printf(title+Callout.NewBid.getFormatBid(),price);});
        
        
    }
    
    @Override
    public void update(Observable o, Object arg) {
        
        final Artwork artwork = offerings.getArtworks()
                .filter( art -> art.isAuctioned())
                .findFirst()
                .orElseThrow(IllegalStateException::new);
        
        final String title = artwork.getTitle();
        final int initialPrice = artwork.getInitialPrice();
        
        if(offerings.getBidder()==null){  
            NOBID.get(offerings.getStepsRemaining()).accept(title,initialPrice);
        }else{
            BID.get(offerings.getStepsRemaining()).accept(title,initialPrice);
        
        }
           
    }
    
}
