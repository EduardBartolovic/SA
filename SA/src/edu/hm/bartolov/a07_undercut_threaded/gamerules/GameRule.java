package edu.hm.bartolov.a07_undercut_threaded.gamerules;

import edu.hm.bartolov.a03_undercut.Factory;

/**
 * Interface for all game Rules.
 * @author Felix Peither, Eduard Bartolovic
 */
public interface GameRule {
    
    /**
     * factory methode.
     * @param specification which rule set is used
     * @return GameRule the rule(s) for a game
     * @throws ReflectiveOperationException 
     */
    static GameRule make(String specification) throws ReflectiveOperationException {
        return Factory.<GameRule>make(GameRule.class,specification);
    }
    
    /**
     * calculating scores for each player.
     * @param playerAChoice the choice of player A
     * @param playerBChoice the choice of player B
     * @return scores of this round. if negativ the game will end in a tie.
     */
    int[] calculateScore(int playerAChoice, int playerBChoice);
    
    
}
