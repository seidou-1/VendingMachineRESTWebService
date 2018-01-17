/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine.Controller;

import VendingMachine.Dao.VendingMachineDao;
import VendingMachine.Dao.VendingMachineDaoException;
import VendingMachine.Dto.Item;
import VendingMachine.Ui.VendingMachineView;
import java.util.List;

/**
 *
 * @author laptop
 */
public class VendingMachineController {

    VendingMachineView view;
    VendingMachineDao dao;

//public VendingMachineController (VendingMachineDao dao, VendingMachineView view){ //This controller handles dependency injection
//    this.view = view;
//    this.dao = dao;
//}
    public VendingMachineController(VendingMachineDao dao, VendingMachineView view) {
        this.view = view;
        this.dao = dao;
    }

    public void run() {
        boolean keepGoing = true;
        String menuSelection = "";

        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();
                getMenuSelection();

                switch (menuSelection) {

                    case "A1":
                    case "A2":
                    case "A3":
                        whatchuWant();
                        break;
                    case "I":
                        getInventory();
                        break;
                    case "Add":
                        replenishItems();
                        break;
                    case "Exit":
                        keepGoing = false;
                        break;
                    default:
                        System.out.println("Invalid");
                        break;
                }
            }
            exitMessage();
        } catch (VendingMachineDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }

    }

    private String getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void replenishItems() throws VendingMachineDaoException {
        Item newItem = view.itemMetadata();//This is getting the item metadaa properties
        dao.addItem(newItem.getItemId(), newItem); //This is getting the Id of the item and adding it to the Dao
        view.displayItemSuccessfllyReplenished();
    }
    
    private void getInventory() throws VendingMachineDaoException {
        List<Item> itemList = dao.getAllItems();
        view.displayInventoryList(itemList);
    }

    private void moneyGood() {
        view.displayMoneyInsertedBanner();

    }

    private void whatchuWant() {
        view.selectItem();

    }

    private void cashMoneyFirst() {
        view.cashFirst();
    }

    

    private void exitMessage() {
        view.displayExitBanner();
    }

}

//
//        while (keepGoing) {
//
//            switch (menuSelection) {
//                case "1":
//                    System.out.println(" ");
//                    break;
//                case "5":
//                    System.out.println(" ");
//                    break;
////                case 3:
////                    System.out.println("Gatorade Red " + " Price " + " Remaining: " + " Amount");
////                    break;
////                case 4:
////                    System.out.println("Doritos Cool Ranch " + " Price " + " Remaining: " + " Amount");
////                    break;
//                case "10":
//                case "20":
//                    System.out.println(" ");
//                    break;
//                case "exit":
//                    System.out.println("Exit");
//                    keepGoing = false;
//                    break;
//                default:
//                    System.out.println(" ");
//            }
//        }
//        ChangeDto myChange = new ChangeDto();
//        myChange.deliverChange(2, 5);
