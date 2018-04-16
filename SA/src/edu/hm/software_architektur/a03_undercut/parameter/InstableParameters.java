package edu.hm.software_architektur.a03_undercut.parameter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Instabiles Spiel mit in jeder Runde reihum wechselnden Wahlmoeglichkeiten 1−4, 2−5, 1/3/5.
 * Spieler A beginnt mit 1−4, Spieler B mit 2−5.
 * Das Spiel endet, sobald ein Spieler 42 Punkte erreicht. 
 * @author Edo
 */
public class InstableParameters implements Parameters{
    /**
     * score to win.
     */
    public static final int SCORETOWIN = 42;
    
    /**
     * the first choose range 1,2,3,4.
     */
    private final List<Integer> chooseRangeOne = Arrays.asList(1,2,3,4);//new ArrayList<>();
    
    /**
     * the secont choose range 2,3,4,5.
     */
    private final List<Integer> chooseRangeTwo = Arrays.asList(2,3,4,5);
    
    /**
     * the third choose range 1/3/5.
     */
    private final List<Integer> chooseRangeThree = Arrays.asList(1,3,5);
    
    /**
     * for keeping track of how many turns there were.
     */
    private int roundCount = 0;
    
    private boolean playerATurn = true;
    
    @Override
    public int getScoreToWin() {
        return SCORETOWIN;
    }

    @Override
    public List<Integer> getChooseRange() {
        final List<Integer> retChooseRange;
        
        if(roundCount == 2){
            if(playerATurn){
                retChooseRange = chooseRangeThree;
            }else{
                retChooseRange = chooseRangeOne;
            }
        } else if(roundCount == 1){
            if(playerATurn){
                retChooseRange = chooseRangeTwo;
            }else{
                retChooseRange = chooseRangeThree;
            }
        } else {
            if(playerATurn){
                retChooseRange = chooseRangeOne;
            }else{
                retChooseRange = chooseRangeTwo;
            }
        }
        if(!playerATurn) // if both players made theire turn : next round
            roundCount++;
        
        if(roundCount>2) 
            roundCount = 0;
        
        playerATurn = !playerATurn;
        
        return Collections.unmodifiableList(retChooseRange);
    }

    
}
