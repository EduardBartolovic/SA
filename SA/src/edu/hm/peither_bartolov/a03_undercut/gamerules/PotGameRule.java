package edu.hm.peither_bartolov.a03_undercut.gamerules;

/**
 * Wenn beide Spieler die gleiche Zahl waehlen, kommen diese Punkte in einen Topf und
 * die Spieler erhalten vorerst nichts (statt jeder Spieler seine Wahl).
 * Der Gewinner des nächsten Undercut (1 unter dem Gegner) erhaelt den Inhalt des Topfes dazu.
 * Wenn die Spieler mehr als dreimal nacheinander die gleiche Wahl treffen, endet das Spiel unentschieden. 
 * @author Eduard Bartolovic
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
        if(playerAChoice == playerBChoice){
            repeatedAnswerSame++;
        }else{ 
            repeatedAnswerSame = 0;
        }
        
        int[] scores = new int[2]; // on position 0 is player A on 1 is player B
        
        if(repeatedAnswerSame > 3){ // when both users took the same number 4 times then tie
            scores[0] = -1;
        }else{
            scores = getScores(playerAChoice, playerBChoice); 
        }
        return scores;
    }
    
    /**
     * Calculates the scores of A and B and the new content for the pot.
     * @param choiceA choice of A
     * @param choiceB choice of B
     * @return new scores in an int[]
     */
    private int[] getScores( int choiceA, int choiceB) {
        int scoreA = 0;
        int scoreB = 0; 
        if(choiceA == choiceB - 1){ // player a won 
            scoreA = choiceA + choiceB + pot;
            pot = 0; 
        }else if(choiceB == choiceA - 1){ // player b won
            scoreB = choiceA + choiceB + pot;
            pot = 0;
        }else if(choiceA == choiceB){ // nobody won
            pot += choiceA+choiceB;
        } else { 
            scoreA = choiceA;
            scoreB = choiceB;
        }
        return new int[]{scoreA, scoreB};
    }
    
}
