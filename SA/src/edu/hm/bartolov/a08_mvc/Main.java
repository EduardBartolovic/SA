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

//        final Controller con1 = Controller.make("console", auction, args);
//        starter.accept(con1);
//        final Controller con2 = Controller.make("Sheik-2020", auction, "","1020","1000");
//        starter.accept(con2);
//        final Controller con3 = Controller.make("Sheik-2022", auction, "Only","1022","1000");
//        starter.accept(con3);
//        final Controller con4 = Controller.make("Sheik-2500", auction, "O","1500","1000");
//        starter.accept(con4);
//        final Controller console = Controller.make("Console", auction);
//        starter.accept(console);
//        final Controller robot1 = Controller.make("robot-", auction, "500:2000", "2500:3000");
//        final Controller robot2 = Controller.make("robot-", auction, "2500:2500", "10500:2000");
//        final Controller robot3 = Controller.make("robot-", auction, "2500:4000", "13000:5000");
//        starter.accept(robot1);
//        starter.accept(robot2);
//        starter.accept(robot3);
          final Controller network = Controller.make("Network-9000", auction, "20000");
          starter.accept(network);

        new Thread(auction).start();
    }
    
}

