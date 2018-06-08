package edu.hm.bartolov.a08_mvc.view;

import edu.hm.bartolov.a08_mvc.datastore.readonly.Offerings;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
    private int updates;
    
    /**
     * Offerings as observable.
     */
    private final Offerings offer;
    
    /**
     * Construcor.
     * @param offerings 
     */
    protected Logger(Offerings offerings) {
        offer = offerings;
        updates = 0;
    }

    @Override
    public void update(Observable obser, Object arg) {
  
        final File file = new File(DIR + "\\auction." + Integer.toString(updates) + ".log");
        
        try (FileOutputStream out = new FileOutputStream(file)) {
            
            printProperties(offer, out);
            
        } catch (IOException exception) {
            System.out.println(ERROR);
        }
        
        updates++;
    }
    
}
