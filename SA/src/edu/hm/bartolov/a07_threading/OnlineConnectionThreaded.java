/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hm.bartolov.a07_threading;

import edu.hm.bartolov.a03_undercut.connections.Connection;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Computer
 */
public class OnlineConnectionThreaded implements Connection{

    @Override
    public void openConnection() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getUserInputA(List<Integer> chooseRange) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getUserInputB(List<Integer> chooseRange) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void printState(String state, int round, int scoreA, int scoreB) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
