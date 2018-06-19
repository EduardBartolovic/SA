package edu.hm.bartolov.a08_mvc.control;

import edu.hm.bartolov.a08_mvc.datastore.readonly.Artwork;
import edu.hm.bartolov.a08_mvc.datastore.readonly.Offerings;
import edu.hm.bartolov.a08_mvc.logic.Auctioneer;
import edu.hm.bartolov.a08_mvc.view.Viewer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.util.Observable;
import java.util.function.Function;
import java.util.stream.Stream;


/**
 * The Network Controller.
 * 
 * @author Eduard Bartolovic, Felix Peither
 */
public class NetworkController extends Controller implements Viewer {
    
    /**
     * Port of Server.
     */
    private final int port;
    
    /**
     * Reader.
     */
    private final BufferedReader bufReader;
    
    /**
     * Writer.
     */
    private final BufferedWriter bufWriter;

    /**
     * Constructor.
     * @param auctioneer Auctioneer
     * @param port ServerPort
     */
    NetworkController(Auctioneer auctioneer, String port){
        super(auctioneer);
        try {
            this.port = Integer.parseInt(port);
            
            final Socket socket = new ServerSocket(this.port).accept();
            bufReader = new BufferedReader(new InputStreamReader(socket.getInputStream(),UTF_8));
            bufWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),UTF_8));
        } catch (IOException exec) {
            throw new IllegalStateException();
        }
    }
    
    @Override
    public void update(Observable observable, Object arg) {
        
        Viewer.make("spectator", getAuctioneer().getOfferings(), bufWriter);
        
    }
    
    @Override
    public void run() {
        
        final Offerings offerings = getAuctioneer().getOfferings();
        final Function<Stream<? extends Artwork>,Boolean> auctionStillRunning = 
                (Stream<? extends Artwork> artworks) -> artworks.filter( art -> !art.isAuctioned())  //only get Artworks which arent sold yet
                .findAny()
                .isPresent();
        
        while(auctionStillRunning.apply(offerings.getArtworks())){
            try{
                  bufWriter.write("Make your Bid:");
                  bufWriter.flush();  
                  final int bid = Integer.parseInt(bufReader.readLine());
                  final boolean worked = getAuctioneer().placeBid("Network-"+port, bid);
                  if(worked)
                      bufWriter.write("Bid placed");
                  else
                      bufWriter.write("Not enough");
                  bufWriter.flush();
              }catch(NumberFormatException | IOException exec){
                 System.out.println("Error");
              }
            
        }
        try {
            bufWriter.write("Auction is Over");
            bufWriter.flush();
        } catch (IOException exec) {
            System.out.println("ERROR");
        }
            
        
    }
    
    
}
