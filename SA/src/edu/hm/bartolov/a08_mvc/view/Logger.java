package edu.hm.bartolov.a08_mvc.view;

import edu.hm.bartolov.a08_mvc.datastore.readonly.Artwork;
import edu.hm.bartolov.a08_mvc.datastore.readonly.Offerings;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Observable;

/**
 *
 * @author Computer
 */
public class Logger extends Viewer{
  
    /**
     * The target Directory.
     */
    private static final String DIR = System.getProperty("java.io.tmpdir");
    
    /**
     * Error message.
     */
    private static final String ERROR = "ErrorInLogger";
    
    /**
     * Number of updates that have been made. For the file name.
     */
    private int updates = 0;
    
    private final Offerings offer;
    
    Logger(Offerings offerings) {
        offer = offerings;
    }

    @Override
    public void update(Observable o, Object arg) {
        
        updates++;
        
        final File file = new File(DIR + "\\auction." + Integer.toString(updates) + ".log");
        
        try (BufferedWriter bw = Files.newBufferedWriter(file.toPath(), Charset.defaultCharset())) {
            
            final long count = offer.getArtworks()
                                        .peek((Artwork art)->{
                                            try {
                                                bw.write("Title: "+art.getTitle()+" Sold: "+art.isAuctioned()+" InitialPrice: "+art.getInitialPrice()+" Buyer: "+art.getBuyer()+" SoldPrice: "+art.getSoldPrice());
                                            } catch (IOException ex ) {
                                                System.out.println(ERROR);
                                            }})
                                        .count();
            System.out.println(count);
            
        } catch (IOException ex) {
            System.out.println(ERROR);
        }
    }
    
}
