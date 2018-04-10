package edu.hm.software_architektur.a03_undercut.connections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Edo
 */
public class OnlineConnection implements Connection{
    
    public static final int DEFAULTPORTA = 2001;
    
    public static final int DEFAULTPORTB = 2002;
    
    private final int portA;
    
    private final int portB;
    
    private BufferedWriter outA;
    
    private BufferedWriter outB;
    
    private BufferedReader inA;
    
    private BufferedReader inB;

    public OnlineConnection(int portA, int portB) {
        this.portA = portA;
        this.portB = portB;
    }
    
    public OnlineConnection(){
        this(DEFAULTPORTA,DEFAULTPORTB);
    }
    
    public int getPortA() {
        return portA;
    }

    public int getPortB() {
        return portB;
    }

    @Override
    public void openConnection() throws IOException {
        
        final Socket socketA = new ServerSocket(portA).accept();
        outA = new BufferedWriter(new OutputStreamWriter((socketA.getOutputStream())));
        inA = new BufferedReader(new InputStreamReader(socketA.getInputStream()));
        
        outA.write("Welcome Player A!");
        outA.write("Please wait for Player B...");
        outA.flush();
        
        final Socket socketB = new ServerSocket(portB).accept();
        outB = new BufferedWriter(new OutputStreamWriter((socketB.getOutputStream())));
        inB = new BufferedReader(new InputStreamReader(socketB.getInputStream()));
        
        outB.write("Welcome Player B!");
        
        outA.write("Game starting!");
        outB.write("Game starting!");
        outA.flush();
        outB.flush();
    }

    @Override
    public int getUserInputA(int[] chooseRange) throws IOException {
        outA.write("Player A, your choice ("+chooseRange[0]+"-"+chooseRange[1]+")?");
        outA.flush();
        return getUserInput(chooseRange, inA );
    }

    @Override
    public int getUserInputB(int[] chooseRange) throws IOException {
        outB.write("Player B, your choice ("+chooseRange[0]+"-"+chooseRange[1]+")?");
        outB.flush();
        return getUserInput(chooseRange, inB);
    }
    
    private int getUserInput(int[] chooseRange,BufferedReader inR)throws IOException{
        int playerChoice;
        // read players' choices; if invalid, discard and retry
        do {
            final int input = Integer.parseInt(inR.readLine());
            if(input < 0)
                throw new IOException(); // bomb out on end of input
            playerChoice = input;
        }
        while(playerChoice < chooseRange[0] || playerChoice > chooseRange[1]);
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
