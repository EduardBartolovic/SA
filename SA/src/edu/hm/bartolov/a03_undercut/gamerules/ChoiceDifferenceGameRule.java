package edu.hm.bartolov.a03_undercut.gamerules;

/**
 * Wenn die gewaehlten Punkte 2 oder mehr auseinander liegen,
 * erhaelt der Spieler mit der hoeheren Zahl die Summe der Punkte (statt jeder Spieler seine Wahl). 
 * @author Felix Peither, Eduard Bartolovic
 */
public class ChoiceDifferenceGameRule implements GameRule{

    @Override
    public int[] calculateScore(int playerAChoice, int playerBChoice) {
        final int[] scores = new int[2]; // int[0] score of player A, int[1] score of player B
        
        if(playerAChoice == playerBChoice - 1) {             //player b one more point
            scores[0] += playerAChoice + playerBChoice;
        } else if(playerBChoice == playerAChoice - 1) {     // player a one more point
            scores[1] += playerAChoice + playerBChoice;
        } else if (playerAChoice - playerBChoice > 1) {  // player b has more than 1 point difference
            scores[0] += playerAChoice + playerBChoice;
        } else if (playerBChoice - playerAChoice > 1) { // player a has more than 1 point difference
            scores[1] += playerAChoice + playerBChoice;
        }else{                                              // both player have the same score
            scores[0] += playerAChoice;
            scores[1] += playerBChoice;
        }
        return scores;
    }
    
}
