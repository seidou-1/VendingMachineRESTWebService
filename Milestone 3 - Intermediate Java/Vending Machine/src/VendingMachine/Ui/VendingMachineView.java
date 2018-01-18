/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine.Ui;

import VendingMachine.Dto.Item;
import java.util.List;

/**
 *
 * @author laptop
 */
public class VendingMachineView {

    private UserIO myIO;

    public VendingMachineView(UserIO io) {
        this.myIO = io;
    }

    public String printMenuAndGetSelection() {
//        
//        double snickersPrice = 2.00;
//        double gatoradePrice = 3.00;
//        double waterPrice = 1.00;
//        
        myIO.print("Vending Menu Items");
        myIO.print("A1: Snickers **** $2.00 " /*+ snickersPrice*/);
        myIO.print("B1: Gatorade **** $3.00 " /*+ gatoradePrice*/);
        myIO.print("C1: Water    **** $1.00 " /*+ waterPrice*/);
//        myIO.print("I:  See Inventory" /*+ waterPrice*/);
        myIO.print("Add: Add To Inventory " /*+ waterPrice*/);
        myIO.print("Exit: Exit Application\n");

        String usersSelection = myIO.readString("Type A Selection (i.e. A1) \n");

        return usersSelection;

    }

//    public String selectItem() {
////        myIO.print("Vending Menu Items");
////        myIO.print("A1: Snickers **** $2.00 " /*+ snickersPrice*/);
////        myIO.print("A2: Gatorade **** $3.00 " /*+ gatoradePrice*/);
////        myIO.print("A3: Water    **** $1.00 " /*+ waterPrice*/);
//
//        return myIO.readString("Select an item (i.e. A1)");
//
//    }

    public String cashFirst() {
        String usersMoney = myIO.readString("Please Insert Money First. $1, $,5 or $10 \n");
        return usersMoney;
    }

    public int seeInventory() {

        return myIO.readInt("Please select from the above choises. ", 1, 2);

    }

    public void displayMoneyInsertedBanner() {
//        String usersReturn = printMenuAndGetSelection();
        myIO.print("Money Successfully Accepted " /*+ usersReturn*/);
    }
    
    public Item itemMetadata(){
        
        String itemID = myIO.readString("What's the item's ID? i.e. C1");
        String itemName = myIO.readString("What's the item's Name? i.e. Gatorade Frost");
        String itemCost = myIO.readString("What is the item's price? i.e. 3.00");
        int itemQuantity = myIO.readInt("What is the quantity? ");

        Item currentItem = new Item (itemID); //This is instantiating a new item and setting the properties to them
        currentItem.setItemName(itemName);
        currentItem.setItemCost(itemCost);
        currentItem.setItemQuantity(itemQuantity);
        return currentItem;
    }
    
    public void displayItemSuccessfllyReplenished(){
        System.out.println("***** Item Successfully Replenished *****\n");
    }
    
    public void displayInsufficientFunds(String errorMsg){
        myIO.print("=== You don't have enough dough bro === ");
        myIO.print(errorMsg);
    }
    
    public String getItemIdChoice(){
        return myIO.readString("Please enter the Item ID");
    }
    
   public void displayErrorMessage(String errorMsg){
        myIO.print("=== Error === ");
        myIO.print(errorMsg);
    }
   
   public void displayExitBanner(){
       myIO.print("GoodBye!!");
   }
   
   public void displayInventoryList (List<Item> itemList){
       //change this to a stream`
       int itemCount = 0;
       for (Item currentItem : itemList){
           
           myIO.print(currentItem.getItemName() + " : " + currentItem.getItemId());
           itemCount++;
           
       }
       System.out.println(" Total Items: " + itemCount);
       myIO.readString("\nPlease hit enter to continue");
       
   }
   
   public void displayDispense(){
       myIO.print("*** Dispense ***");
   }
   
   public void displayDispenseSuccessfully(){
       myIO.print("Successfully dispensed. Pick up your item below");
   }
    

}
