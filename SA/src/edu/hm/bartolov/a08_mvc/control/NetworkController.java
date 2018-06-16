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
import java.util.Observable;
import java.util.function.Function;
import java.util.stream.Stream;


/**
 *
 * @author Eduard
 */
public class NetworkController extends Controller implements Viewer {

    /**
     * Acutioneer.
     */
    private final Auctioneer auctioneer;
    
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
    protected NetworkController(Auctioneer auctioneer, String port){
        try {
            this.auctioneer = auctioneer;
            this.port = Integer.parseInt(port);
            
            final Socket socket = new ServerSocket().accept();
            bufReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException exec) {
            throw new IllegalStateException();
        }
    }
    
    @Override
    public void update(Observable observable, Object arg) {
        
//        final Optional<? extends Artwork> optArt = auctioneer.getOfferings()
//                                                    .getArtworks()             //get all Artworks in offerings
//                                                    .filter( art -> !art.isAuctioned())  //only get Artworks which arent sold yet
//                                                    .findFirst();                      //get the first you find
//                
//        
//        if(optArt.isPresent()){
//            final Artwork artwork = optArt.get();
//            final Callout callout = Callout.values()[auctioneer.getOfferings().getStepsRemaining()];
            
            
//            if(auctioneer.getOfferings().getBidder() == null){
//                bufWriter.write(artwork.getTitle() + ": " + callout.getFormatNobid() + "\n", artwork.getInitialPrice());
//            }else{
//                bufWriter.write(artwork.getTitle() + ": " + callout.getFormatBid() + "\n", auctioneer.getOfferings().getBid());     
//            }
//            try {
//                bufWriter.flush();
//            } catch (IOException ioExe) {
//                System.out.println("ERROR IN UPDATE");
//            }
//        }
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void run() {
        
        final Offerings offerings = auctioneer.getOfferings();
        final Function<Stream<? extends Artwork>,Boolean> auctionStillRunning = 
                (Stream<? extends Artwork> artworks) -> artworks.filter( art -> !art.isAuctioned())  //only get Artworks which arent sold yet
                .findAny()
                .isPresent();
        
        while(auctionStillRunning.apply(offerings.getArtworks())){
            try{
                  bufWriter.write("Make your Bid:");
                  bufWriter.flush();  
                  final int bid = Integer.parseInt(bufReader.readLine());
                  final boolean worked = auctioneer.placeBid("Network-"+port, bid);
                  if(worked)
                      bufWriter.write("Bid placed");
                  else
                      bufWriter.write("Not enough");
                  bufWriter.flush();
              }catch(NumberFormatException exec){
                 System.out.println("Error");
              } catch (IOException exec) {
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
