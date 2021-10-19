/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudisdb.util;

import com.crudisdb.model.ValidationModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author b
 */
public class ValidatorService implements Validator {

    @Override
    public boolean isEmpty(String text) {
        return text.trim().equals("");
    }

    @Override
    public boolean isValidMobile(String mobile) {
        String regexMobile = "(\\+8801|01)[0-9]{9}";
        return mobile.matches(regexMobile);
    }

    @Override
    public boolean isValidEmail(String email) {
        String regexEmail = "[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,5}";
        return email.matches(regexEmail);
    }

    @Override
    public List<String> validate(ValidationModel vm, Utility.ValidationType... vtypes) {
        List<String> errors = new ArrayList<>();

        for (Utility.ValidationType vtype : vtypes) {
            switch (vtype) {
                case EMPTY:
                    if (isEmpty(vm.getText())) {
                        errors.add("Name is empty");
                    }

                case MOBILE:
                    if (!isValidMobile(vm.getMobile())) {
                        errors.add("Mobile is not valid");
                    }

                case EMAIL:
                    if (!isValidEmail(vm.getEmail())) {
                        errors.add("Email is not valid");
                    }
            }

        }

        return errors;
    }

}
