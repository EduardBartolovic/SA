package edu.hm.bartolov.a03_undercut;

import edu.hm.bartolov.a03_undercut.gamerules.GameRule;
import edu.hm.bartolov.a03_undercut.connections.Connection;
import edu.hm.bartolov.a03_undercut.parameter.Parameters;
import java.io.IOException;

/**
 * the game that is played.
 * @author Edo
 */
public class MyGame implements Game{
    
    /**
     * state of the game.
     */
    private String state;
    
    /**
     * score of player A.
     */
    private int scoreA;
    
    /**
     * score of player B.
     */
    private int scoreB;
    
    /**
     * the current round.
     */
    private int round;

    /**
     * constructor.
     */
    public MyGame() {
        scoreA = 0;
        scoreB = 0;
        round = 0;
        state = "running";
    }
    
    @Override
    public void play(GameRule gameRule, Parameters parameter, Connection connection) throws IOException {
        connection.openConnection();
        
        while("running".equals(state)) {
            final int playerAChoice = connection.getUserInputA(parameter.getChooseRange());

            final int playerBChoice = connection.getUserInputB(parameter.getChooseRange());

            final int[] scores = gameRule.calculateScore(playerAChoice, playerBChoice);
            if(scores[0]<0){ // if the first value is negativ => player choose 3 times the same number => tie
                state = "tie";
            }else{
                scoreA += scores[0];
                scoreB += scores[1];

                if(scoreA >= parameter.getScoreToWin() && scoreB >= parameter.getScoreToWin()){
                    state = "tie";
                }else if(scoreA >= parameter.getScoreToWin()){ //winning criteria
                    state = "A won";
                }else if(scoreB >= parameter.getScoreToWin()){
                    state = "B won";
                } 
            }
            
            round++;
            connection.printState(state,round,scoreA,scoreB);
        }
 
    }
    
}
