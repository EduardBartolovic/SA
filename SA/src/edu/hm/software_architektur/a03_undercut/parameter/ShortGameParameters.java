package edu.hm.software_architektur.a03_undercut.parameter;

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
    public int[] getChooseRange() {
        return new int[]{LOWERCHOOSE,UPPERCHOOSE};
    }
    
}
