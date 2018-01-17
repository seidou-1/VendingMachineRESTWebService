/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine.Dao;

import VendingMachine.Dto.Item;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author laptop
 */
public class VendingMachineDaoImpl implements VendingMachineDao {
    
    public static final String INVENTORY_FILE = "inventory.txt";
    public static final String DELIMITER = "::";
    
    private Map<String, Item> items = new HashMap<>();
//                Key    Map
    
    private void loadInventory() throws VendingMachineDaoException{
        Scanner myScanner;
        
        try{
        myScanner = new Scanner (new BufferedReader(new FileReader(INVENTORY_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachineDaoException("Could not load inventory data into memory ", e);
            }
     String currentLine;
     String[] currentTokens;
     
     while (myScanner.hasNext()){
         
         currentLine = myScanner.nextLine();
         
         currentTokens = currentLine.split(DELIMITER);
         
         Item currentItem = new Item (currentTokens[0]);
         
         currentItem.setItemCost(currentTokens[1]);
         
         items.put(currentItem.getItemId(), currentItem);
     }
        myScanner.close();
        
    }
    
    private void writeInventory() throws VendingMachineDaoException {
        
        PrintWriter out;
        
        try {
            out = new PrintWriter (new FileWriter (INVENTORY_FILE));
        } catch (IOException e) {
            throw new VendingMachineDaoException ("Could not save vending item data ", e);
        }
        
        List <Item> itemList = this.getAllItems();
        for (Item currentItem : itemList){
            
            out.println(currentItem.getItemId() + DELIMITER
            + currentItem.getItemName() + DELIMITER
            + currentItem.getItemCost() + DELIMITER);
            
            out.flush();
        }
        //clean up
        out.close();
    }
    
    @Override
    public Item addItem(String itemId, Item itemName) throws VendingMachineDaoException {
        Item newItem = items.put(itemId, itemName);
        writeInventory();
        return newItem;
    }

    @Override
    public List<Item> getAllItems() throws VendingMachineDaoException { //Display inventory
        loadInventory();
        return new ArrayList<Item>(items.values());//Get all the values from the collection
        //Stream to display item grouped by...
    }

    @Override
    public Item dispenseItem(String itemId) throws VendingMachineDaoException{
            Item dispensedItem = items.remove(itemId);
            writeInventory();
            return dispensedItem;
                     
            
    }
    
}
