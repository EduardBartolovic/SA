
package edu.hm.bartolov.a08_mvc.control;

import edu.hm.bartolov.a08_mvc.logic.Auctioneer;
import java.io.IOException;

/**
 *
 * @author Eduard Bartolovic, Felix Peither
 */
public class ConsoleController extends Controller{
    
    /**
     * Name of this controller.
     */
    private static final String CONSOLE_CONTROLLER = "ConsoleController";
    
    /**
     * macimum length of the input bid.
     */
    private static final int LINE_LENGTH = 10;
    
    /**
     * The bytecode for a new line.
     */
    private static final byte[] EMPTY_INPUT = new byte[]{10};
    
    /**
     * Constant to shift the bid.
     */
    private static final int TIMES = 10;
    
    /**
     * the Auctioneer of this controller.
     */
    private final Auctioneer auctioneer;
    
    /**
     * 
     * @param auctioneer 
     */
    public ConsoleController(Auctioneer auctioneer) { 
        this.auctioneer = auctioneer; 
    } 
    
    @Override
    public void run() {
        
        boolean auctionRunning = true;
        int bid = 0;
        byte[] inputBytes = new byte[LINE_LENGTH];
        
        while (auctionRunning) {
            try {
                System.in.read(inputBytes);
            } catch (IOException ioe) {
                
            }
            if (inputBytes[0] == EMPTY_INPUT[0])
                auctionRunning = false;
            
            for (int counter = 0; counter < LINE_LENGTH; counter++) {
                char number = (char) inputBytes[counter];
                if (Character.isDigit(number)) {//((int)inputCharacters[counter] - 48) > 0 &&((int) inputCharacters[counter] - 48) <= 9) {
                    bid *= TIMES;  
                    bid += Integer.parseInt(Character.toString(number)); 
                } else if (!Character.isDigit(number) &&(int) number != 10) {
                    throw new IllegalArgumentException();
                }
            }
            auctioneer.placebid(CONSOLE_CONTROLLER, bid);
        }
        
    }
}

