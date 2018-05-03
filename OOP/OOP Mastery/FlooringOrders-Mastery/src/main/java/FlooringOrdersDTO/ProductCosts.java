/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlooringOrdersDTO;

import java.math.BigDecimal;

/**
 *
 * @author laptop
 */
public enum ProductCosts {
    
//  Product,                     Cost Per Sq Ft,        Labor Cost Per Sq Ft
    CARPET ("Carpet", new BigDecimal ("2.25"), new BigDecimal ("2.10")),
    LAMINATE ("Laminate", new BigDecimal ("1.75"), new BigDecimal ("2.10")),
    TILE ("Tile", new BigDecimal ("3.50"), new BigDecimal ("4.15")),
    WOOD ("Wood", new BigDecimal ("5.15"), new BigDecimal ("4.75"));
    
    //Below will be used for constructors
        String productName;
        BigDecimal costPerSqFt;
        BigDecimal laborCostPerSqFt;
    
    /*
    To pass values to enums, you need to create a Constructor
    The constructor will serve as the setter
    */
    ProductCosts (String productName, BigDecimal costPerSqFt, BigDecimal laborCostPerSqFt){
        
        this.productName = productName;
        this.costPerSqFt = costPerSqFt;
        this.laborCostPerSqFt = laborCostPerSqFt;
    }
    
    /*
    To get the values, i have to create getters
    */
    
    
    public BigDecimal getCostPerSqFt(){
        return costPerSqFt;
    }
    
    public BigDecimal getlaborCostPerSqFt(){
        return laborCostPerSqFt;
    }
    
    public String getProductName(){
        return productName;
    }
    
    
}
