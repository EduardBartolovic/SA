package edu.hm.software_architektur.a03_undercut.parameter;

/**
 *
 * @author Edo
 */
public class ShortGameParameters implements Parameters{

    public static final int SCORETOWIN = 12;
    
    public static final int UPPERCHOOSE = 3;
    
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
