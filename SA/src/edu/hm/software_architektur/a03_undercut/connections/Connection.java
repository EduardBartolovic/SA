package edu.hm.software_architektur.a03_undercut.connections;

import edu.hm.software_architektur.a03_undercut.Factory;
import java.io.IOException;


public interface Connection {
    
    /**
     * produces a Connection.
     * @param specification
     * @return
     * @throws ReflectiveOperationException 
     */
    static Connection make(String specification) throws ReflectiveOperationException {
        return Factory.<Connection>make(specification);
    }
    
    /**
     * starting outside connection.
     */
    void openConnection(); 
    
    /**
     * get Input from User A.
     * @param chooseRange
     * @return
     * @throws IOException 
     */
    int getUserInputA(int[] chooseRange) throws IOException;
    
    /**
     * get input from User B.
     * @param chooseRange
     * @return
     * @throws IOException 
     */
    int getUserInputB(int[] chooseRange) throws IOException;
    
    /**
     * print game information to all players.
     * @param state
     * @param round
     * @param scoreA
     * @param scoreB 
     */
    void printState(String state, int round, int scoreA , int scoreB);
    
}
