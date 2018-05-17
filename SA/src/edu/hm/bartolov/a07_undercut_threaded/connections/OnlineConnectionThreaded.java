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
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author Computer
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
        
//        final ExecutorService executor = Executors.newFixedThreadPool(2);
//        final Callable<Socket> taskA = new GetConnection(portA);
//        final Callable<Socket> taskB = new GetConnection(portB);
//        final Future<Socket>[] sockets = new Future[2];
//        sockets[0] = executor.submit(taskA);
//        sockets[1] = executor.submit(taskB);
//        
//        try {
//            socketA = sockets[0].get();
//            socketB = sockets[1].get();
//        } catch (InterruptedException | ExecutionException ex) {
//            throw new IllegalStateException();
//        }
//        
//        
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
        final Future<Integer>[] answers = new Future[2];
        final ExecutorService executor = Executors.newFixedThreadPool(2);
        answers[0] = executor.submit(taskA);
        answers[1] = executor.submit(taskB);
        
        final int[] answer;
        try {
            answer = new int[]{answers[0].get(),answers[1].get()};
        } catch (InterruptedException | ExecutionException ex) {
            throw new IllegalStateException();
        }
        
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
    
//    private class GetConnection implements Callable<Socket>{
//        
//        final int port;
//
//        public GetConnection(int port) {
//            this.port = port;
//        }
//
//        @Override
//        public Socket call() throws Exception {
//            final Socket socket = new ServerSocket(port).accept();
//            final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),Charset.defaultCharset()));
//            writer.write("Welcome Player!\r\n The game will start soon ...\r\n");
//            writer.flush();
//            return socket;
//        }
//        
//    }
    
    private class GetUserInput implements Callable<Integer>{
        
        final List<Integer> chooseRange;

        final BufferedWriter writer;
        
        final BufferedReader reader;

        public GetUserInput(List<Integer> chooseRange, BufferedWriter bufOut, BufferedReader bufIn) {
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
