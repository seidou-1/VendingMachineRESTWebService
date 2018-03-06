/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlooringOrdersDTO;

import java.math.BigDecimal;
import static java.math.BigDecimal.ROUND_UNNECESSARY;
import static java.math.RoundingMode.HALF_UP;
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

    private ProductCosts productClass; //Composition - object gives me the Cost Per Sq Ft, Labor Cost Per Sq Ft, and Product
    private StateTax taxClass; //Composition - object gives me the State and the tax rate
    
    //Product:
    private BigDecimal costPerSqFt;
    private BigDecimal laborCostPerSqFt;
    
    //Tax
    private BigDecimal stateTax;
    private BigDecimal taxRate;

    public BigDecimal getCostPerSqFt() {
        return costPerSqFt;
    }

    public void setCostPerSqFt(BigDecimal costPerSqFt) {
        this.costPerSqFt = costPerSqFt;
    }

    public BigDecimal getLaborCostPerSqFt() {
        return laborCostPerSqFt;
    }

    public void setLaborCostPerSqFt(BigDecimal laborCostPerSqFt) {
        this.laborCostPerSqFt = laborCostPerSqFt;
    }

    public BigDecimal getStateTax() {
        return stateTax;
    }

    public void setStateTax(BigDecimal stateTax) {
        this.stateTax = stateTax;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }
    

    public Order(int orderNumber) {//Passed the order# into the constructor so a new order is created each time "Order" is called
        this.orderNumber = orderNumber;
    }

    public StateTax getTaxClass() {
        return taxClass;
    }

    public void setTaxClass(String taxClass) {
        this.taxClass = StateTax.valueOf(taxClass.toUpperCase());
        //Kills 3 birds with one stone
    }

    /*
    if you have an enum that has multiple properties (i.e. OH("OH", new BigDecimal("6.25")))
    and you create a dto where the data type is that enum, once you set the property for
    the enum, i.e. "setTaxClass", it sets the properties for the other enum properties as well.
     */
    public ProductCosts getProductClass() {
        return productClass;
    }

    public void setProductClass(String productClass) {
        this.productClass = ProductCosts.valueOf(productClass.toUpperCase());
        /*
        I'm creating a placeholder here. I'm setting the value by getting the enum
        value and matching the uppercase version of that with what the user passed in
        */
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

    public void setTaxCharged(BigDecimal taxCharged) {
        this.taxCharged = taxCharged;
    }

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void calculateTotals() { //Setter pretty much

        BigDecimal totalTax
                = ((area.multiply(productClass.getCostPerSqFt()).add(area.multiply(productClass.getlaborCostPerSqFt()))
                        .multiply(taxClass.getStatesTax())).setScale(2, HALF_UP));

        this.taxCharged = (totalTax); //Here i'm setting the totalTax to the taxCharged
        //Tax rate for that state is i.e. 6.25%
        //Now the tax is (area * cost per sq ft) + (area * labor cost per sq ft) * tax rate for that state i.e. 6.25%
//        System.out.println(taxCharged);
        
        BigDecimal totalCost
                = (((area.multiply(productClass.getCostPerSqFt())).add((area.multiply(productClass.getlaborCostPerSqFt())))
                        .add(totalTax)).setScale(2, HALF_UP));

        //Grand total is 
//        ((area * prodcut cost per Sq ft) + (area * product labor cost per Sq ft) + totalTax)
        this.grandTotal = (totalCost); //Here i'm setting the grandTotal to the grandTotal of my Enum
        
//        System.out.println(grandTotal);

    }

    /*
    I created the toString method below to use it for the audit text file so i can output
    all the values onto the text file as Strings
    */
    @Override
    public String toString() {
        return "\n Order Number: " + this.orderNumber
                + ", Name: "
                + this.customerName
                + ", Area: "
                + this.area
                + ", Material: "
                + this.productClass.getProductName()
                + ", Cost Per Sq. Ft: "
                + this.productClass.getCostPerSqFt()
                + ", Labor Cost Per Sq. Ft: "
                + this.productClass.getlaborCostPerSqFt()
                + ", State: "
                + this.taxClass.getStateAbbreviation() //Can also just print out just TaxClass
                + ", State Tax: "
                + this.taxClass.getStatesTax()
                + ", Tax Charged: "
                + this.taxCharged
                + ", Grand Total: "
                + this.grandTotal;
    }

//    public String orderInStrings(){ 
//        return
//        "\n Order Number: " + this.orderNumber
//                + ", Name: "
//                + this.customerName
//                + ", Area: "
//                + this.area
//                + ", Material: "
//                + this.productClass.getProductName()
//                + ", Cost Per Sq. Ft: "
//                + this.productClass.getCostPerSqFt()
//                + ", Labor Cost Per Sq. Ft: "
//                + this.productClass.getlaborCostPerSqFt()
//                + ", State: "
//                + this.taxClass.getStateAbbreviation() //Can also just print out just TaxClass
//                + ", State Tax: "
//                + this.taxClass.getStatesTax()
//                + ", Tax Charged: "
//                + this.taxCharged
//                + ", Grand Total: "
//                + this.grandTotal;
//    } 
}
