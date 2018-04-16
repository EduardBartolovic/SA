/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hm.software_architektur.a03_undercut.connections;

import edu.hm.peither_bartolov.a03_undercut.connections.ConsoleConnection;
import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Edo
 */
public class ConsoleConnectionTest {
    
    public ConsoleConnectionTest() {
    }

    @Test(timeout = 1000)
    public void testOpenConnection1() throws IOException {
        final ConsoleConnection sut = new ConsoleConnection();
        
        assertEquals("starting Game:",executeopenConnection(sut));
        
    }
    
    @Test(timeout = 1000)
    public void testOpenConnection2() throws IOException {
        final ConsoleConnection sut = new ConsoleConnection();
        
        assertEquals("starting Game:",executeopenConnection(sut));
    }
    
    private static String executeopenConnection(ConsoleConnection sut) throws IOException {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(baos);
            System.setOut(printStream);
            sut.openConnection();
            final String result = baos.toString().trim();
            System.out.flush();
            return result;
        } finally {
            System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        }
    }
    
    private static String executeUserInputA(ConsoleConnection sut, int[] chooseRange, int choice) throws IOException {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(baos);
            System.setOut(printStream);
            //sut.getUserInputA(chooseRange);
            final String result = baos.toString().trim();
            System.out.flush();
            return result;
        } finally {
            System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        }
    }
    private static String executeUserInputB(ConsoleConnection sut, int[] chooseRange, int choice) throws IOException {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(baos);
            System.setOut(printStream);
            //sut.getUserInputB(chooseRange);
            final String result = baos.toString().trim();
            System.out.flush();
            return result;
        } finally {
            System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        }
    }
}
