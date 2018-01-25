/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachineDto;

import java.math.BigDecimal;

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

    public void setProductInventory(int productInventory) {
        this.productInventory = productInventory;
    }
    
}


