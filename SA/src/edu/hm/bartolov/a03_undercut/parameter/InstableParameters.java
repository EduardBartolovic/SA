package edu.hm.bartolov.a03_undercut.parameter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Instabiles Spiel mit in jeder Runde reihum wechselnden Wahlmoeglichkeiten 1-4, 2-5, 1/3/5.
 * Spieler A beginnt mit 1-4, Spieler B mit 2-5.
 * Das Spiel endet, sobald ein Spieler 42 Punkte erreicht. 
 * @author Eduard
 */
public class InstableParameters implements Parameters{
    /**
     * score to win.
     */
    public static final int SCORETOWIN = 42;
    
    /**
     * the first choose range 1,2,3,4.
     */
    private static final List<Integer> CHOOSERANGEONE = Arrays.asList(1,2,3,4);//new ArrayList<>();
    
    /**
     * the secont choose range 2,3,4,5.
     */
    private static final List<Integer> CHOOSERANGETWO = Arrays.asList(2,3,4,5);
    
    /**
     * the third choose range 1/3/5.
     */
    private static final List<Integer> CHOOSERANGETHREE = Arrays.asList(1,3,5);
    
    /**
     * specific turn will be saved to it.
     */
    private final List<List<Integer>> chooseRangeList;
        
    /**
     * for keeping track of how many turns there were.
     */
    private int roundCount;
    
    /**
     * filling the list in which all possible choose ranges are.
     */
    public InstableParameters() {
        chooseRangeList = new ArrayList<>();
        roundCount = 0;
        chooseRangeList.add(CHOOSERANGEONE);
        chooseRangeList.add(CHOOSERANGETWO);
        chooseRangeList.add(CHOOSERANGETWO);
        chooseRangeList.add(CHOOSERANGETHREE);
        chooseRangeList.add(CHOOSERANGETHREE);
        chooseRangeList.add(CHOOSERANGEONE);
    }
    
    @Override
    public int getScoreToWin() {
        return SCORETOWIN;
    }

    @Override
    public List<Integer> getChooseRange() {
        final List<Integer> retChooseRange = chooseRangeList.get(roundCount%(chooseRangeList.size()));
        
        roundCount++;
  
        return Collections.unmodifiableList(retChooseRange);
    }

    
}
