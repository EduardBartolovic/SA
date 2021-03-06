package edu.hm.bartolov.a07_undercut_threaded.connections;

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
 * Es liest Eingaben vom Socket des betreffenden Spielers und schickt Ausgaben wahlweise an einen oder beide Spieler. (Die Spieler koennen ueber ein Netzwerk spielen,
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
        
        outA.write("Welcome Player A!\r\nPlease wait for Player B...\r\n");
        outA.flush();
        
        final Socket socketB = new ServerSocket(portB).accept();
        outB = new BufferedWriter(new OutputStreamWriter(socketB.getOutputStream(),Charset.defaultCharset()));
        inB = new BufferedReader(new InputStreamReader(socketB.getInputStream(),Charset.defaultCharset()));
        
        startGameMessages(outA, outB);
    }
   
    /**
     * Informs both players that the game is starting.
     * @param bwA writer for A
     * @param bwB writer for B
     * @throws IOException 
     */
    public void startGameMessages(BufferedWriter bwA, BufferedWriter bwB) throws IOException {
        bwB.write("Welcome Player B!");
        bwB.newLine();
        
        bwA.write("Game starting!");
        bwA.newLine();
        bwA.flush();
        
        bwB.write("Game starting!");
        bwB.newLine();
        bwB.flush();
    }

    @Override
    public int[] getUserInput(List<Integer> chooseRangeA, List<Integer> chooseRangeB) throws IOException {
        final int[] choices = new int[2];
        outA.write("Player A, you can choose:"+chooseRangeA);
        outA.newLine();
        outA.flush();
        choices[0] = getUserInput(chooseRangeA,inA);
        
        outB.write("Player B, you can choose:"+chooseRangeB);
        outB.newLine();
        outB.flush();
        choices[1] = getUserInput(chooseRangeB,inB);
        
        return choices;
    }

    
    /**
     * comuncating with player. and getting a number.
     * @param chooseRange which numbers the user can choose from
     * @param buffReader the reader which reads the input
     * @return int the chosen input from the user
     * @throws IOException if the input was not valid
     */
    private int getUserInput(List<Integer> chooseRange,BufferedReader buffReader)throws IOException{
        int playerChoice;
        // read player's choices; if invalid, discard and retry
        do {
            final int input = Integer.parseInt(buffReader.readLine());
            if(input < 0) {
                throw new IOException(); // bomb out on end of input
            }
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
