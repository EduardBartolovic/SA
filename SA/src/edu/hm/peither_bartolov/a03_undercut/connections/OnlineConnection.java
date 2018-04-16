package edu.hm.peither_bartolov.a03_undercut.connections;

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
 * Das Programm oeffnet zu jedem Spieler einen eigenen Socket (Voreinstellung: Ports 2001 und 2002).
 * Es liest Eingaben vom Socket des betreffenden Spielers und schickt Ausgaben wahlweise an einen oder beide Spieler. (Die Spieler können über ein Netzwerk spielen,
 * beispielsweise mit einem Telnet-Client. Sie sehen die Wahl des Gegners nicht.) 
 * @author Eduard Bartolovic, Felix Peither
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
     * @param portA port of player A
     * @param portB port of player B
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
        outA = new BufferedWriter(new OutputStreamWriter(socketA.getOutputStream(),Charset.defaultCharset()));
        inA = new BufferedReader(new InputStreamReader(socketA.getInputStream(),Charset.defaultCharset()));
        
        outA.write("Welcome Player A!");
        outA.write("Please wait for Player B...");
        outA.newLine();
        outA.flush();
        
        final Socket socketB = new ServerSocket(portB).accept();
        outB = new BufferedWriter(new OutputStreamWriter(socketB.getOutputStream(),Charset.defaultCharset()));
        inB = new BufferedReader(new InputStreamReader(socketB.getInputStream(),Charset.defaultCharset()));
        
        outB.write("Welcome Player B!");
        outB.newLine();
        
        outA.write("Game starting!");
        outA.newLine();
        outA.flush();
        
        outB.write("Game starting!");
        outB.newLine();
        outB.flush();
    }

    @Override
    public int getUserInputA(List<Integer> chooseRange) throws IOException {
        outA.write("Player A, you can choose:"+chooseRange);
        outA.newLine();
        outA.flush();
        return getUserInput(chooseRange, inA );
    }

    @Override
    public int getUserInputB(List<Integer> chooseRange) throws IOException {
        outB.write("Player B, you can choose:"+chooseRange);
        outB.newLine();
        outB.flush();
        return getUserInput(chooseRange, inB);
    }
    
    /**
     * comuncating with player. and getting a number.
     * @param chooseRange which numbers the user can choose from
     * @param inR the reader which reads the input
     * @return int the chosen input from the user
     * @throws IOException if the input was not valid
     */
    private int getUserInput(List<Integer> chooseRange,BufferedReader inR)throws IOException{
        int playerChoice;
        // read player's choices; if invalid, discard and retry
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
        outA.newLine();
        outA.flush();
        outB.write("State: "+state+", Round "+round+", Player A: "+scoreA+", Player B: "+ scoreB);
        outB.newLine();
        outB.flush();
    }
    
    
    
}
