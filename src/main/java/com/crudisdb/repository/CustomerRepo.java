/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudisdb.repository;

import com.crudisdb.model.Customer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author b
 */
public class CustomerRepo implements CustomerRepository {

    List<Customer> customerList = new ArrayList<>();

    @Override
    public Customer save(Customer customer) {
        boolean isAdded = customerList.add(customer);
        if (isAdded) {
            return customer;
        }
        return null;
    }

    @Override
    public Customer getCustomerByEmail(String email) {
    
        for (Customer customer : customerList) {
           if(email.equalsIgnoreCase(customer.getEmail())){
               return customer;
           }
        }
        
        return null;        
    }

    @Override
    public Customer getCustomerByMobile(String mobile) {
        
        for (Customer customer : customerList) {
            if (mobile.equals(customer.getMobile())) {
                return customer;
            }
        }
        
         return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerList;
    }

}
