/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;

/**
 *
 * @author Computer
 */
public class main {
    public static void main(String...args) throws IOException{
//        MyCSVReader myReader = new MyCSVReader();
        String sut = "a,as\nd,a\n";
//        final String[][] result = new MyCSVReader().read(new StringReader(sut));
        Reader reader = new StringReader(sut);
        char[] dataArray = new char[4];
        
        final BufferedReader bufReader = new BufferedReader(reader);
        
        int length = 0;
        String line = bufReader.readLine();
        
        System.out.println(line);
        
//        line = bufReader.readLine();
        
//        System.out.println(line);

        while (line != null){
            length = length + line.length();
            line = bufReader.readLine();
        }
        
//        int size = bufReader.read(dataArray);
//        char[] bufferArray = new char[100];
//        char[] test = new char[1];
//        char[] tmp;
//        
//        while (bufferArray[bufferArray.length - 1] != test[0]) {
//            bufReader.read(bufferArray);
//            dataArray = bufferArray;
//            tmp = dataArray;
//            
//        }
//            bufReader.read(bufferArray);
        
//        System.out.println(Arrays.toString(result));
        System.out.println(length);
    }
}
