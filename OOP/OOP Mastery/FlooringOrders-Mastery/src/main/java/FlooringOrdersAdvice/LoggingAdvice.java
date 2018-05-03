/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlooringOrdersAdvice;

import FlooringOrdersDAO.FlooringOrderAuditDao;
import FlooringOrdersDAO.PersistenceException;
import java.time.LocalDate;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author laptop
 */
public class LoggingAdvice {
      FlooringOrderAuditDao auditDao;
 
    public LoggingAdvice(FlooringOrderAuditDao auditDao) {
        this.auditDao = auditDao;
    }
 
    public void createAuditEntry(JoinPoint jp) {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ": ";
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (PersistenceException e) {
            System.err.println(
               "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
    
    
        public void createExceptionThrownEntry(JoinPoint jp) {
        Object[] args = jp.getArgs();
        String auditEntry =  "User selected save while in Training mode: " + LocalDate.now();
//        String auditEntry = jp.getSignature().getName() + ": ";
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (PersistenceException e) {
            System.err.println(
               "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
    
}
