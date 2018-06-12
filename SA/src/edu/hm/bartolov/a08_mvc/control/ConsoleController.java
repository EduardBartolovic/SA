
package edu.hm.bartolov.a08_mvc.control;

import java.io.IOException;

/**
 *
 * @author Eduard
 */
public class ConsoleController extends Controller{
    
    private final static int LINE_LENGTH = 10;
    
    private final static byte[] EMPTY_INPUT = new byte[]{10};
    
    public ConsoleController() {
        
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
                int times = 10;
                inputCharacters[counter] = (char) inputBytes[counter];
//                System.out.println((int)c[counter] - 48);
//                System.out.println(times);
                if (((int)inputCharacters[counter] - 48) > 0 &&((int) inputCharacters[counter] - 48) <= 9) {
//                    System.out.println("here" + c[counter]);
//                    System.out.println("Integer " + Integer.parseInt("" + c[counter]));
                    System.out.print(bid + " bid "); bid *= times; System.out.print(bid + " bid after ");
                    System.out.println(""); 
                    bid += Integer.parseInt("" + inputCharacters[counter]); 
                    System.out.print(bid + " bid "); 
//                    System.out.println(bid + " bid");
                } else if ((int)inputCharacters[counter]-48 == 0) {
                    bid *= times;
                }
            }
            System.out.println(bid); 
            bid = 0;
            inputBytes = new byte[10];
            inputCharacters = new char[10];
        }
    }
}

