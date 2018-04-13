package edu.hm.software_architektur.a03_undercut.parameter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Edo
 */
public class InstableParameters implements Parameters{
    /**
     * score to win
     */
    public static final int SCORETOWIN = 42;
    
    /**
     * the first choose range 1,2,3,4
     */
    private final List<Integer> chooseRangeOne = Arrays.asList(1,2,3,4);//new ArrayList<>();
    
    /**
     * the secont choose range 2,3,4,5
     */
    private final List<Integer> chooseRangeTwo = Arrays.asList(2,3,4,5);
    
    /**
     * the third choose range 1/3/5
     */
    private final List<Integer> chooseRangeThree = Arrays.asList(1,3,5);
    
    /**
     * for keeping track of how many turns there were
     */
    private int turnCount = 0;
    
    @Override
    public int getScoreToWin() {
        return SCORETOWIN;
    }

    @Override
    public List<Integer> getChooseRange() {
        final List<Integer> retChooseRange;
        if (turnCount%3==0) {
            retChooseRange = chooseRangeThree;
        } else if (turnCount%2==0) {
            retChooseRange = chooseRangeTwo;
        } else {
            retChooseRange = chooseRangeOne;
        }
        turnCount++;
        return Collections.unmodifiableList(retChooseRange);
    }

    
}
