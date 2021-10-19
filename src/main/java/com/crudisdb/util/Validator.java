/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudisdb.util;

import com.crudisdb.model.ValidationModel;
import java.util.List;

/**
 *
 * @author b
 */
public interface Validator {

    public boolean isEmpty(String text);

    public boolean isValidMobile(String mobile);

    public boolean isValidEmail(String email);
    public List<String> validate(ValidationModel vm, Utility.ValidationType ...vtypes);

}
