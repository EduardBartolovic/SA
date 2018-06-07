package edu.hm.bartolov.a08_mvc.view;

import edu.hm.bartolov.a08_mvc.datastore.readonly.Artwork;
import edu.hm.bartolov.a08_mvc.datastore.readonly.Offerings;
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
    
    Logger(Object arg) {
        super((Offerings)arg);
    }

    @Override
    public void update(Observable o, Object arg) {
        
        updates++;
        
        final File file = new File(DIR + "\\auction." + Integer.toString(updates) + ".log");
        
        try (BufferedWriter bw = Files.newBufferedWriter(file.toPath(), Charset.defaultCharset())) {
            
            final long count = super.getDataStore()
                                        .getArtworks()
                                        .peek((Artwork art)->{
                                            try {
                                                bw.write("Title: "+art.getTitle()+" Sold: "+art.isAuctioned()+" InitialPrice: "+art.getInitialPrice()+" Buyer: "+art.getBuyer()+" SoldPrice: "+art.getSoldPrice());
                                            } catch (IOException ex ) {
                                                System.out.println(ERROR);
                                            }})
                                        .count();
            
        } catch (IOException ex) {
            System.out.println(ERROR);
        }
    }
}
