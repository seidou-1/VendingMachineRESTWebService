/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlooringOrdersDTO;

import java.math.BigDecimal;
import static java.math.RoundingMode.HALF_UP;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author laptop
 */
public class Order {

    private int orderNumber;
    private String customerName;
    private String phoneNumber;
    private BigDecimal area;
    private BigDecimal materialCost;
    private BigDecimal laborCost;
    private BigDecimal taxCharged;
    private BigDecimal grandTotal;
    private Map<String, BigDecimal> additionalItems = new HashMap<>(); //To store additional products
    private String additionalProducts;

    private LocalDate date;

    private ProductCosts productClass; //Composition - object gives me the Cost Per Sq Ft, Labor Cost Per Sq Ft, and Product
    private StateTax taxClass; //Composition - object gives me the State and the tax rate

    //create a new product and make it a map. set the map to the map of the view
//    private ProductCosts additionalProducts;
    //Product:
    private BigDecimal costPerSqFt;
    private BigDecimal laborCostPerSqFt;
    
    public Order(int orderNumber) {//Passed the order# into the constructor so a new order is created each time "Order" is called
        this.orderNumber = orderNumber;
    }

    public BigDecimal getTotalCostPerSqFt() {
        return totalCostPerSqFt;
    }

    public void setTotalCostPerSqFt(BigDecimal totalCostPerSqFt) {
        this.totalCostPerSqFt = totalCostPerSqFt;
    }

    public BigDecimal getTotalLaborCostPerSqFt() {
        return totalLaborCostPerSqFt;
    }

    public void setTotalLaborCostPerSqFt(BigDecimal totalLaborCostPerSqFt) {
        this.totalLaborCostPerSqFt = totalLaborCostPerSqFt;
    }

    private BigDecimal totalCostPerSqFt;
    private BigDecimal totalLaborCostPerSqFt;

    //Tax:
    private BigDecimal stateTax;
    private BigDecimal taxRate;

    public Map<String, BigDecimal> getAdditionalItems() {
        return additionalItems;
    }

    public void setAdditionalItems(Map<String, BigDecimal> additionalItems) {
        this.additionalItems = additionalItems;
    }

    //Customer:
//    private 
//    private Customer customerClass;
//
//    public Customer getCustomerClass() {
//        return customerClass;
//    }
//
//    public void setCustomerClass(Customer customerClass) {
//        this.customerClass = customerClass;
//    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

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
    
    public void setProductsToHashMap(String product, BigDecimal area){
        this.additionalItems.put(product, area);
    }

    public String displayFormat() {

        //1::cam dipset::MI::0.0575::Wood,432~Tile,322~Laminate,123::512.15::848.75::240.22::4418.02::2018-02-14::123
        String placeHolder = "";
        int counter = 1;

        for (String bucket : additionalItems.keySet()) {//Loop through all the products
            placeHolder += (bucket + "," + additionalItems.get(bucket));//We're passing in the product which is bucket
            if (counter < additionalItems.keySet().size()) {//If counter reaches the end of the key size, return to normal (nothing symbol)
                placeHolder += "~";
            }
            counter++;

        }
        return placeHolder;
    }

    public void calculateTotals(boolean discount) { //Setter pretty much

        BigDecimal totalPreTax = new BigDecimal("0");
        this.additionalProducts = "";
        this.totalCostPerSqFt = new BigDecimal("0");
        this.totalLaborCostPerSqFt = new BigDecimal("0");

        //for loop:
        //multipy area by cost of item for product and labor
        //add this to the global variable which keeps the pre tax amount
        //afte the for loop:
        //calculate the tax as the pretax amount. This will be the grand total
        //check to see if order count >= 5 and if so grand total *= .90
        for (String bucket : additionalItems.keySet()) {//Loop through all the products
            additionalProducts += (bucket + " ( " + additionalItems.get(bucket) + " ) ");//We're passing in the product which is bucket

            BigDecimal area = additionalItems.get(bucket);
            BigDecimal costPerSqFoot = (ProductCosts.valueOf(bucket.toUpperCase()).getCostPerSqFt());

            BigDecimal laborCost = (ProductCosts.valueOf(bucket.toUpperCase()).getlaborCostPerSqFt());

            BigDecimal pretax = area.multiply((costPerSqFoot).add(laborCost));
            totalPreTax = pretax.add(totalPreTax);//equivalent to totalPretax+=preTax                

            totalCostPerSqFt = totalCostPerSqFt.add(area.multiply(costPerSqFoot)); //The total cost of each of the products' sq ft

            totalLaborCostPerSqFt = totalLaborCostPerSqFt.add(area.multiply(laborCost));
//    System.out.println(totalPreTax);

//                        bucket.getTaxClass().getStatesTax()
        }

        BigDecimal totalTax = totalPreTax.multiply(taxClass.getStatesTax()).setScale(2, HALF_UP); //calculates the total tax

//                = ((area.multiply(productClass.getCostPerSqFt()).add(area.multiply(productClass.getlaborCostPerSqFt()))
        this.taxCharged = (totalTax); //Here i'm setting the totalTax to the taxCharged
        //Tax rate for that state is i.e. 6.25%
        //Now the tax is (area * cost per sq ft) + (area * labor cost per sq ft) * tax rate for that state i.e. 6.25%

//        System.out.println(taxCharged);
        
        BigDecimal totalCost
                = (((area.multiply(productClass.getCostPerSqFt())).add((area.multiply(productClass.getlaborCostPerSqFt())))
                        .add(totalTax)).setScale(2, HALF_UP));


//        System.out.println(taxCharged);
         totalCost = taxCharged.add(totalPreTax);
//                = (((area.multiply(productClass.getCostPerSqFt())).add((area.multiply(productClass.getlaborCostPerSqFt())))
//                        .add(totalTax)).setScale(2, HALF_UP));


        //Grand total is 
//        ((area * prodcut cost per Sq ft) + (area * product labor cost per Sq ft) + totalTax)
        this.grandTotal = (totalCost.setScale(2, HALF_UP)); //Here i'm setting the grandTotal to the grandTotal of my Enum
        
        if (discount) {//If discount is true
            System.out.println("\n You qualified for a 10% discount");
            System.out.println("\n Before 10%: " + "$" + grandTotal);
            grandTotal = grandTotal.multiply(new BigDecimal (".90").setScale(2, HALF_UP));
            System.out.println("\n After 10%: " + "$"+ grandTotal.setScale(2, HALF_UP));

        }
        
//        System.out.println(grandTotal);
//        System.out.println("grand total: " + grandTotal);
//        System.out.println("tax charged: " + taxCharged);
//        System.out.println("totalPreTax " + totalPreTax);

        System.out.println(this.toString());
        
        
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
                //                + ", Area: "
                //                + this.area
                + ", Material (Area): "
                + this.displayFormat()
                //                + this.productClass.getProductName()
                + ", Total Cost Per Sq. Ft: "
                + this.totalCostPerSqFt
                + ", Total Labor Cost Per Sq. Ft: "
                //                + this.productClass.getlaborCostPerSqFt()
                + this.totalLaborCostPerSqFt
                + ", State: "
                + this.taxClass.getStateAbbreviation() //Can also just print out just TaxClass
                + ", State Tax: "
                + this.taxClass.getStatesTax()
                + ", Tax Charged: $"
                + this.taxCharged
                + ", Grand Total: $"
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
