package edu.hm.bartolov.a08_mvc.view;

import edu.hm.bartolov.a08_mvc.datastore.readonly.Artwork;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
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

    private static final Map<Integer,BiConsumer<String[], BufferedWriter>> BID = new HashMap<>();
    
    private static final Map<Integer,BiConsumer<String[], BufferedWriter>> NOBID = new HashMap<>();


        
    private final static String DIR = System.getProperty("java.io.tmpdir");
    
    private int updates = 0;
    
    Logger(Object... args) {
        super(null);
        
        BID.put(0, (data, bw) ->  {try {
                                    bw.write(data[0]+": "+data[1]+" zum Dritten, verkauft!");
                                    } catch (IOException ex ) {}});
        BID.put(1, (data, bw) ->  {try {
                                    bw.write(data[0]+": "+data[1]+" zum Zweiten...");
                                    } catch (IOException ex ) {}});
        BID.put(2, (data, bw) ->  {try {
                                    bw.write(data[0]+": "+data[1]+" zum Ersten...");
                                    } catch (IOException ex ) {}});
        BID.put(3, (data, bw) ->  {try {
                                    bw.write(data[0] + ": noch " +data[1]+ " geboten, hoere ich mehr?");
                                    } catch (IOException ex ) {}});
        BID.put(4, (data, bw) ->  {try {
                                    bw.write(data[0]+": "+data[1]+" geboten, hoere ich mehr?");
                                    } catch (IOException ex ) {}});
        BID.put(5, (data, bw) ->  {try {
                                    bw.write(data[0]+": "+data[1]+" geboten!");
                                    } catch (IOException ex ) {}});
        
        
        NOBID.put(0, (data, bw) -> {try {
                                    bw.write(data[0]+": " + "Keine Gebote, nicht verkauft.");
                                    } catch (IOException ex ) {}});
        NOBID.put(1, (data, bw) -> {try {
                                    bw.write(data[0]+": "+data[1]+" zum Zweiten...");
                                    } catch (IOException ex ) {}});
        NOBID.put(2, (data, bw) -> {try {
                                    bw.write(data[0]+": "+data[1]+" zum Ersten...");
                                    } catch (IOException ex ) {}});
        NOBID.put(3, (data, bw) -> {try {
                                    bw.write(data[0] + ": Mindestgebot noch " +data[1]+ " , bietet jemand?");
                                    } catch (IOException ex ) {}});
        NOBID.put(4, (data, bw) -> {try {
                                    bw.write(data[0]+": Mindestgebot "+data[1]+" , bietet jemand?");
                                    } catch (IOException ex ) {}});
        NOBID.put(5, (data, bw) -> {try {
                                    bw.write(data[0]+": Mindestgebot "+data[1]);
                                    } catch (IOException ex ) {}});
        
    }

    @Override
    public void update(Observable o, Object arg) {
        
        updates++;
        
        final File file = new File(DIR + "\\auction." + Integer.toString(updates) + ".log");
        
        try (BufferedWriter bw = Files.newBufferedWriter(file.toPath(), Charset.defaultCharset());) {
            
            final Artwork artwork = getDataStore().getArtworks() //get all Artworks in offerings
                .filter( art -> art.isAuctioned())           //only get Artworks which arent sold yet
                .findFirst()                                 //get the first you find
                .orElseThrow(IllegalStateException::new);    //if nothing is found then throw exception

            if(getDataStore().getBidder()==null){  
                NOBID.get(getDataStore().getStepsRemaining()).accept(new String[]{artwork.getTitle(),Integer.toString(artwork.getInitialPrice())}, bw);
            }else{
                BID.get(getDataStore().getStepsRemaining()).accept(new String[]{artwork.getTitle(),Integer.toString(getDataStore().getBid())}, bw);

            }
            
        } catch (IOException ex) {
            
        }
    }
}
