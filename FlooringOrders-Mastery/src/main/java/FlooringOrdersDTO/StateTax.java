/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlooringOrdersDTO;

import java.math.BigDecimal;

/**
 *
 * @author laptop
 */
public enum StateTax {

    OH("Ohio", new BigDecimal(".0625")),
    PA("Pennysalvania", new BigDecimal(".0675")),
    MI("Michigan", new BigDecimal(".0575")),
    IN("Indiana", new BigDecimal(".0600"));

    String stateAbbreviation; //Change variable name later
    BigDecimal statesTax; 
    
    StateTax(String stateAbbreviation, BigDecimal statesTax) {
        this.stateAbbreviation = stateAbbreviation;
        this.statesTax = statesTax;
    }
    
    public BigDecimal getStatesTax(){
        return statesTax;
    }
    
     public String getStateAbbreviation() {
        return stateAbbreviation;
    }

}
