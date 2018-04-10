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
    
    private GameRule gameRule;
    
    private Parameters parameter;
    
    private Connection connection;
    
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
        this.parameter = parameter;
        this.gameRule = gameRule;
        this.connection = connection;
        
        connection.openConnection();
        
        while(state.equals("running")) {
            int playerAChoice = connection.getUserInputA(parameter.getChooseRange());

            int playerBChoice = connection.getUserInputB(parameter.getChooseRange());

            // update scores
            if(playerAChoice == playerBChoice - 1)
                scoreA += playerAChoice + playerBChoice;
            else if(playerBChoice == playerAChoice - 1)
                scoreB += playerAChoice + playerBChoice;
            else {
                scoreA += playerAChoice;
                scoreB += playerBChoice;
            }
            round++;
                
            if(scoreA >= parameter.getScoreToWin()){
                state = "A won";
            }else if(scoreB >= parameter.getScoreToWin()){
                state = "B won";
            }
            connection.printState(state,round,scoreA,scoreB);
        }
 
    }
    
}
