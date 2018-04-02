/* (C) 2018, R. Schiedermeier, rs@cs.hm.edu
 * Java 1.8.0_121, Linux x86_64 4.14.12
 * violet (Intel Core i7 CPU 920/2.67GHz, 8 cores, 2668 MHz, 24128 MByte RAM)
 **/
package edu.hm.cs.rs.arch18.a02_staticanalyzer.demo;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Startet ein anderes Programm, faengt dessen Konsolenausgabe in ein und gibt sie aus.
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2018-03-21
 */
public class ProcessRunner {
    /**
     * Entry point.
     * @param args Programmname und Kommandozeilenargumente.
     * @exception IOException bei einem Fehler im Filesystem.
     * @exception InterruptedException bei einer Unterbrechung des Prozesses.
     */
    public static void main(String... args) throws IOException, InterruptedException {
        System.out.println(runProgram(args));
    }

    /**
     * Startet ein anderes Programm und liefert dessen Konsolenausgabe (out und err) zurueck.
     * @param command Programmname und Kommandozeilenargumente.
     * @return Ausgabe des Programms.
     * @exception IOException bei einem Fehler im Filesystem.
     * @exception InterruptedException bei einer Unterbrechung des Prozesses.
     */
    static String runProgram(String... command) throws IOException, InterruptedException {
        final Process process = new ProcessBuilder(command)
        .redirectErrorStream(true)
        .start();
        final List<String> output = new ArrayList<>();
        try(InputStream inputStream = process.getInputStream();
            Reader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader)) {
            final Thread collector = new Thread(() -> bufferedReader.lines().forEach(output::add));
            collector.start();
            if(process.waitFor() != 0)
                throw new IOException("process failed");
            collector.join();
        }
        return output.stream().collect(Collectors.joining("\n"));
    }

}
