/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlooringOrdersServiceLayer;

import FlooringOrdersDAO.Dao;
import FlooringOrdersDAO.PersistenceException;
import FlooringOrdersDTO.Order;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import FlooringOrdersDAO.FlooringOrderAuditDao;
import FlooringOrdersDTO.Customer;
import java.util.ArrayList;

/**
 *
 * @author laptop
 */
public class ServiceImpl implements Service {

    private Dao myDao;
    private FlooringOrderAuditDao auditDao;

    public ServiceImpl(Dao myDao, FlooringOrderAuditDao auditDao) {
        this.myDao = myDao;
        this.auditDao = auditDao;
    }

    //.........
    @Override
    public List<Order> displayAllOrders(String date) throws PersistenceException {

        return myDao.displayAllOrders();
    }

    @Override
    public Order addOrder(Order order) throws PersistenceException {
//        validateOrderData(order);

        //Later on have the add order call all the other validation methods
        /*
        I no longer need to use:
        auditDao.writeAuditEntry("Order " + order.getOrderNumber() + " Created " + LocalDate.now());
        
        because now it's in the applicationContext loggingAdvice
         */
        
        //Move discount logic here
        return myDao.addOrder(order.getOrderNumber(), order);

    }

    @Override
    public int getOrderNumber() throws PersistenceException {
        return myDao.displayAllOrders().size() + 1;
    }

    @Override
    public Order editOrder(Order order) throws PersistenceException {
        /*
        I no longer need to use:
        auditDao.writeAuditEntry("Order " + order.getOrderNumber() + " Created " + LocalDate.now());
        
        because now it's in the applicationContext loggingAdvice
         */

        return myDao.addOrder(order.getOrderNumber(), order);

        //Display the order
        //Allow them to edit
        
        //Validate the edit meets the business logic
        //DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy"); 
        //LocalDate usersDateParsed = LocalDate.parse(date, format);
    }
 
    @Override
    public Order removeOrder(/*LocalDate date,*/int orderNumber) throws PersistenceException {
        /*
        I no longer need to use:
        auditDao.writeAuditEntry("Order " + order.getOrderNumber() + " Created " + LocalDate.now());
        
        because now it's in the applicationContext loggingAdvice
         */ 
        
        return myDao.removeOrder(/*date,*/orderNumber);
    }

    //Exceptions logic below:
    public boolean validateOrderData(Order order) throws DataValidationException {
    //Reprompt the user until they enter a correct
        boolean correctInput = true;
        if (order.getCustomerName() == null || order.getCustomerName().trim().length() == 0
                || order.getArea() == null || order.getArea().toString().trim().length() == 0 //How do i check state since it's an enum?
                ) {
            correctInput = false;
            throw new DataValidationException("ERROR: All fields need to be inputted [Name, Area, State, and Product]");
        }
        return correctInput;
    }

    
//    private boolean validateDateFormat(LocalDate date) throws InvalidDateException {
//        boolean validDate = true;
//        while (!validDate) {            
//            try {
//                DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//                if (!date.equals(format)) {
//                    validDate = false;
//                    throw new InvalidDateException("Invalid date format. Should be MM/dd/yyyy");
//                }
//                
//            } catch (InvalidDateException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//        return validDate;
//    }

    public boolean checkIfStateExists(Order state) throws DataValidationException {
        boolean stateCorrect = true;

        try {
            if (state.getTaxCharged().equals(state)) {
                return stateCorrect = true;
            } else {
                throw new DataValidationException("State does not exist. Try again");
            }

        } catch (DataValidationException e) {

            System.out.println(e.getMessage());
            stateCorrect = false;

        }
        return true;
    }

    @Override
    public List<Order> checkIfOrderDateExists(LocalDate date) throws
            OrderDateNotFoundException,
            PersistenceException {
        //do a try catch here with a do while
        List<Order> tempList = myDao.displayAllOrders() //Calling the dao which gets everything
                .stream() //let the service layer do the filtering
                .filter(s -> s.getDate()/*.toString()*/.equals(date/*.toString()*/))
                .collect(Collectors.toList());

        boolean validDate = true;
        while (!validDate) {
            try {
                if (tempList.isEmpty()) { //Order doesn't exist
//            exists = false;
                    validDate = false;
                    throw new OrderDateNotFoundException("There is no order for this date. Enter a different date.");
                }
                //Order does exist
                return tempList;
            } catch (OrderDateNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        return tempList;

    }

    //Testing
//    public Map<Integer, List<Order> > checkIfOrderDateExistsAsAmap(){
//        
//    }
    @Override
    public List<Order> checkIfOrderNumberExists(LocalDate date, int orderNumber) throws
            OrderDateNotFoundException,
            OrderNumberNotFoundException,
            PersistenceException {
        boolean numberIsFound = true;
        /*
        This method calls the above method first
        Later on refactor to check both at the same time
         */
        List<Order> orderList = checkIfOrderDateExists(date)
                .stream()
                .filter(s -> s.getOrderNumber() == orderNumber)
                .collect(Collectors.toList());
        
        
//        while (!numberIsFound) {            
            if (orderList.isEmpty()) { //true
//                numberIsFound = false;
                throw new OrderDateNotFoundException("No such order number exists. Try again \n");
//            }
        }

        return orderList;
    }

    @Override
    public boolean justSaveToFile() throws PersistenceException {

        if (myDao.justSaveToFile()) {
            return myDao.justSaveToFile();
        } else {
            throw new PersistenceException("\nUnable to save. Switch to Production mode to save.\n");
        }

    }

    @Override
    public List<Customer> getAllCustomers() {
        return myDao.getAllCustomers();
    }

    @Override
    public Customer getCustomer(String phoneNumber) {
        return myDao.getCustomer(phoneNumber);
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public Customer getCustomer(String phoneNumber) {
//        return myDao.getCustomer(phoneNumber);
////        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

}
