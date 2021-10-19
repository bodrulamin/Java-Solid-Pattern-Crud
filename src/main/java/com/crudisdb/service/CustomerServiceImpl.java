/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudisdb.service;

import com.crudisdb.model.Customer;
import com.crudisdb.model.ValidationModel;
import com.crudisdb.repository.CustomerRepo;
import com.crudisdb.repository.CustomerRepository;
import com.crudisdb.util.Utility;
import com.crudisdb.util.Validator;
import com.crudisdb.util.ValidatorService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;
    Validator validator;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        validator = new ValidatorService();

    }

    @Override
    public Map<String, Object> save(Customer customer) {
        Map<String, Object> infoMap = new HashMap<>();

        ValidationModel vm = new ValidationModel(customer.getName(), customer.getMobile(), customer.getEmail());

        List<String> errorList = validator.validate(vm, Utility.ValidationType.EMPTY, Utility.ValidationType.MOBILE, Utility.ValidationType.EMAIL);

        Customer exitedCustomer = customerRepository.getCustomerByMobile(customer.getMobile());
        Customer exitedCustomer2 = customerRepository.getCustomerByEmail(customer.getEmail());

        if (exitedCustomer != null) {
            errorList.add("mobile already exist");
        }
        if (exitedCustomer2 != null) {
            errorList.add("email already exist");
        }

        if (errorList.isEmpty()) {
            customerRepository.save(customer);
            infoMap.put("status",Utility.status.SUCCESS);
            infoMap.put("msg","Saved Successfully");
       

        }else {
            infoMap.put("status", Utility.status.FAILED);
            infoMap.put("msg", "Save Failed");
            infoMap.put("errors",errorList);
        }

        return infoMap;

    }

    @Override
    public List<Customer> getAllCustomers() {

        return customerRepository.getAllCustomers();
    }

}
