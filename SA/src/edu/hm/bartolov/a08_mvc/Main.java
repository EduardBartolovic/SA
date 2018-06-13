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

/**
 *
 * @author Edo
 */
public class Main {

    public static void main(String... args) {
        
        final Supplier<MutableOfferings> supplier = () -> 
                MutableOfferings.make(IntStream
                    .range(1, 10)
                    .mapToObj((int number)->{ return MutableArtwork.make(Integer.toString(number),number);})
                    .toArray(MutableArtwork[]::new));
        
        final Consumer<Controller> starter = (Controller t) -> {
            new Thread(t).start();
        };
        
        System.out.println("auction starting");
        
        final MutableOfferings offerings = supplier.get();
        Viewer.make("spectator",offerings,new PrintWriter(System.out));
        // logic
        final Auctioneer auction = Auctioneer.make(offerings);

        final Controller con1 = Controller.make("console", auction, args);
        starter.accept(con1);
        


        new Thread(auction).start();
    }
    
}

