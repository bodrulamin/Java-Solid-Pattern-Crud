/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudisdb.service;

// satus, msg, errorlist

import com.crudisdb.model.Customer;
import java.util.List;
import java.util.Map;


 
 
public interface CustomerService {
   Map<String,Object> save(Customer customer);
   List<Customer> getAllCustomers();  
    
}
