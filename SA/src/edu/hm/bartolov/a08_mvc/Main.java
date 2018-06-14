package edu.hm.bartolov.a08_mvc;

import edu.hm.bartolov.a08_mvc.control.Controller;
import edu.hm.bartolov.a08_mvc.datastore.writeable.MutableArtwork;
import edu.hm.bartolov.a08_mvc.datastore.writeable.MutableOfferings;
import edu.hm.bartolov.a08_mvc.logic.Auctioneer;
import edu.hm.bartolov.a08_mvc.view.Viewer;
import java.io.PrintWriter;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author Edo
 */
public class Main {

    public static void main(String... args) {
        
        final Supplier<MutableOfferings> simpleSupplier = () -> 
                MutableOfferings.make(IntStream
                    .range(1, 10)
                    .mapToObj((int number)->{ return MutableArtwork.make(Integer.toString(number),number);})
                    .peek(System.out::println)
                    .toArray(MutableArtwork[]::new));
        
        final Supplier<MutableOfferings> picasso = () -> 
                MutableOfferings.make(Stream.of("MonaLisa","DerSchrei","OnlyWhite","OnlyBlack")
                    .map((String name)->{ return MutableArtwork.make(name,1000);})
                    .peek(System.out::println)
                    .toArray(MutableArtwork[]::new));
        
        final Consumer<Controller> starter = (Controller t) -> {
            new Thread(t).start();
        };
        
        System.out.println("auction starting");
        
        final MutableOfferings offerings = picasso.get();//simpleSupplier.get();
        Viewer.make("spectator",offerings,new PrintWriter(System.out));
        // logic
        final Auctioneer auction = Auctioneer.make(offerings);

        final Controller con1 = Controller.make("console", auction, args);
        starter.accept(con1);
        final Controller con2 = Controller.make("Sheik-1001", auction, "OnlyWhite","2500","2000" );
        starter.accept(con2);
        //final Controller con3 = Controller.make("Sheik-1501", auction, "1","1500","1000" );
        //starter.accept(con3);

        new Thread(auction).start();
    }
    
}

