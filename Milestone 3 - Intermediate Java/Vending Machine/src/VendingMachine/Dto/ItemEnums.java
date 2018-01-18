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
public enum ItemEnums {
    
    WATER("1"), SNICKERS("2"), GATORADE("3");
    
    private String price;
    
    private ItemEnums(String price){
        this.price = price;
    }
    
    public String getPrice(){
        return price;
    }
    
}
