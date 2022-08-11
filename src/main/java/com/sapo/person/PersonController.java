package com.sapo.person;

import com.sapo.validators.CommentaryValidator;
import com.sapo.validators.PersonValidator;

import java.util.NoSuchElementException;



public class PersonController {
    private final PersonRepository pr = new PersonRepository();
    private final PersonValidator validator = new PersonValidator();
    private final CommentaryValidator commentaryValidator = new CommentaryValidator();

    public void registerPerson(String cpf, String name, String[] skills){
        if(!(validator.nameValidator(name)) || !(validator.cpfValidator(cpf)) || !(validator.skillsValidator(skills))){
            throw  new IllegalArgumentException("Invalid attribute");
        }

        pr.registerPerson(new Person(cpf,name,skills));

    }

    public String showPerson(String cpf){
        if(validator.cpfValidator(cpf) == false){
            throw  new IllegalArgumentException("Invalid attribute");

        }
        else if(pr.checkRegistration(cpf) == false){
            throw new NoSuchElementException("Invalid ID");
        }

        return pr.searchPerson(cpf).toString();

    }

    public void setPersonName(String cpf, String newName){
        if(validator.cpfValidator(cpf) == false || validator.nameValidator(newName)){
            throw  new IllegalArgumentException("Invalid attribute");

        }
        else if(pr.checkRegistration(cpf) == false){
            throw new NoSuchElementException("Invalid ID");
        }

        pr.searchPerson(cpf).setName(newName);

    }

    public void setPersonSkills(String cpf, String[] newSkills){
        if(validator.cpfValidator(cpf) == false || validator.skillsValidator(newSkills) == false){
            throw  new IllegalArgumentException("Invalid attribute");
        }
        else if(pr.checkRegistration(cpf) == false){
            throw new NoSuchElementException("Invalid ID");
        }
        pr.searchPerson(cpf).setSkills(newSkills);
    }

    public void deletePerson(String cpf){
        if(validator.cpfValidator(cpf) == false){
            throw new IllegalArgumentException("Invalid attribute");
        }
        else if(pr.checkRegistration(cpf) == false){
            throw new NoSuchElementException("Invalid ID");
        }
        pr.deletePerson(cpf);
    }

    public void addPersonCommentary(String cpf, String description, String author){
        if(validator.cpfValidator(cpf) == false || validator.cpfValidator(author) == false ||commentaryValidator.descriptionValidator(description) == false){
            throw new IllegalArgumentException("Invalid attribute");
        }
        else if(pr.checkRegistration(cpf) == false || pr.checkRegistration(author) == false){
            throw new NoSuchElementException("Invalid ID");
        }
        pr.searchPerson(cpf).addCommentary(new Commentary(description,author));
    }

    public String showPersonComments(String cpf){
        if(validator.cpfValidator(cpf) == false){
            throw new IllegalArgumentException("Invalid attribute");
        }
        else if(pr.checkRegistration(cpf) == false){
            throw new NoSuchElementException("Invalid ID");
        }
        return pr.searchPerson(cpf).showComments();
    }


}
