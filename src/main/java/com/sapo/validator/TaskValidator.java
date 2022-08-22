package com.sapo.validator;

public class TaskValidator extends Validator{
    public void validateHour(int hour){
        if(hour <= 0){
            throw new IllegalArgumentException("invalid hour");
        }
    }
}
