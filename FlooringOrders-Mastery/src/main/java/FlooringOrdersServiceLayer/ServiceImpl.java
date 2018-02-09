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

/**
 *
 * @author laptop
 */
public class ServiceImpl implements Service {

    private Dao myDao;

    public ServiceImpl(Dao myDao) {
        this.myDao = myDao;
    }

    @Override
    public List<Order> displayAllOrders(String date) {

        return myDao.displayAllOrders();
    }

    @Override
    public Order addOrder(Order order) throws DataValidationException {
        validateOrderData(order);
        return myDao.addOrder(order.getOrderNumber(), order);

    }

    @Override
    public int getOrderNumber() {
        return myDao.displayAllOrders().size() + 1;
    }

    @Override
    public Order editOrder(Order order) throws DataValidationException {
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy"); 
//        LocalDate usersDateParsed = LocalDate.parse(date, format);

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
    public Order removeOrder(LocalDate date, int orderNumber) {
        return myDao.removeOrder(date, orderNumber);
    }

    //Exceptions logic below:
    public void validateOrderData(Order order) throws DataValidationException {

        if (order.getCustomerName() == null || order.getCustomerName().trim().length() == 0
                || order.getArea() == null || order.getArea().toString().trim().length() == 0 //How do i check state since it's an enum?
                //How do i also check product since it's an enum?
                ) {

            throw new DataValidationException("ERROR: All fields need to be inputted [Name, Area, State, and Product]");
        }
    }

    private void validateDateFormat(LocalDate date) throws InvalidDateException {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        
 
    }

    private List <Order> checkIfOrderDateExists(LocalDate date) throws OrderNotFoundException {
        //do a try catch here with a do while
        List<Order> tempList = myDao.displayAllOrders() //Calling the dao which gets everything
                .stream() //let the service layer do the filtering
                .filter(s -> s.getDate()/*.toString()*/.equals(date/*.toString()*/))
                .collect(Collectors.toList());

        if (tempList.isEmpty()) { //Order doesn't exist
//            exists = false;
            throw new OrderNotFoundException("There is no order for this date");
        }
        //Order does exist
        return tempList;
    }

    @Override
    public List <Order> checkIfOrderNumberExists(LocalDate date, int orderNumber) throws OrderNotFoundException {
        /*
        This method calls the above method first
        Later on refactor to check both at the same time
        */
        List<Order> orderList = checkIfOrderDateExists(date)
                .stream()
                .filter(s -> s.getOrderNumber() == orderNumber)
                .collect(Collectors.toList());

        if (orderList.isEmpty()){ //true
            throw new OrderNotFoundException ("No such order number exists");
        }
        
        return orderList;
    }
        
        @Override
        public void justSaveToFile() throws PersistenceException{
            
            myDao.justSaveToFile();
            
        }


}
