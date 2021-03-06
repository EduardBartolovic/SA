package edu.hm.bartolov.a07_undercut_threaded.connections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Online connection with threads, each player is one thread.
 * 
 * @author Eduard Bartolovic, Felix Peither
 */
public class OnlineConnectionThreaded extends OnlineConnection{
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
    public OnlineConnectionThreaded(int portA, int portB) {
        this.portA = portA;
        this.portB = portB;
    }
    
    /**
     * constructor loading default values.
     */
    public OnlineConnectionThreaded(){
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
  

    @Override
    public int[] getUserInput(List<Integer> chooseRangeA, List<Integer> chooseRangeB) throws IOException {
        
        final Callable<Integer> taskA = new GetUserInput(chooseRangeA,outA,inA);
        final Callable<Integer> taskB = new GetUserInput(chooseRangeB,outB,inB);
        final ExecutorService executor = Executors.newFixedThreadPool(2);
        
        final List<Future<Integer>> answers = new ArrayList<>(2);
        answers.add(executor.submit(taskA));
        answers.add(executor.submit(taskB));
        
        final int[] answer;
        try {
            answer = new int[]{answers.get(0).get(),answers.get(1).get()};
        } catch (InterruptedException | ExecutionException exception) {
            throw new IllegalStateException();
        }
        executor.shutdown();
        
        return answer;
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
    
    /**
     * Private class to get the input of each player.
     */
    private class GetUserInput implements Callable<Integer>{
        
        /**
         * Choose range of the current round or rules.
         */
        private final List<Integer> chooseRange;

        /**
         * Writer who writes output stuff.
         */
        private final BufferedWriter writer;
        
        /**
         * Reader thet reads the user input.
         */
        private final BufferedReader reader;

        /**
         * Getter for the user input.
         * 
         * @param chooseRange the momentairy choose range
         * @param bufOut output writer
         * @param bufIn input reader
         */
        GetUserInput(List<Integer> chooseRange, BufferedWriter bufOut, BufferedReader bufIn) {
            this.chooseRange = chooseRange;
            writer = bufOut;
            reader = bufIn;
        }


        @Override
        public Integer call() throws Exception {
            
            writer.write("Player! You can choose:"+chooseRange);
            writer.flush();
             
            int playerChoice;
            // read player's choices; if invalid, discard and retry
            do {
                final int input = Integer.parseInt(reader.readLine());
                if(input < 0) {
                    throw new IOException(); // bomb out on end of input
                }
                playerChoice = input;
            }
            while(!chooseRange.contains(playerChoice));
            return playerChoice;
        }
        
    } 
    
}
