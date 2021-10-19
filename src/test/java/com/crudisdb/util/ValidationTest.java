/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudisdb.util;

import com.crudisdb.controller.CustomerController;
import com.crudisdb.model.Customer;
import com.crudisdb.repository.CustomerRepo;
import com.crudisdb.repository.CustomerRepository;
import com.crudisdb.service.CustomerService;
import com.crudisdb.service.CustomerServiceImpl;

import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author b
 */
@DisplayName("Validation Test")
public class ValidationTest {

    Validator validator = new ValidatorService();
    CustomerRepository cr = new CustomerRepo();
    CustomerService cs = new CustomerServiceImpl(cr);
    CustomerController cc = new CustomerController(cs);

   
    @Test
    @DisplayName("Checking empty space name")
    public void testCaseEmptyName() {

        Customer customer = new Customer(0, "  ", "+8801725717136", "medu@gmail.com", "Dhanmondi");

        Map<String, Object> infoMap = cc.save(customer);

        assertEquals(Utility.status.FAILED, infoMap.get("status"));
    }
    
    @Test
    @DisplayName("Checking invalid phone with more than valid numbers")
    public void testCaseInvalidMobile() {
        Customer customer = new Customer(0, "medu", "017257171368", "medu@gmail.com", "Dhanmondi");
        Map<String, Object> infoMap = cc.save(customer);
        assertEquals(Utility.status.FAILED, infoMap.get("status"));
    }
    @Test
    public void testCaseInvalidEmail() {
        Customer customer = new Customer(0, "medu", "01725717136", "medu@gmailcom", "Dhanmondi");
        Map<String, Object> infoMap = cc.save(customer);
        assertEquals(Utility.status.FAILED, infoMap.get("status"));
    }
    
    @Test
    public void testCaseInvalidEmail2() {
        Customer customer = new Customer(0, "medu", "01725717136", "medugmail.com", "Dhanmondi");
        Map<String, Object> infoMap = cc.save(customer);
        assertEquals(Utility.status.FAILED, infoMap.get("status"));
    }

    @Test
    public void testEmpty() {
        String st = "  ";
        boolean isEmpty = validator.isEmpty(st);
        assertEquals(true, isEmpty);
    }

    @Test
    public void testMobile() {

        String mob = "+8801725717136";
        boolean isValid = validator.isValidMobile(mob);
        assertEquals(true, isValid);

    }

    @Test
    @DisplayName("testing email")
    public void testEmail() {
        String email = "khalil@gmail.com";
        boolean isValid = validator.isValidEmail(email);
        assertEquals(true, isValid);
    }

}
