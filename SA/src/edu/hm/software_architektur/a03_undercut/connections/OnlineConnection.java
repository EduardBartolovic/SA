package edu.hm.software_architektur.a03_undercut.connections;

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
 * @author Edo
 */
public class OnlineConnection implements Connection{
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
    private BufferedWriter outA;
    
    /**
     * writer to comunicate to B.
     */
    private BufferedWriter outB;
    
    /**
     * reader to comunicate to A.
     */
    private BufferedReader inA;
    /**
     * reader to comunicate to A.
     */
    private BufferedReader inB;

    /**
     * to set up ports.
     * @param portA
     * @param portB 
     */
    public OnlineConnection(int portA, int portB) {
        this.portA = portA;
        this.portB = portB;
    }
    
    /**
     * constructor loading default values.
     */
    public OnlineConnection(){
        this(DEFAULTPORTA,DEFAULTPORTB);
    }

    @Override
    public void openConnection() throws IOException {
        
        final Socket socketA = new ServerSocket(portA).accept();
        outA = new BufferedWriter(new OutputStreamWriter((socketA.getOutputStream()),Charset.defaultCharset()));
        inA = new BufferedReader(new InputStreamReader(socketA.getInputStream(),Charset.defaultCharset()));
        
        outA.write("Welcome Player A!");
        outA.write("Please wait for Player B...");
        outA.flush();
        
        final Socket socketB = new ServerSocket(portB).accept();
        outB = new BufferedWriter(new OutputStreamWriter((socketB.getOutputStream()),Charset.defaultCharset()));
        inB = new BufferedReader(new InputStreamReader(socketB.getInputStream(),Charset.defaultCharset()));
        
        outB.write("Welcome Player B!");
        
        outA.write("Game starting!");
        outB.write("Game starting!");
        outA.flush();
        outB.flush();
    }

    @Override
    public int getUserInputA(List<Integer> chooseRange) throws IOException {
        outA.write("Player A, you can choose:"+chooseRange);
        outA.flush();
        return getUserInput(chooseRange, inA );
    }

    @Override
    public int getUserInputB(List<Integer> chooseRange) throws IOException {
        outB.write("Player B, you can choose:"+chooseRange);
        outB.flush();
        return getUserInput(chooseRange, inB);
    }
    
    /**
     * comuncating with player. and getting a number.
     * @param chooseRange
     * @param inR
     * @return int
     * @throws IOException 
     */
    private int getUserInput(List<Integer> chooseRange,BufferedReader inR)throws IOException{
        int playerChoice;
        // read players' choices; if invalid, discard and retry
        do {
            final int input = Integer.parseInt(inR.readLine());
            if(input < 0)
                throw new IOException(); // bomb out on end of input
            playerChoice = input;
        }
        while(!chooseRange.contains(playerChoice));
        return playerChoice;
    }

    @Override
    public void printState(String state, int round, int scoreA, int scoreB) throws IOException {
        outA.write("State: "+state+", Round "+round+", Player A: "+scoreA+", Player B: "+ scoreB);
        outA.flush();
        outB.write("State: "+state+", Round "+round+", Player A: "+scoreA+", Player B: "+ scoreB);
        outB.flush();
    }
    
    
    
}
