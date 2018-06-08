package edu.hm.bartolov.a08_mvc.view;

/* (C) 2018, R. Schiedermeier, rs@cs.hm.edu
 * Oracle Corporation Java 1.8.0_121, Linux i386 4.15.4
 * bluna: Intel Core i7-5600U/2600 MHz, 4 Core(s), 15936 MByte RAM
 **/
import edu.hm.bartolov.a08_mvc.datastore.readonly.Artwork;
import edu.hm.bartolov.a08_mvc.datastore.readonly.Offerings;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Properties;

/**
 * Companionklasse, die die Datenbasis in formaler Darstellung ausgibt.
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2018-05-21
 */
final class Viewers {
    /**
     * Gibt die Datenbasis in xml-Format aus.
     * @param offerings Datenbasis der Auktion.
     * @param outputStream Ausgabeziel.
     */
    static void printXML(Offerings offerings, OutputStream outputStream) throws IOException {
        toProperties(offerings).storeToXML(outputStream, null);
    }

    /**
     * Gibt die Datenbasis im Properties-Format aus.
     * @param offerings Datenbasis der Auktion.
     * @param outputStream Ausgabeziel.
     */
    static void printProperties(Offerings offerings, OutputStream outputStream) throws IOException {
        toProperties(offerings).store(outputStream, null);
    }

    /**
     * Packt die Datenbasis in Properties.
     * @param offerings Datenbasis.
     * @return Properties mit allen Einzelheiten.
     */
    private static Properties toProperties(Offerings offerings) {
        final Properties properties = new Properties();
        properties.setProperty("offerings.stepsRemaining", Integer.toString(offerings.getStepsRemaining()));
        if(offerings.getBidder() != null) {
            properties.setProperty("offerings.currentBidder", offerings.getBidder());
            properties.setProperty("offerings.bid", Integer.toString(offerings.getBid()));
        }
        int artworkIndex = 0;
        for(Iterator <? extends Artwork > artworkIterator = offerings.getArtworks().iterator(); artworkIterator.hasNext();) {
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