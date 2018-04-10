package edu.hm.software_architektur.a03_undercut;

import edu.hm.software_architektur.a03_undercut.gamerules.GameRule;
import edu.hm.software_architektur.a03_undercut.connections.Connection;
import edu.hm.software_architektur.a03_undercut.parameter.Parameters;
import java.io.IOException;

/**
 *
 * @author Edo Felix
 */
public class MyUndercutMain {
    /**
     * Entry point.
     * @param args Commandline args: none.
     * @exception IOException on incomplete input.
     * @throws java.lang.ReflectiveOperationException
     */
    public static void main(String... args) throws IOException, ReflectiveOperationException {
        //final String connectionSpecification = "edu.hm.software_architektur.a03_undercut.connections.MyConnection()";
        final String connectionSpecification = "edu.hm.software_architektur.a03_undercut.connections.OnlineConnection()";
        
        final String gameSpecification = "edu.hm.software_architektur.a03_undercut.MyGame()";
        final String gameRuleSpecification = "edu.hm.software_architektur.a03_undercut.gamerules.MyGameRules()";
        
        //final String parameterSpecification = "edu.hm.software_architektur.a03_undercut.parameter.MyParameters()";
        final String parameterSpecification = "edu.hm.software_architektur.a03_undercut.parameter.ShortGameParameters()";
        
        final Connection connection = Connection.make(connectionSpecification);
        final Game game = Game.make(gameSpecification);
        final Parameters parameter = Parameters.make(parameterSpecification);
        final GameRule gameRule = GameRule.make(gameRuleSpecification);
        game.play(gameRule,parameter,connection);
        
    }
}
