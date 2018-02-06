/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlooringOrdersController;

import FlooringOrdersServiceLayer.Service;
import FlooringOrdersUI.View;

/**
 *
 * @author laptop
 */
public class Controller {
    
    private View myView;
    private Service myService;
    
    //Constructor
    public Controller(View myView, Service myService){
        this.myView = myView;
        this.myService = myService;
    }
    
    public void run(){
        boolean keepGoing = true;
        int menuSelection = 1;
        
        
        switch (printMenuAndGetSelection()){
            
            case 1:
                //display orders
            case 2:
                //add an order
            case 3:
                //edit an order
            case 4:
                //remove an order
            case 5:
                //save an order
            case 6: 
                exitBanner();
            
        }
        
        
    }
    
    
    
    
    //Methods below
    private int printMenuAndGetSelection(){
        
        return myView.printMenuAndGetSelection();
    }
    
    private void exitBanner(){
        myView.exitBanner();
    }
    
    private void displayAllOrders {
    return myService.
}

    
}
