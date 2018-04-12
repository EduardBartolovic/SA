
package edu.hm.software_architektur.a03_undercut.parameter;

import edu.hm.software_architektur.a03_undercut.Factory;
import java.util.List;

/**
 *
 * @author Felix Peither, Eduard Bartolovic
 */
public interface Parameters {
    /**
     * factoty method
     * @param specification
     * @return Parameters
     * @throws ReflectiveOperationException 
     */
    static Parameters make(String specification) throws ReflectiveOperationException {
        return Factory.<Parameters>make(specification);
    }
    
    /**
     * score needed to win.
     * @return scoreToWin
     */
    int getScoreToWin();
    
    /**
     * range of choices.
     * @return List<Integer>  
     */
    List<Integer> getChooseRange();
}
