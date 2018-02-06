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

    OH("OH", new BigDecimal("6.25")),
    PA("PA", new BigDecimal("6.75")),
    MI("MI", new BigDecimal("5.75")),
    IN("IN", new BigDecimal("6.00"));

    String stateAbbreviation;
    BigDecimal statesTax;
    
    StateTax(String stateAbbreviation, BigDecimal statesTax) {
        this.stateAbbreviation = stateAbbreviation;
        this.statesTax = statesTax;
    }
    
    public BigDecimal getStatesTax(){
        return statesTax;
    }

}
