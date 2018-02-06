/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlooringOrdersDTO;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author laptop
 */
public class Order {

    private int orderNumber;
    private String customerName;
    private BigDecimal area;
 
    private BigDecimal materialCost;
    private BigDecimal laborCost;
    private BigDecimal taxCharged;
    private BigDecimal grandTotal;

    private LocalDate date;
    
    private ProductCosts productClass; //Enum. I can get the Cost Per Sq Ft, Labor Cost Per Sq Ft, and Product
    private StateTax taxClass; //Enum. I can get the State and the tax rate
    
    
    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    
    
    public StateTax getTaxClass() {
        return taxClass;
    }

    public void setTaxClass(String taxClass) {
        this.taxClass = StateTax.valueOf(taxClass.toUpperCase());
    }
    
    /*
    if you have an enum that has multiple properties (i.e. OH("OH", new BigDecimal("6.25")))
    and you create a dto where the data type is that enum, 
    how would you create setters for each of the properties of that enum?
    */
    
    public ProductCosts getProductClass() {
        return productClass;
    }

    public void setProductClass(String productClass) {
        this.productClass = ProductCosts.valueOf(productClass.toUpperCase());
    }

    public BigDecimal getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(BigDecimal grandTotal) {
        this.grandTotal = grandTotal;
    } 

    public BigDecimal getTaxCharged() {
        return taxCharged;
    }

    public void setTaxCharged(BigDecimal theStateAbbreviation) {
        this.taxCharged = StateTax.valueOf(theStateAbbreviation);
    } 
    
//        public void setTaxCharged(BigDecimal taxCharged) {
//        this.taxCharged = taxCharged;
//    } 

    public int getOrderNumber() {
        return orderNumber;

    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    } 
    
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

//    public void setState(String state) {
//        this.state = state;
//    }
    public BigDecimal getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(BigDecimal materialCost) {
        this.materialCost = materialCost;
    }

    public BigDecimal getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(BigDecimal laborCost) {
        this.laborCost = laborCost;
    }

    

//     public Tax getTaxClass() {
//        return taxClass;
//    }
//
//    public void setTaxClass(Tax taxClass) {
//        this.taxClass = taxClass;
//    }
//    public Product getProductClass() {
//        return productClass;
//    }
//
//    public void setProductClass(Product productClass) {
//        this.productClass = productClass;
//    }
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
