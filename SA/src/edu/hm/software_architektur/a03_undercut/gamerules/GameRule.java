package edu.hm.software_architektur.a03_undercut.gamerules;

import edu.hm.software_architektur.a03_undercut.Factory;

/**
 *
 * @author Felix Peither, Eduard Bartolovic
 */
public interface GameRule {
    
    static GameRule make(String specification) throws ReflectiveOperationException {
        return Factory.<GameRule>make(specification);
    }
    
    int[] calculateScore(int playerAChoice, int playerBChoice);
    
    
}
