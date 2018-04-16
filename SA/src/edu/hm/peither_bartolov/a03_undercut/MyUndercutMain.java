package edu.hm.peither_bartolov.a03_undercut;

import edu.hm.peither_bartolov.a03_undercut.gamerules.GameRule;
import edu.hm.peither_bartolov.a03_undercut.connections.Connection;
import edu.hm.peither_bartolov.a03_undercut.parameter.Parameters;
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
        
        //final String gameSpecification = args[0];
        final String gameSpecification = "edu.hm.peither_bartolov.a03_undercut.MyGame()";
        
        //final String connectionSpecification = args[1];
        final String connectionSpecification = "edu.hm.peither_bartolov.a03_undercut.connections.ConsoleConnection()";
//      final String connectionSpecification = "edu.hm.peither_bartolov.a03_undercut.connections.OnlineConnection()";
        //final String connectionSpecification = "edu.hm.peither_bartolov.a03_undercut.connections.FileReadConnection()";
    
        //final String gameRuleSpecification = args[2];
//        final String gameRuleSpecification = "edu.hm.peither_bartolov.a03_undercut.gamerules.DefaultGameRules()";
//        final String gameRuleSpecification = "edu.hm.peither_bartolov.a03_undercut.gamerules.ChoiceDifferenceGameRule()";
        final String gameRuleSpecification = "edu.hm.peither_bartolov.a03_undercut.gamerules.PotGameRule()";
        
        //final String parameterSpecification = args[3];
//        final String parameterSpecification = "edu.hm.peither_bartolov.a03_undercut.parameter.DefaultParameters()";
        final String parameterSpecification = "edu.hm.peither_bartolov.a03_undercut.parameter.ShortGameParameters()";
//        final String parameterSpecification = "edu.hm.peither_bartolov.a03_undercut.parameter.InstableParameters()";
        
        final Connection connection = Connection.make(connectionSpecification);
        final Game game = Game.make(gameSpecification);
        final Parameters parameter = Parameters.make(parameterSpecification);
        final GameRule gameRule = GameRule.make(gameRuleSpecification);

        game.play(gameRule,parameter,connection);

//        System.out.println(Integer.parseInt("23"));
    }
}
