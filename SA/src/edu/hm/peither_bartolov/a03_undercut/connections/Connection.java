package edu.hm.peither_bartolov.a03_undercut.connections;

import edu.hm.peither_bartolov.a03_undercut.Factory;
import java.io.IOException;
import java.util.List;

/**
 * this class is the interface between the main program and the outer world.
 * @author Felix, Eduard
 */
public interface Connection {
    
    /**
     * produces a Connection.
     * @param specification what kind of connection is used
     * @return a Connection
     * @throws ReflectiveOperationException 
     */
    static Connection make(String specification) throws ReflectiveOperationException {
        return Factory.<Connection>make(specification);
    }
    
    /**
     * starting outside connection.
     * @throws IOException if the connection can not be opened
     */
    void openConnection() throws IOException; 
    
    /**
     * get Input from User A.
     * @param chooseRange which numbers the user can choose from
     * @return the input from user A
     * @throws IOException if the user input is not valid
     */
    int getUserInputA(List<Integer> chooseRange) throws IOException;
    
    /**
     * get input from User B.
     * @param chooseRange which numbers the user can choose from
     * @return the input from user B
     * @throws IOException if the user input is not valid
     */
    int getUserInputB(List<Integer> chooseRange) throws IOException;
    
    /**
     * print game information to all players.
     * @param state state of the current game
     * @param round the current round
     * @param scoreA score of player A
     * @param scoreB score of player B
     * @throws java.io.IOException 
     */
    void printState(String state, int round, int scoreA , int scoreB) throws IOException;
    
}
