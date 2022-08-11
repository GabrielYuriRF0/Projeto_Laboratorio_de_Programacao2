package com.sapo.activity;

public class ActivityValidator {
    public void validator(String name, String description, String CPF){
        if(name.isBlank() || description.isBlank() || CPF.isBlank()){
            throw new IllegalArgumentException("Não pode ser vazio");
        }
    }
}
