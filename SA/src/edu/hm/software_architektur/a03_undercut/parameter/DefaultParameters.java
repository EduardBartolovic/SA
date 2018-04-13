
package edu.hm.software_architektur.a03_undercut.parameter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Edo
 */
public class DefaultParameters implements Parameters{

    /**
     * score needed to win a game.
     */
    public static final int SCORETOWIN = 40;
    
    @Override
    public int getScoreToWin() {
        return SCORETOWIN;
    }

    @Override
    public List<Integer> getChooseRange () {
        return Collections.unmodifiableList(Arrays.asList(1,2,3,4,5));
    }


    
}
