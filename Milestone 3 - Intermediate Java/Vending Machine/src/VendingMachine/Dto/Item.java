/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine.Dto;

/**
 *
 * @author laptop
 */
public class Item {
    
//    private String Gatorade;
//    private String Snickers;
//    private String Water;
    
    private String itemId;
    private String itemCost;
    private String itemName;

    
    public Item (String itemId){
        this.itemId = itemId;
    }

    public String getItemId() {
        return itemId;
    }
    
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    
    public String getItemCost() {
        return itemCost;
    }

    public void setItemCost(String itemCost) {
        this.itemCost = itemCost;
    }
    
//    
//    public String getGatorade() {
//        return Gatorade;
//    }
//
//    public void setGatorade(String Gatorade) {
//        this.Gatorade = Gatorade;
//    }
//
//    public String getSnickers() {
//        return Snickers;
//    }
//
//    public void setSnickers(String Snickers) {
//        this.Snickers = Snickers;
//    }
//
//    public String getWater() {
//        return Water;
//    }
//
//    public void setWater(String Water) {
//        this.Water = Water;
//    }
    
}
