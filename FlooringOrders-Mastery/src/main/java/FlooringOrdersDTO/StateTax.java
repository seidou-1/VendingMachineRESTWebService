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

    OH(new BigDecimal("6.25")),
    PA(new BigDecimal("6.75")),
    MI(new BigDecimal("5.75")),
    IN(new BigDecimal("6.00"));

    BigDecimal statesTax;

    StateTax(BigDecimal statesTax) {
        this.statesTax = statesTax;
    }
    
    public BigDecimal getStatesTax(){
        return statesTax;
    }

}
