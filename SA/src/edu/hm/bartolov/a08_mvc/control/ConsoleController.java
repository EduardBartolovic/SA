
package edu.hm.bartolov.a08_mvc.control;

import edu.hm.bartolov.a08_mvc.logic.AuctionLogic;
import edu.hm.bartolov.a08_mvc.logic.Auctioneer;
import java.io.IOException;

/**
 *
 * @author Eduard Bartolovic, Felix Peither
 */
public class ConsoleController extends Controller{
    
    /**
     * 
     */
    private static final int LINE_LENGTH = 10;
    
    /**
     * 
     */
    private static final byte[] EMPTY_INPUT = new byte[]{10};
    
    /**
     * 
     */
    private static final int TIMES = 10;
    
    /**
     * 
     */
    private final Auctioneer auctioneer;
    
    /**
     * 
     */
    public ConsoleController(Auctioneer auctioneer) { 
        this.auctioneer = auctioneer; 
    } 
    
    @Override
    public void run() {
        
        boolean auctionRunning = true;
        int bid = 0;
        byte[] inputBytes = new byte[LINE_LENGTH];
        char[] inputCharacters = new char[LINE_LENGTH];
        
        while (auctionRunning) {
            try {
            System.in.read(inputBytes);
            } catch (IOException ioe) {
                
            }
            if (inputBytes[0] == EMPTY_INPUT[0])
                auctionRunning = false;
            
            for (int counter = 0; counter < LINE_LENGTH; counter++) {
                inputCharacters[counter] = (char) inputBytes[counter];
                if (((int)inputCharacters[counter] - 48) > 0 &&((int) inputCharacters[counter] - 48) <= 9) {
//                    System.out.print(bid + " bid "); 
                    bid *= TIMES; 
//                    System.out.print(bid + " bid after ");
//                    System.out.println(""); 
                    bid += Integer.parseInt("" + inputCharacters[counter]); 
//                    System.out.print(bid + " bid "); 
                } else if ((int)inputCharacters[counter]-48 == 0) {
                    bid *= TIMES;
                }
            }
            System.out.println(bid); 
            bid = 0;
            inputBytes = new byte[10];
            inputCharacters = new char[10];
        }
    }
}

