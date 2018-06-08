package edu.hm.bartolov.a08_mvc.view;

import edu.hm.bartolov.a08_mvc.datastore.readonly.Artwork;
import edu.hm.bartolov.a08_mvc.datastore.readonly.Offerings;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Observer;
import java.util.Properties;

/**
 * Viewer abstract class
 * @author Felix,Eduard
 */
public abstract class Viewer implements Observer{
    
    /**
     * 
     * @param typekey
     * @param offerings
     * @param args
     * @return 
     */
    public static Viewer make(String typekey,Offerings offerings,Object... args){
        final Viewer viewer;
        switch (typekey) {
            case "dummy":
                viewer = new Dummy();
                break;
            case "spectator":
                viewer = new Spectator(offerings, (PrintWriter) args[0]);
                break;
            case "logger":
                viewer = new Logger(offerings);
                break;
            default:
                throw new IllegalArgumentException();
        }
        
        
        return viewer;
    }
    
    
    /**
     * Gibt die Datenbasis in xml-Format aus.
     * @param offerings Datenbasis der Auktion.
     * @param outputStream Ausgabeziel.
     * @throws java.io.IOException
     */
    protected void printXML(Offerings offerings, OutputStream outputStream) throws IOException {
        toProperties(offerings).storeToXML(outputStream, null);
    }

    /**
     * Gibt die Datenbasis im Properties-Format aus.
     * @param offerings Datenbasis der Auktion.
     * @param outputStream Ausgabeziel.
     * @throws java.io.IOException
     */
    protected void printProperties(Offerings offerings, OutputStream outputStream) throws IOException {
        toProperties(offerings).store(outputStream, null);
    }

    /**
     * Packt die Datenbasis in Properties.
     * @param offerings Datenbasis.
     * @return Properties mit allen Einzelheiten.
     */
    private Properties toProperties(Offerings offerings) {
        final Properties properties = new Properties();
        properties.setProperty("offerings.stepsRemaining", Integer.toString(offerings.getStepsRemaining()));
        if(offerings.getBidder() != null) {
            properties.setProperty("offerings.currentBidder", offerings.getBidder());
            properties.setProperty("offerings.bid", Integer.toString(offerings.getBid()));
        }
        int artworkIndex = 0;
        final Iterator <? extends Artwork > artworkIterator = offerings.getArtworks().iterator();
        while(artworkIterator.hasNext()) {
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
