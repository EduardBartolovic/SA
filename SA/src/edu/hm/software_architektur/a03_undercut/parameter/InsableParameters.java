package edu.hm.software_architektur.a03_undercut.parameter;

/**
 *
 * @author Edo
 */
public class InsableParameters implements Parameters{
    /**
     * score to win
     */
    public static final int SCORETOWIN = 42;
    

    @Override
    public int getScoreToWin() {
        return SCORETOWIN;
    }

    @Override
    public int[] getChooseRange() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
