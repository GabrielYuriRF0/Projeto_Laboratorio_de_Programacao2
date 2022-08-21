package com.sapo.validator;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;

import java.util.List;

public class PersonValidator {

    public void generalValidadate(String cpf, String name, String skills) {
        if(cpf.isEmpty() || name.isEmpty() || skills.isEmpty()){
            throw new IllegalArgumentException("Empty or null attribute!");
        }

    }

    public void cpfValidator(String cpf){
        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.assertValid(cpf);
        List<ValidationMessage> erros = cpfValidator.invalidMessagesFor(cpf);
        if(erros.isEmpty() == false){
            throw new IllegalArgumentException("Invalid cpf!");
        }

    }
}
