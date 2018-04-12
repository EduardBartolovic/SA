package edu.hm.software_architektur.a03_undercut.parameter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Edo
 */
public class ShortGameParameters implements Parameters{

    /**
     * score needed to win a game.
     */
    public static final int SCORETOWIN = 12;
    /**
     * upper choose range
     */
    public static final int UPPERCHOOSE = 3;
    /**
     * lowerchooserange.
     */
    public static final int LOWERCHOOSE = 1;

    @Override
    public int getScoreToWin() {
        return SCORETOWIN;
    }

    @Override
    public List<Integer> getChooseRange() {
        final List<Integer> range = new ArrayList<>(UPPERCHOOSE);
        for(int counter = LOWERCHOOSE; counter <= UPPERCHOOSE;counter++){
            range.add(counter);
        }
        return Collections.unmodifiableList(range);
    }
    
}
