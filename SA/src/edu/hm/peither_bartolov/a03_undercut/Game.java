package edu.hm.peither_bartolov.a03_undercut;

import edu.hm.peither_bartolov.a03_undercut.gamerules.GameRule;
import edu.hm.peither_bartolov.a03_undercut.connections.Connection;
import edu.hm.peither_bartolov.a03_undercut.parameter.Parameters;
import java.io.IOException;

/**
 *
 * @author Edo
 */
public interface Game {
    /**
     * factory method.
     * @param specification
     * @return a Game
     * @throws ReflectiveOperationException 
     */
    static Game make(String specification) throws ReflectiveOperationException {
        return Factory.<Game>make(specification);
    }
    
    /**
     * 
     * @param gameRule
     * @param parameter
     * @param connection
     * @throws IOException 
     */
    void play(GameRule gameRule, Parameters parameter, Connection connection) throws IOException;
    
}
