/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlooringOrdersDAO;

import static FlooringOrdersDAO.ProductionDaoFileImpl.DELIMITER;
//import FlooringOrdersDAO.ProductionDaoFileImpl.ORDERS_;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author laptop
 */
public class Configuration {

    public static String getMode() throws PersistenceException {

        String config_file = "config.txt";
        String DELIMITER = "::";
        
          Scanner scanner;
      
      try {
            scanner = new Scanner (new BufferedReader(new FileReader(config_file))); 
      } catch (FileNotFoundException e) {
          throw new PersistenceException("Could not load inventory from file", e);
      }
      
      
      String currentLine;
      String[] currentTokens;
      String mode = "";//This is to have the program return the value of mode - which is currentTokens[1]
      
      while (scanner.hasNextLine()){
          currentLine = scanner.nextLine();
          
          currentTokens = currentLine.split(DELIMITER);
          
          if (currentTokens[0].equalsIgnoreCase("mode")) {
              
          mode = currentTokens[1];
              
          }
        
    }
        scanner.close();
        return mode;
        
        
        
    }
}
        

