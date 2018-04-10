package edu.hm.software_architektur.a03_undercut;

import edu.hm.software_architektur.a03_undercut.gamerules.GameRule;
import edu.hm.software_architektur.a03_undercut.connections.Connection;
import edu.hm.software_architektur.a03_undercut.parameter.Parameters;
import java.io.IOException;

/**
 *
 * @author Edo
 */
public class MyGame implements Game{
    
    private String state;
    
    private int scoreA;
    
    private int scoreB;
    
    private int round;

    public MyGame() {
        scoreA = 0;
        scoreB = 0;
        round = 0;
        state = "running";
    }
    
    @Override
    public void play(GameRule gameRule, Parameters parameter, Connection connection) throws IOException {
        connection.openConnection();
        
        int repeatedAnswerSame = 0;
        while(state.equals("running")) {
            final int playerAChoice = connection.getUserInputA(parameter.getChooseRange());

            final int playerBChoice = connection.getUserInputB(parameter.getChooseRange());
            
            if(playerAChoice == playerBChoice){
                repeatedAnswerSame++;
            }else{
                repeatedAnswerSame = 0;
            }
            
            if(repeatedAnswerSame > 2){ // when both users took the same number 3 times then tie
                state = "tie"; 
            }else{
                
                // update scores
                if(playerAChoice == playerBChoice - 1)
                    scoreA += playerAChoice + playerBChoice;
                else if(playerBChoice == playerAChoice - 1)
                    scoreB += playerAChoice + playerBChoice;
                else {
                    scoreA += playerAChoice;
                    scoreB += playerBChoice;
                } // need to be changed for game rules.++++++++++++++++++++++++++++++++++++++++++
            
            
                round++;
            }
                
            if(scoreA >= parameter.getScoreToWin()){ //winning criteria
                state = "A won";
            }else if(scoreB >= parameter.getScoreToWin()){
                state = "B won";
            }
            
            connection.printState(state,round,scoreA,scoreB);
        }
 
    }
    
}
