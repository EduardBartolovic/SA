package edu.hm.software_architektur.a03_undercut.connections;

import java.io.IOException;

/**
 *
 * @author Edo
 */
public class MyConnection implements Connection{
    
    public MyConnection(){
    }

    @Override
    public void openConnection() {
        System.out.println("starting Game:");   
    }

    @Override
    public void printState(String state, int round, int scoreA , int scoreB) {
        // publish scores to both players
        System.out.println("State: "+state+", Round "+round+", Player A: "+scoreA+", Player B: "+ scoreB);
    }

    @Override
    public int getUserInputA(int[] chooseRange) throws IOException{
        System.out.println("Player A, your choice ("+chooseRange[0]+"-"+chooseRange[1]+")?");// to player A
        return getUserInput(chooseRange);
    }

    @Override
    public int getUserInputB(int[] chooseRange) throws IOException{
        
        System.out.println("Player B, your choice ("+chooseRange[0]+"-"+chooseRange[1]+")?"); // to player B
        return getUserInput(chooseRange);
    }
    
    private int getUserInput(int[] chooseRange)throws IOException{
        int playerChoice;
        // read players' choices; if invalid, discard and retry
        do {
            final int input = System.in.read();
            if(input < 0)
                throw new IOException(); // bomb out on end of input
            playerChoice = input - '0';
        }
        while(playerChoice < chooseRange[0] || playerChoice > chooseRange[1]);
        return playerChoice;
    }



    
}
