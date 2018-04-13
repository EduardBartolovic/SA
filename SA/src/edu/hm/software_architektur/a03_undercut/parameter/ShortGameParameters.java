package edu.hm.software_architektur.a03_undercut.parameter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Kurzes Spiel mit Wahlmoeglichkeiten 1−3 (statt 1−5) und Sieg mit 12 Punkten (statt 40). 
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
        return Collections.unmodifiableList(Arrays.asList(1,2,3));
    }
    
}
