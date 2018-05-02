package edu.hm.bartolov.a03_undercut;

import edu.hm.bartolov.a03_undercut.gamerules.GameRule;
import edu.hm.bartolov.a03_undercut.connections.Connection;
import edu.hm.bartolov.a03_undercut.parameter.Parameters;
import java.io.IOException;

/**
 * Interface for the game itself.
 * @author Edo
 */
public interface Game {
    /**
     * factory method.
     * @param specification specification for the game
     * @return a Game
     * @throws ReflectiveOperationException 
     */
    static Game make(String specification) throws ReflectiveOperationException {
        return Factory.<Game>make(Game.class, specification);
    }
    
    /**
     * starts the game with given specifications.
     * @param gameRule rule(s) for the game
     * @param parameter parameters for the game
     * @param connection connection for the game
     * @throws IOException 
     */
    void play(GameRule gameRule, Parameters parameter, Connection connection) throws IOException;
    
}
