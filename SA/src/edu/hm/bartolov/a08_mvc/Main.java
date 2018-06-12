package edu.hm.bartolov.a08_mvc;

import edu.hm.bartolov.a08_mvc.control.Controller;
import edu.hm.bartolov.a08_mvc.datastore.writeable.MutableArtwork;
import edu.hm.bartolov.a08_mvc.datastore.writeable.MutableOfferings;
import edu.hm.bartolov.a08_mvc.logic.Auctioneer;
import edu.hm.bartolov.a08_mvc.view.Viewer;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 *
 * @author Edo
 */
public class Main {
/**
     * Entry-Point.
     * @param args Kommandozeilenargumente:
     * 1. Liste von Kunstwerken, mit Kommas getrennt. Jedes Kunstwerk in der Form "Name/Preis".
     * 2. Liste von Views, mit Kommas getrennt. Jede View "Name/Argument1/Argument2/...".
     * 3. Liste von Controls, mit Kommas getrennt. Jedes Control "Name/Argument1/Argument2/...".
     * Beispiel:
     * $ java -ea -Dauction.delay=1000 Main \
     * MonaLisa/2000,MickyMaus/1000 \
     * spectator \
     * robot/500=2500/8000=5000
     */
    public static void main(String... args) {
        // zerlegt ein Kommandozeilenargument in einen Stream von Wort-Arrays
        final Function<Integer, Stream<String[]>> argSplitter = index -> Stream.of(args[index].split(","))
                .filter(arg -> !arg.isEmpty())
                .map(arg -> arg.split("/"));

        // datastore
        final MutableArtwork[] artworks = argSplitter.apply(0)
                                          .map(nameAndPrice -> MutableArtwork.make(nameAndPrice[0],
                                                  Integer.parseInt(nameAndPrice[1])))
                                          .toArray(MutableArtwork[]::new);
        final MutableOfferings offerings = MutableOfferings.make(artworks);

        // logic
        final Auctioneer auction = Auctioneer.make(offerings);

        // viewers
//        argSplitter.apply(1)
//        .forEach(typeAndArgs -> Viewer.make(typeAndArgs[0],
//                                            offerings,
//                                            (Object[])Arrays.copyOfRange(typeAndArgs, 1, typeAndArgs.length)));

        Viewer.make("Spectator",offerings,new PrintWriter(System.out));
        
        // controller
        argSplitter.apply(1)//was 2
        .map(typeAndArgs -> Controller.make(typeAndArgs[0],
                                            auction,
                                            Arrays.copyOfRange(typeAndArgs, 1, typeAndArgs.length)))
        .map(Thread::new)
        .forEach(Thread::start);

        new Thread(auction).start();
    }
    
}

