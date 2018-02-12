/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlooringOrdersServiceLayer;

import FlooringOrdersDAO.Dao;
import FlooringOrdersDAO.FlooringOrderAuditDAO;
import FlooringOrdersDAO.PersistenceException;
import FlooringOrdersDTO.Order;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author laptop
 */
public class ServiceImpl implements Service {

    private Dao myDao;
    private FlooringOrderAuditDAO auditDao;

    public ServiceImpl(Dao myDao, FlooringOrderAuditDAO auditDao) {
        this.myDao = myDao;
        this.auditDao = auditDao;
    }

    //.........
    @Override
    public List<Order> displayAllOrders(String date) throws PersistenceException{

        return myDao.displayAllOrders();
    }

    @Override
    public Order addOrder(Order order) throws 
            PersistenceException
    {
//        validateOrderData(order);
        
        //Later on have the add order call all the other validation methods
        auditDao.writeAuditEntry("Order " + order.getOrderNumber() + " Created " + LocalDate.now());
        return myDao.addOrder(order.getOrderNumber(), order);

    }

    @Override
    public int getOrderNumber() throws PersistenceException{
        return myDao.displayAllOrders().size() + 1;
    }

    @Override
    public Order editOrder(Order order) throws PersistenceException {
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy"); 
//        LocalDate usersDateParsed = LocalDate.parse(date, format);
    auditDao.writeAuditEntry("Order " + order.getOrderNumber() + " Created " + LocalDate.now());

        return myDao.addOrder(order.getOrderNumber(), order);

        //Display the order
        //Allow them to edit
        //Validate the edit meets the business logic
        //
    }

//    Order filterOrderByDateAndOrderNumber (LocalDate date, int orderNumber){
//        //Add a filter here to filter by date and order number
//    }
    @Override
    public Order removeOrder(LocalDate date, int orderNumber) throws PersistenceException{
        auditDao.writeAuditEntry("Order " + orderNumber + " Created " + LocalDate.now());

        return myDao.removeOrder(date, orderNumber);
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

    private void validateDateFormat(LocalDate date) throws InvalidDateException {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    }

    public boolean checkIfStateExists(Order state) throws DataValidationException {
//should  return a boolean or order?
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
            PersistenceException{
        /*
        This method calls the above method first
        Later on refactor to check both at the same time
         */
        List<Order> orderList = checkIfOrderDateExists(date)
                .stream()
                .filter(s -> s.getOrderNumber() == orderNumber)
                .collect(Collectors.toList());

        if (orderList.isEmpty()) { //true
            throw new OrderDateNotFoundException("No such order number exists");
        }

        return orderList;
    }

    @Override
    public void justSaveToFile() throws PersistenceException {

        myDao.justSaveToFile();

    }
    
    

}
