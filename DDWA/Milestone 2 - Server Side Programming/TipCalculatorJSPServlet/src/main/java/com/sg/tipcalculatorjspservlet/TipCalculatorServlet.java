/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.tipcalculatorjspservlet;

import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author laptop
 */
@WebServlet(name = "TipCalculatorServlet", urlPatterns = {"/TipCalculatorServlet"})
public class TipCalculatorServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        String billAmt = request.getParameter("billAmt");
        String tip = request.getParameter("tip");

        BigDecimal startingBill = new BigDecimal(billAmt); // 10.00
        BigDecimal tipAmount = new BigDecimal(tip).divide(new BigDecimal("100")); // 15 -> .15
        BigDecimal totalTip = startingBill.multiply(tipAmount);
        BigDecimal totalBill = startingBill.add(totalTip);

        // Set startingBill, tipAmount, totalTip, totalBill
        // as an attributes on the request so that
        // it is available to result.jsp
        request.setAttribute("startingBill", startingBill);
        request.setAttribute("tipAmount", tipAmount);
        request.setAttribute("totalTip", totalTip);
        request.setAttribute("totalBill", totalBill);

        // Get the Request Dispatcher for result.jsp and forward the 
        // request to result.jsp
        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
