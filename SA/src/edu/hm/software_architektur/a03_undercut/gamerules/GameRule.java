package edu.hm.software_architektur.a03_undercut.gamerules;

import edu.hm.software_architektur.a03_undercut.Factory;

/**
 *
 * @author Felix Peither, Eduard Bartolovic
 */
public interface GameRule {
    
    /**
     * factory methode.
     * @param specification
     * @return GameRule
     * @throws ReflectiveOperationException 
     */
    static GameRule make(String specification) throws ReflectiveOperationException {
        return Factory.<GameRule>make(specification);
    }
    
    /**
     * calculating scores for each player.
     * @param playerAChoice
     * @param playerBChoice
     * @return scores of this round. if negativ the game will end in a tie.
     */
    int[] calculateScore(int playerAChoice, int playerBChoice);
    
    
}
