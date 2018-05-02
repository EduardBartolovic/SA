package edu.hm.bartolov.a03_undercut.gamerules;

/**
 * default undercut game rules.
 * @author Edo
 */
public class DefaultGameRules implements GameRule{
    
    @Override
    public int[] calculateScore(int playerAChoice, int playerBChoice) {

        final int[] scores = new int[2]; // on position 0 is player A on 1 is player B
        if(playerAChoice == playerBChoice - 1) {
            scores[0] += playerAChoice + playerBChoice;
        } else if(playerBChoice == playerAChoice - 1) {
            scores[1] += playerAChoice + playerBChoice;
        } else {
            scores[0] += playerAChoice;
            scores[1] += playerBChoice;
        }
           
        return scores;
    }

    
    
}
