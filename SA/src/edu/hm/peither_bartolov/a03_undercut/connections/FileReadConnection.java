package edu.hm.peither_bartolov.a03_undercut.connections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.imageio.IIOException;

/**
 * Das Programm liest die Eingaben aus einem Textfile (statt von der Tastatur) 
 * und schreibt die Ausgaben auf ein anderes Textfile (statt auf den Bildschirm).
 * Die voreingestellten Files sind undercut.in.txt und undercut.out.txt, 
 * beide im systemweiten Directory für temporäre Files (Systemproperty java.io.tmpdir). 
 * @author Eduard Bartolovic, Felix Peither
 */
public class FileReadConnection implements Connection{
    
    /**
     * bufferedReader to read file.
     */
    private BufferedReader fileReader;
    
    /**
     * bufferedWriter to write file.
     */
    private BufferedWriter fileWriter;
    
    /**
     * Path to the java tmp directory.
     */
    private final Path filesPath = Paths.get(System.getProperty("java.io.tmpdir"));
    
    /**
     * Path of file to read its choices.
     */
    private final Path inputFilePath = Paths.get(filesPath.toString() + "\\undercut.in.txt");
    
    /**
     * Path of file to write the round information.
     */
    private final Path outputFilePath = Paths.get(filesPath.toString() + "\\undercut.out.txt");

    @Override
    public void openConnection() throws IOException {
        fileReader = new BufferedReader(new FileReader(inputFilePath.toFile()));
        fileWriter = new BufferedWriter(new FileWriter(outputFilePath.toFile()));
        fileWriter.write("");
    }

    @Override
    public int getUserInputA(List<Integer> chooseRange) throws IOException {
        return getUserInput(fileReader.readLine(), chooseRange);
    }

    @Override
    public int getUserInputB(List<Integer> chooseRange) throws IOException {
        return getUserInput(fileReader.readLine(), chooseRange);
    }
    
    /**
     * checking if file made a good input.
     * @param number file input
     * @param chooseRange allowed number Range
     * @return the choice from the player as int
     * @throws IOException if the input is not valid
     */
    private int getUserInput(String number, List<Integer> chooseRange) throws IOException{
        int choice = -1;
        try {
            choice = Integer.parseInt(number);
        } catch (java.lang.NumberFormatException nfe) {
            
        }
        if (number == null) {
            throw new IIOException("Not enough numbers in file to finish the game!");
        } else if (!chooseRange.contains(choice)) {
            throw new IOException("This: " + number + ". is no valid number!");
        }
        return choice;
    }

    @Override
    public void printState(String state, int round, int scoreA, int scoreB) throws IOException {
        fileWriter.append("State: "+state+", Round "+round+", Player A: "+scoreA+", Player B: "+ scoreB + " \r\n");
        fileWriter.append('\n');
        fileWriter.flush();
    }
    
}
