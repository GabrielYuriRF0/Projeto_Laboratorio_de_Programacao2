package com.sapo.validator;

abstract class Validator {

    public void validateGeneralString(String attribute){
        if(attribute == null){
            throw  new IllegalArgumentException("Null");
        }
        else if(attribute.isBlank()){
            throw new IllegalArgumentException("Empty or null attribute!");
        }
    }

    public void generalValidateStringArray(String[] attribute){
        if(attribute == null){
            throw new IllegalArgumentException("Empty or null attribute!");

        }
    }
}
