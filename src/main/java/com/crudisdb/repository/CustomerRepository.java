/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudisdb.repository;

import com.crudisdb.model.Customer;
import java.util.List;

 
public interface CustomerRepository {
    public Customer save(Customer customer);
    public Customer getCustomerByEmail(String email);
    public Customer getCustomerByMobile(String mobile);
    public List<Customer> getAllCustomers();
}
