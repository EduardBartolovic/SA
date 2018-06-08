package edu.hm.bartolov.a08_mvc.view;

import edu.hm.bartolov.a08_mvc.datastore.readonly.Artwork;
import edu.hm.bartolov.a08_mvc.datastore.readonly.Offerings;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Observer;
import java.util.Properties;

/**
 * abstract Viewer class
 * @author Felix,Eduard
 */
public abstract class Viewer implements Observer{
    
    private final Offerings dataStore;

    protected Viewer(Offerings dataStore) {
        this.dataStore = dataStore;
        dataStore.addObserver(this);
    }

    protected Offerings getDataStore() {
        return dataStore;
    }
    
    public static Viewer make(String typekey,Offerings dataStore,Object... args){
        final Viewer viewer;
        switch (typekey) {
            case "dummy":
                viewer = new Dummy();
                break;
            case "spectator":
                viewer = new Spectator(dataStore);
                break;
            case "logger":
                viewer = new Logger(dataStore);
                break;
            default:
                throw new IllegalArgumentException();
        }
        
        
        return viewer;
    }  
    
    /**
     * Gibt die Datenbasis in xml-Format aus.
     * @param outputStream Ausgabeziel.
     * @@throws IOException
     */
    protected void printXML(OutputStream outputStream) throws IOException {
        toProperties().storeToXML(outputStream, null);
    }

    /**
     * Gibt die Datenbasis im Properties-Format aus.
     * @param outputStream Ausgabeziel.
     * @throws IOException
     */
    protected void printProperties(OutputStream outputStream) throws IOException {
        toProperties().store(outputStream, null);
    }

    /**
     * Packt die Datenbasis in Properties.
     * @return Properties mit allen Einzelheiten.
     */
    protected Properties toProperties() {
        final Properties properties = new Properties();
        properties.setProperty("dataStore.stepsRemaining", Integer.toString(dataStore.getStepsRemaining()));
        if(dataStore.getBidder() != null) {
            properties.setProperty("dataStore.currentBidder", dataStore.getBidder());
            properties.setProperty("dataStore.bid", Integer.toString(dataStore.getBid()));
        }
        int artworkIndex = 0;
        for(Iterator <? extends Artwork > artworkIterator = dataStore.getArtworks().iterator(); artworkIterator.hasNext();) {
            final Artwork artwork = artworkIterator.next();
            final String prefix = "artwork." + artworkIndex + '.';
            properties.setProperty(prefix + "title", artwork.getTitle());
            properties.setProperty(prefix + "initialPrice", Integer.toString(artwork.getInitialPrice()));
            properties.setProperty(prefix + "auctioned", Boolean.toString(artwork.isAuctioned()));
            if(artwork.isAuctioned() && artwork.getBuyer() != null) {
                properties.setProperty(prefix + "buyer", artwork.getBuyer());
                properties.setProperty(prefix + "soldPrice", Integer.toString(artwork.getSoldPrice()));
            }
            artworkIndex++;
        }
        return properties;
    }
}
