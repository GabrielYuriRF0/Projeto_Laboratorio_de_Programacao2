package com.sapo.validator;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;

import java.util.List;

public class PersonValidator extends Validator  {

    public void generalValidate(String[] skills) {

        if(skills == null){
            throw new IllegalArgumentException("Empty or null attribute!");
        }

    }

    public void cpfValidator(String cpf){
        //FIXME rever implementacao;
        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.assertValid(cpf);
    }
}
