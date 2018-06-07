package edu.hm.bartolov.a08_mvc.view;

import edu.hm.bartolov.a08_mvc.datastore.readonly.Artwork;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 *
 * @author Computer
 */
public class Logger extends Viewer{
    
    
    private static final Map<Integer,BiConsumer<String,Integer>> NOBID = new HashMap<>();
    
    private static final Map<Integer,BiConsumer<String, Integer>> BID = new HashMap<>();

    private static final Map<Integer,BiConsumer<String[], BufferedWriter>> BID_2 = new HashMap<>();
    
    private static final Map<Integer,BiConsumer<String[], BufferedWriter>> NOBID_2 = new HashMap<>();


        
    private final static String DIR = System.getProperty("java.io.tmpdir");
    
    private int updates = 0;
    
    Logger(Object... args) {
        super(null);
        
//            
//        NOBID.put(0,(String title , Integer price) -> {System.out.printf(title+Callout.Done.getFormatNobid(),price);});
//        NOBID.put(1,(String title , Integer price) -> {System.out.printf(title+Callout.Going2nd.getFormatNobid(),price);});
//        NOBID.put(2,(String title , Integer price) -> {System.out.printf(title+Callout.Going1st.getFormatNobid(),price);});
//        NOBID.put(3,(String title , Integer price) -> {System.out.printf(title+Callout.Remaining3.getFormatNobid(),price);});
//        NOBID.put(4,(String title , Integer price) -> {System.out.printf(title+Callout.Remaining4.getFormatNobid(),price);});
//        NOBID.put(5,(String title , Integer price) -> {System.out.printf(title+Callout.NewBid.getFormatNobid(),price);});
//        
//        
//        BID.put(0,(String title , Integer price) -> {System.out.printf(title+Callout.Done.getFormatBid(),price);});
//        BID.put(1,(String title , Integer price) -> {System.out.printf(title+Callout.Going2nd.getFormatBid(),price);});
//        BID.put(2,(String title , Integer price) -> {System.out.printf(title+Callout.Going1st.getFormatBid(),price);});
//        BID.put(3,(String title , Integer price) -> {System.out.printf(title+Callout.Remaining3.getFormatBid(),price);});
//        BID.put(4,(String title , Integer price) -> {System.out.printf(title+Callout.Remaining4.getFormatBid(),price);});
//        BID.put(5,(String title , Integer price) -> {System.out.printf(title+Callout.NewBid.getFormatBid(),price);});

        BID_2.put(0, (data, bw) -> {String price = data[1];
                                    String title = data[0];
                                    try {
                                    bw.write(title+": "+price+" zum Dritten, verkauft!");
                                    } catch (Exception ex ) {}});
        BID_2.put(1, (data, bw) -> {String price = data[1];
                                    String title = data[0];
                                    try {
                                    bw.write(title+": "+price+" zum Zweiten...");
                                    } catch (Exception ex ) {}});
        BID_2.put(2, (data, bw) -> {String price = data[1];
                                    String title = data[0];
                                    try {
                                    bw.write(title+": "+price+" zum Ersten...");
                                    } catch (Exception ex ) {}});
        BID_2.put(3, (data, bw) -> {String price = data[1];
                                    String title = data[0];
                                    try {
                                    bw.write(title + ": noch " + price + " geboten, hoere ich mehr?");
                                    } catch (Exception ex ) {}});
        BID_2.put(4, (data, bw) -> {String price = data[1];
                                    String title = data[0];
                                    try {
                                    bw.write(title+": "+price+" geboten, hoere ich mehr?");
                                    } catch (Exception ex ) {}});
        BID_2.put(5, (data, bw) -> {String price = data[1];
                                    String title = data[0];
                                    try {
                                    bw.write(title+": "+price+" geboten!");
                                    } catch (Exception ex ) {}});
        
        
        NOBID_2.put(0, (data, bw) -> {String price = data[1];
                                    String title = data[0];
                                    try {
                                    bw.write(title+": " + "Keine Gebote, nicht verkauft.");
                                    } catch (Exception ex ) {}});
        NOBID_2.put(1, (data, bw) -> {String price = data[1];
                                    String title = data[0];
                                    try {
                                    bw.write(title+": "+price+" zum Zweiten...");
                                    } catch (Exception ex ) {}});
        NOBID_2.put(2, (data, bw) -> {String price = data[1];
                                    String title = data[0];
                                    try {
                                    bw.write(title+": "+price+" zum Ersten...");
                                    } catch (Exception ex ) {}});
        NOBID_2.put(3, (data, bw) -> {String price = data[1];
                                    String title = data[0];
                                    try {
                                    bw.write(title + ": Mindestgebot noch " + price + " , bietet jemand?");
                                    } catch (Exception ex ) {}});
        NOBID_2.put(4, (data, bw) -> {String price = data[1];
                                    String title = data[0];
                                    try {
                                    bw.write(title+": Mindestgebot "+price+" , bietet jemand?");
                                    } catch (Exception ex ) {}});
        NOBID_2.put(5, (data, bw) -> {String price = data[1];
                                    String title = data[0];
                                    try {
                                    bw.write(title+": Mindestgebot "+price);
                                    } catch (Exception ex ) {}});
        
    }

    @Override
    public void update(Observable o, Object arg) {
        
        File file = new File(DIR + "\\auction." + Integer.toString(updates) + ".log");
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file));) {
            
            final Artwork artwork = getDataStore().getArtworks() //get all Artworks in offerings
                .filter( art -> art.isAuctioned())           //only get Artworks which arent sold yet
                .findFirst()                                 //get the first you find
                .orElseThrow(IllegalStateException::new);    //if nothing is found then throw exception
        
        final String title = artwork.getTitle();
        final int initialPrice = artwork.getInitialPrice();
        
        if(getDataStore().getBidder()==null){  
            NOBID_2.get(getDataStore().getStepsRemaining()).accept(new String[]{title,Integer.toString(initialPrice)}, bw);
        }else{
            BID_2.get(getDataStore().getStepsRemaining()).accept(new String[]{title,Integer.toString(getDataStore().getBid())}, bw);
        
        }
            
        } catch (Exception ex) {
            
        }
    }
}
