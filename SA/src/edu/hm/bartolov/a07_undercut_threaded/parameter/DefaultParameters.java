package edu.hm.bartolov.a07_undercut_threaded.parameter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * standart undercut parameter.
 * @author Edo
 */
public class DefaultParameters implements Parameters{

    /**
     * score needed to win a game.
     */
    public static final int SCORETOWIN = 40;
    
    /**
     * the chooserange.
     */
    private static final List<Integer> CHOOSERANGE = Arrays.asList(1,2,3,4,5);
    
    @Override
    public int getScoreToWin() {
        return SCORETOWIN;
    }

    @Override
    public List<Integer> getChooseRange () {
        return Collections.unmodifiableList(CHOOSERANGE);
    }


    
}
