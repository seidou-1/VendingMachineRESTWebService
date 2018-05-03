/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.tipcalculatorspringmvc;

import java.math.BigDecimal;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author laptop
 */
@Controller
public class TipCalculatorController {

    @RequestMapping(value = "/TipCalculator", method = RequestMethod.POST)    
    
    public String tipCalculator(HttpServletRequest request, Map<String, Object> model){
        
        //Code goes here
        String billAmt = request.getParameter("billAmt");
        String tip = request.getParameter("tip");

        BigDecimal startingBill = new BigDecimal(billAmt); // 10.00
        BigDecimal tipAmount = new BigDecimal(tip).divide(new BigDecimal("100")); // 15 -> .15
        BigDecimal totalTip = startingBill.multiply(tipAmount);
        BigDecimal totalBill = startingBill.add(totalTip);

        // Set startingBill, tipAmount, totalTip, totalBill
        // as an attributes on the request so that
        // it is available to result.jsp
        model.put("startingBill", startingBill);
        model.put("tipAmount", tipAmount);
        model.put("totalTip", totalTip);
        model.put("totalBill", totalBill);
        
        return "result";
        
    }
    

}
