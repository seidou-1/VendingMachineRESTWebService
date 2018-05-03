/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Products;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author laptop
 */
public class DaoFileImpl implements Dao {

    public DaoFileImpl() throws PersistenceException{
        loadInventory();
    }
    
    private static BigDecimal money = new BigDecimal("0");
    private static Products selectedProduct = new Products("0");

    Map<String, Products> inventory = new HashMap<>();

    public static final String INVENTORY_FILE = "inventory.txt";
    public static final String DELIMITER = "::";

    @Override
    public Products getProduct(String productID) {

        Products currentProduct = inventory.get(productID);
        return currentProduct;

    }

    @Override
    public List<Products> getAllProducts() {
        
        return new ArrayList<>(inventory.values());

    }
    
    private void loadInventory() throws PersistenceException {

        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(INVENTORY_FILE)));
        } catch (FileNotFoundException e) {
            throw new PersistenceException(
                    "Could not load inventory from file ", e);
        }

        String currentLine;

        String[] currentTokens;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            currentTokens = currentLine.split(DELIMITER);

            Products currentProduct = new Products(currentTokens[0]);
            currentProduct.setProductName(currentTokens[1]);
            //Whatever is being read converts from a String into a BigDecimal
            currentProduct.setProductCost (new BigDecimal (currentTokens[2]));
            currentProduct.setProductInventory(parseInt(currentTokens[3]));

            inventory.put(currentProduct.getProductId(), currentProduct);
        }
        scanner.close();
    }
    
    private void writeInventory() throws PersistenceException{
        
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(INVENTORY_FILE));

        } catch (IOException e) {
            throw new PersistenceException("Error - could not save inventory data.", e);
        }

        List<Products> inventory = this.getAllProducts();

        for (Products tempProducts : inventory) {

            out.println(tempProducts.getProductId() + DELIMITER
                    + tempProducts.getProductName() + DELIMITER
                    //Same. This converts from BigDecimal into a String
                    + tempProducts.getProductCost().toString() + DELIMITER
                    + tempProducts.getProductInventory());

            out.flush();

        }

        out.close();

    }

    @Override
    public BigDecimal getBalance() {
        return this.money;
    }

    @Override
    public void setBalance(BigDecimal adder) {
        this.money=adder; 
    }

    @Override
    public Products getitemTracker() {
        return selectedProduct;
    }

    @Override
    public void setItemTracker(String id) {
        this.selectedProduct = this.getProduct(id);
    }

    @Override
    public void setBalance() {
        this.money = new BigDecimal("0");
    }
        
    

}
