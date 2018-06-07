package edu.hm.bartolov.a08_mvc.view;

import edu.hm.bartolov.a08_mvc.datastore.readonly.Artwork;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.function.BiConsumer;

/**
 *
 * @author Computer
 */
public class Logger extends Viewer{

    private static final Map<Integer,BiConsumer<String[], BufferedWriter>> BID = new HashMap<>();
    
    private static final Map<Integer,BiConsumer<String[], BufferedWriter>> NOBID = new HashMap<>();
  
    private static final String DIR = System.getProperty("java.io.tmpdir");
    
    private static final String ERROR = "ErrorInLogger";
    
    private int updates = 0;
    
    Logger(Object... args) {
        super(null);
        
//        BID.put(0, (data, bw) ->  {try {
//                                    bw.write(data[0]+": "+data[1]+" zum Dritten, verkauft!");
//                                    } catch (IOException ex ) {System.out.println(ERROR);}});
//        BID.put(1, (data, bw) ->  {try {
//                                    bw.write(data[0]+": "+data[1]+" zum Zweiten...");
//                                    } catch (IOException ex ) {System.out.println(ERROR);}});
//        BID.put(2, (data, bw) ->  {try {
//                                    bw.write(data[0]+": "+data[1]+" zum Ersten...");
//                                    } catch (IOException ex ) {System.out.println(ERROR);}});
//        BID.put(3, (data, bw) ->  {try {
//                                    bw.write(data[0] + ": noch " +data[1]+ " geboten, hoere ich mehr?");
//                                    } catch (IOException ex ) {System.out.println(ERROR);}});
//        BID.put(4, (data, bw) ->  {try {
//                                    bw.write(data[0]+": "+data[1]+" geboten, hoere ich mehr?");
//                                    } catch (IOException ex ) {System.out.println(ERROR);}});
//        BID.put(5, (data, bw) ->  {try {
//                                    bw.write(data[0]+": "+data[1]+" geboten!");
//                                    } catch (IOException ex ) {System.out.println(ERROR);}});
//        
//        
//        NOBID.put(0, (data, bw) -> {try {
//                                    bw.write(data[0]+": " + "Keine Gebote, nicht verkauft.");
//                                    } catch (IOException ex ) {System.out.println(ERROR);}});
//        NOBID.put(1, (data, bw) -> {try {
//                                    bw.write(data[0]+": "+data[1]+" zum Zweiten...");
//                                    } catch (IOException ex ) {System.out.println(ERROR);}});
//        NOBID.put(2, (data, bw) -> {try {
//                                    bw.write(data[0]+": "+data[1]+" zum Ersten...");
//                                    } catch (IOException ex ) {System.out.println(ERROR);}});
//        NOBID.put(3, (data, bw) -> {try {
//                                    bw.write(data[0] + ": Mindestgebot noch " +data[1]+ " , bietet jemand?");
//                                    } catch (IOException ex ) {System.out.println(ERROR);}});
//        NOBID.put(4, (data, bw) -> {try {
//                                    bw.write(data[0]+": Mindestgebot "+data[1]+" , bietet jemand?");
//                                    } catch (IOException ex ) {System.out.println(ERROR);}});
//        NOBID.put(5, (data, bw) -> {try {
//                                    bw.write(data[0]+": Mindestgebot "+data[1]);
//                                    } catch (IOException ex ) {System.out.println(ERROR);}});
        
    }

    @Override
    public void update(Observable o, Object arg) {
        
        updates++;
        
        final File file = new File(DIR + "\\auction." + Integer.toString(updates) + ".log");
        
        try (final BufferedWriter bw = Files.newBufferedWriter(file.toPath(), Charset.defaultCharset())) {
            
            getDataStore()
                    .getArtworks()
                    .peek((Artwork art)->{
                        try {
                            bw.write("Title: "+art.getTitle()+" Sold: "+art.isAuctioned()+" InitialPrice: "+art.getInitialPrice()+" Buyer: "+art.getBuyer()+" SoldPrice: "+art.getSoldPrice());
                        } catch (IOException ex ) {
                            System.out.println(ERROR);
                        }})
                    .count();

//            if(getDataStore().getBidder()==null){  
//                NOBID.get(getDataStore().getStepsRemaining())
//                        .accept(new String[]{artwork.getTitle(),Integer.toString(artwork.getInitialPrice())}, bw);
//            }else{
//                BID.get(getDataStore().getStepsRemaining())
//                        .accept(new String[]{artwork.getTitle(),Integer.toString(getDataStore().getBid())}, bw);
//            }
            
        } catch (IOException ex) {
            System.out.println(ERROR);
        }
    }
}
