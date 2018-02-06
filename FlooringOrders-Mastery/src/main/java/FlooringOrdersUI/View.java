/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlooringOrdersUI;

import FlooringOrdersDTO.Order;
import FlooringOrdersDTO.Product;
import java.math.BigDecimal;

/**
 *
 * @author laptop
 */
public class View {

    private UserIO myIO;

    public View(UserIO myIO) {
        this.myIO = myIO;
    }

    public int printMenuAndGetSelection() {

        myIO.print("**** SWG Corp. Flooring Menu ****");
        myIO.print("1. Display Orders");
        myIO.print("2. Add an Order");
        myIO.print("3. Edit an Order");
        myIO.print("4. Remove an Order");
        myIO.print("5. Save Current Work");
        myIO.print("6. Exit");

        return myIO.readInt("Select one of the options above [i.e. 1 - 6]", 1, 6);

    }

    public void displayAllOrders(List<Order> List) {
        for (Order bucket : List) {

            myIO.print(
                    "Order Number: " +
                    bucket.getOrderNumber() + " Name: "
                    + bucket.getCustomerName() + " Area: "
                    + bucket.getArea() + " State: "
                    + bucket.getTaxClass() + " State Tax: " //The actual state i.e. OH
                    + bucket.getTaxClass().getStatesTax() + " Product: " //Gets the corresponding tax for OH
                    + bucket.getProductClass()+ " Cost Per Sq. Ft: "
                    + bucket.getProductClass().getCostPerSqFt() + " Labor Cost Per Sq Ft: "
                    + bucket.getProductClass().getlaborCostPerSqFt() + " Total Tax: "
                    + bucket.getTaxCharged()+ " Grand Total: "
                    + bucket.getGrandTotal()
            );

        }

    }

    public Order setUsersOrder() {
        String name = myIO.readString("Enter first and last name");
        BigDecimal area = myIO.readBigDecimal(new BigDecimal("Enter your Sq. Footage"));
        String state = myIO.readString("Enter State [i.e. OH, PA, MI, or IN]");
        String product = myIO.readString("What material do you prefer [i.e. Carpet, Laminate, Tile, or Wood]?");

        Order currentOrder = new Order(currentOrder.setOrderNumber()); //Trying to auto set the order#
//        Product currentProduct = new Product(); //Instantiating product 

        currentOrder.setArea(area);
        currentOrder.setState(state);
        currentOrder.setProductClass(currentProduct);//How do i set the product?
//        currentProduct.setProductType(product);

        return currentOrder;

    }

    public String confirmSelection() {
        return myIO.readString("Are you sure? Y/N");
        /*
        Pass this response to a switch statement to persist or not
         */
    }

    public void displayCreateSuccessBanner() {
        myIO.readString("Order successfully created. Hit enter to continue");
    }

    public void exitBanner() {
        myIO.print("GoodBye!!");
    }

}
