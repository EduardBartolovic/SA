package edu.hm.software_architektur.a03_undercut.connections;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author Edo
 */
public class ConsoleConnection implements Connection{
    
    @Override
    public void openConnection() {
        System.out.println("starting Game:");   
    }

    @Override
    public void printState(String state, int round, int scoreA , int scoreB) {
        System.out.println("State: "+state+", Round "+round+", Player A: "+scoreA+", Player B: "+ scoreB);// publish scores to both players
    }

    @Override
    public int getUserInputA(List<Integer> chooseRange) throws IOException{
        System.out.print("Player A, you can choose:"+chooseRange);// to player A
        return getUserInput(chooseRange);
    }

    @Override
    public int getUserInputB(List<Integer> chooseRange) throws IOException{
        System.out.print("Player B, you can choose:"+chooseRange); // to player B
        return getUserInput(chooseRange);
    }
    
    private int getUserInput(List<Integer> chooseRange)throws IOException{
        int playerChoice;
        // read players' choices; if invalid, discard and retry
        do {
            final int input = System.in.read();
            if(input < 0)
                throw new IOException(); // bomb out on end of input
            playerChoice = input - '0';
        } while(!chooseRange.contains(playerChoice));
        return playerChoice;
    }



    
}
