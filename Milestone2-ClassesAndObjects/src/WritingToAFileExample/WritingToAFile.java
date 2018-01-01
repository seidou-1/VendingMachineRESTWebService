/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WritingToAFileExample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author laptop
 */
public class WritingToAFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));
        out.println("this is a line in my file...");
        out.println("a second line in my file...");
        out.println("a third line in my file...");
        out.flush();
        out.close();
        
        //The purpose of this now is to read from the OutFile.txt and print it onto the screen in addition to printing it onto that file
        Scanner myScanner = new Scanner (new BufferedReader(new FileReader("OutFile.txt")));
        
        while  (myScanner.hasNextLine()){
            String currentLine = myScanner.nextLine();
            System.out.println(currentLine);
        }
        
        System.out.println("that's all the content in the file");
    }

}
