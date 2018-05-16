package edu.hm.bartolov.a07_undercut_threaded.connections;

import edu.hm.bartolov.a03_undercut.connections.Connection;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.List;

/**
 *
 * @author Computer
 */
public class OnlineConnectionThreaded implements Connection{

    /**
     * default port for player A.
     */
    public static final int DEFAULTPORTA = 2001;
    /**
     * default port for player B.
     */
    public static final int DEFAULTPORTB = 2002;
    /**
     * port.
     */
    private final int portA;
    /**
     * port.
     */
    private final int portB;
    
    /**
     * writer to comunicate to A.
     */
    private final Networker a;
    
    /**
     * writer to comunicate to A.
     */
    private final Networker b;
    
    

    /**
     * to set up ports.
     * @param portA port of player A
     * @param portB port of player B
     */
    public OnlineConnectionThreaded(int portA, int portB) {
        this.portA = portA;
        this.portB = portB;
        a = new Networker();
        b = new Networker();
    }
    
    /**
     * constructor loading default values.
     */
    public OnlineConnectionThreaded(){
        this(DEFAULTPORTA,DEFAULTPORTB);
    }

    @Override
    public void openConnection() throws IOException {
        a.run();
        b.run();
    }
  

    @Override
    public int getUserInputA(List<Integer> chooseRange) throws IOException {

        return a.getUserInput(chooseRange);
    }

    @Override
    public int getUserInputB(List<Integer> chooseRange) throws IOException {
        return b.getUserInput(chooseRange);
    }

    @Override
    public void printState(String state, int round, int scoreA, int scoreB) throws IOException {
       a.printState(state, round, scoreA, scoreB);
       b.printState(state, round, scoreA, scoreB);
    }
    
    
    private class Networker implements Runnable{

        /**
        * writer to comunicate to A.
        */
       private BufferedWriter outA;

       /**
        * reader to comunicate to A.
        */
       private BufferedReader inA;
       
        @Override
        public void run() {
            final Socket socketA;
            try {
                socketA = new ServerSocket(portA).accept();
                outA = new BufferedWriter(new OutputStreamWriter(socketA.getOutputStream(),Charset.defaultCharset()));
                inA = new BufferedReader(new InputStreamReader(socketA.getInputStream(),Charset.defaultCharset()));
                outA.write("Welcome Player!\r\n");
                outA.flush();
            } catch (IOException ex) {
                System.out.println("+++++ERROR+++++");
            }
            
        }
        
        
        public int getUserInput(List<Integer> chooseRange) throws IOException {
            outA.write("Player, you can choose:"+chooseRange);
            outA.newLine();
            outA.flush();
            int playerChoice;
            // read player's choices; if invalid, discard and retry
            do {
                final int input = Integer.parseInt(inA.readLine());
                if(input < 0) {
                    throw new IOException(); // bomb out on end of input
                }
                playerChoice = input;
            }
            while(!chooseRange.contains(playerChoice));
            return playerChoice;
        }
       
       public void printState(String state, int round, int scoreA, int scoreB) throws IOException {
        outA.write("State: "+state+", Round "+round+", Player A: "+scoreA+", Player B: "+ scoreB);
        outA.newLine();
        outA.flush();
        }
       
       
    }
    
}
