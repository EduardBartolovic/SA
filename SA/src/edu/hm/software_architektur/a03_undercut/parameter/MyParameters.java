
package edu.hm.software_architektur.a03_undercut.parameter;

/**
 *
 * @author Edo
 */
public class MyParameters implements Parameters{

    public static final int SCORETOWIN = 40;
    
    public static final int UPPERCHOOSE = 5;
    
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
