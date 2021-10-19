 
package com.crudisdb.controller;

import com.crudisdb.model.Customer;
import com.crudisdb.service.CustomerService;
import java.util.List;
import java.util.Map;

 
public class CustomerController {
    
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
     
   public Map<String, Object> save(Customer customer){
        return  customerService.save(customer);
    }
    
  public  List<Customer> getAllCustomer(){
        return customerService.getAllCustomers();
    }
   
  
     
}
