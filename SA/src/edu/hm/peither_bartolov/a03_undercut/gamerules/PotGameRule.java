package edu.hm.peither_bartolov.a03_undercut.gamerules;

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
    private int repeatedAnswerSame;
    /**
     * this is the winning pot.
     */
    private int pot;

    /**
     * Constructor.
     */
    public PotGameRule() {
        pot = 0;
        repeatedAnswerSame = 0;
    }
    
    @Override
    public int[] calculateScore(int playerAChoice, int playerBChoice) {
        final int[] scores = new int[2]; // on position 0 is player A on 1 is player B
        if(playerAChoice == playerBChoice){
            repeatedAnswerSame++;
        }else{ 
            repeatedAnswerSame = 0;
        }
        if(repeatedAnswerSame > 3){ // when both users took the same number 4 times then tie
            scores[0] = -1;
        }else{
            final int[] newScores = getNewScores(scores[0], scores[1], playerAChoice, playerBChoice);
            scores[0] = newScores[0];
            scores[1] = newScores[1];  
        }
        return scores;
    }
    
    /**
     * Calculates the new scores of A and B.
     * @param oldA current score of A
     * @param oldB current score of B
     * @param choiceA choice of A
     * @param choiceB choice of B
     * @return new scores in an int[]
     */
    private int[] getNewScores(int oldA, int oldB, int choiceA, int choiceB) {
        int newA = oldA;
        int newB = oldB; 
        if(choiceA == choiceB - 1){
            newA += choiceA + choiceB + pot;
            pot = 0; 
        }else if(choiceB == choiceA - 1){
            newB += choiceA + choiceB + pot;
            pot = 0;
        }else if(choiceA == choiceB){
            pot += choiceA+choiceB;
        } else {
            newA += choiceA;
            newB += choiceB;
        }
        return new int[]{newA, newB};
    }
    
}
