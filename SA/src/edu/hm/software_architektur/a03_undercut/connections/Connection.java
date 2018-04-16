package edu.hm.software_architektur.a03_undercut.connections;

import edu.hm.software_architektur.a03_undercut.Factory;
import java.io.IOException;
import java.util.List;

/**
 * this class is the interface between the main program and the outer world.
 * @author Felix, Eduard
 */
public interface Connection {
    
    /**
     * produces a Connection.
     * @param specification
     * @return a Connection
     * @throws ReflectiveOperationException 
     */
    static Connection make(String specification) throws ReflectiveOperationException {
        return Factory.<Connection>make(specification);
    }
    
    /**
     * starting outside connection.
     * @throws java.io.IOException
     */
    void openConnection() throws IOException; 
    
    /**
     * get Input from User A.
     * @param chooseRange
     * @return
     * @throws IOException 
     */
    int getUserInputA(List<Integer> chooseRange) throws IOException;
    
    /**
     * get input from User B.
     * @param chooseRange
     * @return
     * @throws IOException 
     */
    int getUserInputB(List<Integer> chooseRange) throws IOException;
    
    /**
     * print game information to all players.
     * @param state
     * @param round
     * @param scoreA
     * @param scoreB 
     * @throws java.io.IOException 
     */
    void printState(String state, int round, int scoreA , int scoreB) throws IOException;
    
}
