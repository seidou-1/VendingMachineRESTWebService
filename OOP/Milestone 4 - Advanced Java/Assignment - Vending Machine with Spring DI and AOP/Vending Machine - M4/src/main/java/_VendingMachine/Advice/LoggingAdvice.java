/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _VendingMachine.Advice;

import VendingMachineDao.PersistenceException;
import VendingMachineDao.VendingMachineAuditDao;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author laptop
 */
public class LoggingAdvice {

    /*
    Add a member field to get access to the VendingMachineAuditDao class
     */
    VendingMachineAuditDao auditDao;

    public LoggingAdvice(VendingMachineAuditDao auditDao) {
        this.auditDao = auditDao;
    }

    /*
    Add the functionality of the logging advice
     */
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
}
