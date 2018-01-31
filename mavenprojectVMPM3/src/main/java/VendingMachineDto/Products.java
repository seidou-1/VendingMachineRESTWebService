/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachineDto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author laptop
 */
public class Products {
    
    private String productId;
    private String productName;
    private BigDecimal productCost;
    private int productInventory;

    public Products(String productId) {
        this.productId = productId;
    }
    

    public String getProductName() {
        return productName;
    }

    /*
    Removed the setter for product name and product ID because the ID will serve as the unique identifier
    
    */

    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    
    public String getProductId() {
        return productId;
    }
    
    public BigDecimal getProductCost() {
        return productCost;
    }

    public void setProductCost(BigDecimal productCost) {
        this.productCost = productCost;
    }

    public int getProductInventory() {
        return productInventory;
    }
    
    /*
    The below method takes the value of the productInventory and reduces
    it by one
    */
    public void setProductInventory() {
        this.productInventory -=1;
//                productInventory = productInventory;
        /*
        call this.getProductInventory -=1
        */
    }
    
    /*
    Overloading the method here so i can use the int value and pass it to the Dao
    Below is for the inventory text file
    */
    
    public int setProductInventory(int productInventory) {
        return this.productInventory = productInventory;
    }
    
    
    
    
    /*
    Inserted code for hashmap and equals below for unit testing later on
    */

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.productId);
        hash = 13 * hash + Objects.hashCode(this.productName);
        hash = 13 * hash + Objects.hashCode(this.productCost);
        hash = 13 * hash + this.productInventory;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Products other = (Products) obj;
        if (this.productInventory != other.productInventory) {
            return false;
        }
        if (!Objects.equals(this.productId, other.productId)) {
            return false;
        }
        if (!Objects.equals(this.productName, other.productName)) {
            return false;
        }
        if (!Objects.equals(this.productCost, other.productCost)) {
            return false;
        }
        return true;
    }
    
    
    
}


