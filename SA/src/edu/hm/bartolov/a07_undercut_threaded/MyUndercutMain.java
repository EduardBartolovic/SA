package edu.hm.bartolov.a07_undercut_threaded;


import edu.hm.bartolov.a03_undercut.gamerules.GameRule;
import edu.hm.bartolov.a03_undercut.parameter.Parameters;
import edu.hm.bartolov.a07_undercut_threaded.connections.Connection;
import edu.hm.bartolov.a07_undercut_threaded.connections.OnlineConnectionThreaded;
import java.io.IOException;

/**
 * The main method, so we can play a game of undercut.
 * @author Eduard Bartolovic, Felix Peither
 */
public class MyUndercutMain {
    /**
     * Entry point.
     * @param args Commandline args: none.
     * @exception IOException on incomplete input.
     * @exception ReflectiveOperationException if a build failuer occurs.
     */
    public static void main(String... args) throws IOException, ReflectiveOperationException {
        
        //final String gameSpecification = args[0];
        final String gameSpecification = "edu.hm.bartolov.a07_undercut_threaded.MyGame()";
        
        //final String connectionSpecification = args[1];
        //final String connectionSpecification = "edu.hm.bartolov.a07_undercut_threaded.connections.ConsoleConnection()";
//      final String connectionSpecification = "edu.hm.bartolov.a07_undercut_threaded.connections.OnlineConnection()";
//        final String connectionSpecification = "edu.hm.bartolov.a07_undercut_threaded.connections.FileReadConnection()";
        
//final String connectionSpecification = "edu.hm.bartolov.a07_undercut_threaded.connections.OnlineConnectionThreaded()";
         

        //final String gameRuleSpecification = args[2];
//        final String gameRuleSpecification = "edu.hm.bartolov.a03_undercut.gamerules.DefaultGameRules()";
//        final String gameRuleSpecification = "edu.hm.bartolov.a03_undercut.gamerules.ChoiceDifferenceGameRule()";
        final String gameRuleSpecification = "edu.hm.bartolov.a03_undercut.gamerules.PotGameRule()";
        
        //final String parameterSpecification = args[3];
        final String parameterSpecification = "edu.hm.bartolov.a03_undercut.parameter.DefaultParameters()";
//        final String parameterSpecification = "edu.hm.bartolov.a03_undercut.parameter.ShortGameParameters()";
//        final String parameterSpecification = "edu.hm.bartolov.a03_undercut.parameter.InstableParameters()";
        
        //final Connection connection = Connection.make(connectionSpecification);
        final Connection connection = new OnlineConnectionThreaded();
        
        //final Game game = Game.make(gameSpecification);
        final Game game = new MyGameDeluxe();
        final Parameters parameter = Parameters.make(parameterSpecification);
        final GameRule gameRule = GameRule.make(gameRuleSpecification);

        game.play(gameRule,parameter,connection);

//        System.out.println(Integer.parseInt("23"));
    }
}
