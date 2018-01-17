/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine.Dao;

import VendingMachine.Dto.Item;
import java.util.List;

/**
 *
 * @author laptop
 */
public interface VendingMachineDao {
 
    
    
//    public long selectItemAndGetPrice(Item item);
//    public void insertCoin(Coin coin);
//    public List<Coin> refund();
//    public Bucket<Item, List<Coin>> collectItemAndChange();   
//    public void reset();

//      vendingMachine addItem (Item item);
      
 Item addItem (String itemId, Item itemName) throws VendingMachineDaoException;
 
 List<Item> getAllItems() throws VendingMachineDaoException;//Item inventory
 
 Item dispenseItem (String itemId) throws VendingMachineDaoException; //Remove item
    
              
}
