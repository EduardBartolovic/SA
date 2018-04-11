package edu.hm.software_architektur.a03_undercut.gamerules;

/**
 *
 * @author Edo
 */
public class DefaultGameRules implements GameRule{

    private int repeatedAnswerSame = 0;
    
    @Override
    public int[] calculateScore(int playerAChoice, int playerBChoice) {
        
        if(playerAChoice == playerBChoice){
            repeatedAnswerSame++;
        }else{
            repeatedAnswerSame = 0;
        }

        final int[] scores = new int[2]; // on position 0 is player A on 1 is player B
        if(repeatedAnswerSame > 2){ // when both users took the same number 3 times then tie
            scores[0] = -1;
        }else{
            if(playerAChoice == playerBChoice - 1)
                scores[0] += playerAChoice + playerBChoice;
            else if(playerBChoice == playerAChoice - 1)
                scores[1] += playerAChoice + playerBChoice;
            else {
                scores[0] += playerAChoice;
                scores[1] += playerBChoice;
            }
        }
           
        return scores;
    }

    
    
}
