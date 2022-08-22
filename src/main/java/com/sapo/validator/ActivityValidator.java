package com.sapo.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActivityValidator extends Validator{
    public void idValidator(String idActivity){
        String[] vowelsAndNumbers = new String[]{"a","A","e","E","i","I","o","O","u","U"," ","b", "c", "d", "f", "g",
                "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "y", "z"};
        if(idActivity.isEmpty()){
            throw new IllegalArgumentException("Id cannot be null or blank");
        }else{
            for (String vowelsAndNumber : vowelsAndNumbers) {
                if (idActivity.contains(vowelsAndNumber)) {
                    throw new IllegalArgumentException("Invalid ID");
                }
            }
        }
    }
}
