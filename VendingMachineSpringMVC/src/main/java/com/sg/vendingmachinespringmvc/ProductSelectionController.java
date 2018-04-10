/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc;

import com.sg.vendingmachinespringmvc.dao.Dao;
import com.sg.vendingmachinespringmvc.dao.PersistenceException;
import com.sg.vendingmachinespringmvc.model.Change;
import com.sg.vendingmachinespringmvc.model.Products;
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

    Dao dao;

    @Inject
    public ProductSelectionController(Dao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
    public String displayProducts(HttpServletRequest request, Model model) throws PersistenceException {
        List<Products> products = dao.getAllProducts();
        model.addAttribute("products", products);
        return "/index";
    }

    @RequestMapping(value = "/productSelection", method = RequestMethod.GET)
    public String productSelection(HttpServletRequest request, Model model) throws PersistenceException {
        List<Products> products = dao.getAllProducts();
        dao.setItemTracker(request.getParameter("productId"));
//        dao.getProduct(request.getParameter("productId"));
        
        Products myProduct = dao.getitemTracker();
        model.addAttribute("products", products);
        model.addAttribute("productName", myProduct.getProductName());
        model.addAttribute("productId", myProduct.getProductId());
        
        BigDecimal balance = dao.getBalance();
        model.addAttribute("balance", balance);
        
        return "/index";
    }

    @RequestMapping(value = "/addBread", method = RequestMethod.GET)
    public String addBread(HttpServletRequest request, Model model) throws PersistenceException {
        List<Products> products = dao.getAllProducts();

        BigDecimal originalBalance = new BigDecimal(request.getParameter("amount"));

        BigDecimal balance = dao.getBalance().add(originalBalance);
        
        dao.setBalance(balance);

        Products myProduct = dao.getitemTracker();
        
        model.addAttribute("products", products);

        model.addAttribute("productName", myProduct.getProductName());
        model.addAttribute("productId", myProduct.getProductId());

        model.addAttribute("balance", balance);
        return "index";
    }
    
    @RequestMapping(value = "/makePurchase", method = RequestMethod.GET)
    public String makePurchase(HttpServletRequest request, Model model) throws PersistenceException {
        List<Products> products = dao.getAllProducts();


        BigDecimal balance = dao.getBalance();
 
        
        
        Products myProduct = dao.getitemTracker();
        
        myProduct.setProductInventory();
        
        Change myChange = new Change();
        
        myChange.calculateChange(balance, myProduct);
        
        model.addAttribute("products", products);
        model.addAttribute("myChange", myChange);

        model.addAttribute("productName", myProduct.getProductName());
        model.addAttribute("productId", myProduct.getProductId());

        model.addAttribute("balance", balance);
        return "index";
    }
    
    @RequestMapping(value = "/changeReturn", method = RequestMethod.GET)
    public String changeReturn(HttpServletRequest request, Model model) throws PersistenceException {
        List<Products> products = dao.getAllProducts();

        dao.setBalance();
        dao.setItemTracker("0");
        BigDecimal balance = dao.getBalance();

                
        model.addAttribute("products", products);
        model.addAttribute("balance", balance);
        
        return "index";
        


}
}