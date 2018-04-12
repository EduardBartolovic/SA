/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hm.software_architektur.a03_undercut.connections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author Computer
 */
public class FileReadConnection implements Connection{
    
    private BufferedReader fileReader;
    
    private BufferedWriter fileWriter;
    
    // C:\Users\Computer\AppData\Local\Temp\
    
    private final Path filesPath = Paths.get((System.getProperty("java.io.tmpdir")));
    
    private final Path inputFilePath = Paths.get(filesPath.toString() + "\\undercut.in.txt");
    
    private final Path outputFilePath = Paths.get(filesPath.toString() + "\\undercut.out.txt");

    @Override
    public void openConnection() throws IOException {
        fileReader = new BufferedReader(new FileReader(inputFilePath.toFile()));//inputFilePath.toFile());
        fileWriter = new BufferedWriter(new FileWriter(outputFilePath.toFile()));//outputFilePath.toFile());
    }

    @Override
    public int getUserInputA(List<Integer> chooseRange) throws IOException {
        return getUserInput(fileReader.readLine(), chooseRange);
        //return choice;
    }

    @Override
    public int getUserInputB(List<Integer> chooseRange) throws IOException {
        return getUserInput(fileReader.readLine(), chooseRange);
        //return choice;
    }
    
    private int getUserInput(String number, List<Integer> chooseRange) throws IOException{
        int choice = -1;
        try {
            choice = Integer.parseInt(number);
        } catch (java.lang.NumberFormatException nfe) {
        
        }
        if (!chooseRange.contains(choice)) {
            throw new IOException("This: " + number + ". is no valid number!");
        }
        return choice;
    }

    @Override
    public void printState(String state, int round, int scoreA, int scoreB) throws IOException {
        fileWriter.write("State: "+state+", Round "+round+", Player A: "+scoreA+", Player B: "+ scoreB);
        fileWriter.flush();
    }
    
}
