/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc;

import com.sg.vendingmachinespringmvc.dao.PersistenceException;
import com.sg.vendingmachinespringmvc.model.Change;
import com.sg.vendingmachinespringmvc.model.Products;
import com.sg.vendingmachinespringmvc.service.Service;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author laptop
 */
@Controller
public class ProductSelectionController {

//    Dao dao;
    Service service;

    @Inject
    public ProductSelectionController(Service service) {
        this.service = service;
    }

    @RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
    public String displayProducts(HttpServletRequest request, Model model) throws PersistenceException {
        List<Products> products = service.getAllProducts();
        model.addAttribute("products", products);
        return "/index";
    }

    @RequestMapping(value = "/productSelection", method = RequestMethod.GET)
    public String productSelection(HttpServletRequest request, Model model) throws PersistenceException {
        List<Products> products = service.getAllProducts();
        service.setItemTracker(request.getParameter("productId"));
//        service.getProduct(request.getParameter("productId"));

        Products myProduct = service.getitemTracker();
        model.addAttribute("products", products);
        model.addAttribute("productName", myProduct.getProductName());
        model.addAttribute("productId", myProduct.getProductId());

        BigDecimal balance = service.getBalance();
        model.addAttribute("balance", balance);

        return "/index";
    }

    @RequestMapping(value = "/addBread", method = RequestMethod.GET)
    public String addBread(HttpServletRequest request, Model model) throws PersistenceException {
        List<Products> products = service.getAllProducts();

        BigDecimal originalBalance = new BigDecimal(request.getParameter("amount"));

        BigDecimal balance = service.getBalance().add(originalBalance);

        service.setBalance(balance);

        Products myProduct = service.getitemTracker();

        model.addAttribute("products", products);

        model.addAttribute("productName", myProduct.getProductName());
        model.addAttribute("productId", myProduct.getProductId());

        model.addAttribute("balance", balance);
        return "index";
    }

    @RequestMapping(value = "/makePurchase", method = RequestMethod.GET)
    public String makePurchase(HttpServletRequest request, Model model) throws PersistenceException {
        List<Products> products = service.getAllProducts();

        BigDecimal balance = service.getBalance();

        Products myItem = service.getitemTracker();

        Products myProduct = service.getitemTracker();

        
        String myChange = null;

        try {
        myChange = service.makePurchase(myProduct, balance);
        
//        service.setBalance(balance.subtract(myProduct.getProductCost()));
        
        balance = balance.subtract(myProduct.getProductCost());
        service.setBalance(balance);
        
            model.addAttribute("message", "Thank you come again");

        } catch (Exception e) {

            model.addAttribute("message", e.getMessage());

        }
//        
//        myChange.calculateChange(balance, myProduct);

        model.addAttribute("products", products);
        model.addAttribute("myChange", myChange);

        model.addAttribute("productName", myProduct.getProductName());
        model.addAttribute("productId", myProduct.getProductId());

        model.addAttribute("balance", balance);
        return "index";
    }

    @RequestMapping(value = "/changeReturn", method = RequestMethod.GET)
    public String changeReturn(HttpServletRequest request, Model model) throws PersistenceException {
        List<Products> products = service.getAllProducts();

        service.setBalance();
        service.setItemTracker("0");
        BigDecimal balance = service.getBalance();

        model.addAttribute("products", products);
        model.addAttribute("balance", balance);

        return "index";

    }

}
