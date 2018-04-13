package edu.hm.software_architektur.a03_undercut.gamerules;

/**
 * Wenn beide Spieler die gleiche Zahl waehlen, kommen diese Punkte in einen Topf und
 * die Spieler erhalten vorerst nichts (statt jeder Spieler seine Wahl).
 * Der Gewinner des nächsten Undercut (1 unter dem Gegner) erhaelt den Inhalt des Topfes dazu.
 * Wenn die Spieler mehr als dreimal nacheinander die gleiche Wahl treffen, endet das Spiel unentschieden. 
 * @author Edo
 */
public class PotGameRule implements GameRule{

    /**
     * counter to see if answers where the same over multiple rounds.
     */
    private int repeatedAnswerSame = 0;
    /**
     * this is the winning pot.
     */
    private int pot = 0;
    
    @Override
    public int[] calculateScore(int playerAChoice, int playerBChoice) {
        if(playerAChoice == playerBChoice){
            repeatedAnswerSame++;
        }else{
            repeatedAnswerSame = 0;
        }

        final int[] scores = new int[2]; // on position 0 is player A on 1 is player B
        if(repeatedAnswerSame > 3){ // when both users took the same number 4 times then tie
            scores[0] = -1;
        }else{
            if(playerAChoice == playerBChoice - 1){
                scores[0] += playerAChoice + playerBChoice + pot;
                pot = 0; 
            }else if(playerBChoice == playerAChoice - 1){
                scores[1] += playerAChoice + playerBChoice + pot;
                pot = 0;
            }else if(playerAChoice == playerBChoice){
                pot += playerAChoice+playerBChoice;
            } else {
                scores[0] += playerAChoice;
                scores[1] += playerBChoice;
            }
        }
           
        return scores;
    }
    
}
