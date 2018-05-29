package edu.hm.bartolov.a07_undercut_threaded.parameter;

import edu.hm.bartolov.a07_undercut_threaded.Factory;
import java.util.List;

/**
 * Interface for all parameter classes.
 * @author Felix Peither, Eduard Bartolovic
 */
public interface Parameters {
    /**
     * factory method.
     * @param specification which parameters are used
     * @return Parameters
     * @throws ReflectiveOperationException 
     */
    static Parameters make(String specification) throws ReflectiveOperationException {
        return Factory.<Parameters>make(Parameters.class,specification);
    }
    
    /**
     * score needed to win.
     * @return scoreToWin
     */
    int getScoreToWin();
    
    /**
     * range of choices.
     * @return List of Integer
     */
    List<Integer> getChooseRange();
}
