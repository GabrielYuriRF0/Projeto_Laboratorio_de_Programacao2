package com.sapo.person;

import com.sapo.validators.CommentaryValidator;
import com.sapo.validators.PersonValidator;

import javax.xml.validation.Validator;
import java.util.NoSuchElementException;



public class PersonController {
    private  PersonService personService;
    private  PersonValidator validator;
    private  CommentaryValidator commentaryValidator;

    public PersonController(PersonService personService){
        this.personService = personService;
        this.validator = new PersonValidator();
        this.commentaryValidator = new CommentaryValidator();
    }

    public void registerPerson(String cpf, String name, String[] skills){
        if(!(validator.nameValidator(name)) || !(validator.cpfValidator(cpf)) || !(validator.skillsValidator(skills))){
            throw  new IllegalArgumentException("Invalid attribute");
        }

        else if (skills[0].isEmpty() || skills[0].isBlank()){
            this.personService.registerPerson(new Person(cpf, name));
        }

        else{

            this.personService.registerPerson(new Person(cpf,name,skills));

        }


    }
    //TODO refactor to validator.

    public String showPerson(String cpf){
        if(validator.cpfValidator(cpf) == false){
            throw  new IllegalArgumentException("Invalid attribute");

        }
        else if(this.personService.checkRegistration(cpf) == false){
            throw new NoSuchElementException("Invalid ID");
        }

        return this.personService.searchPerson(cpf).toString();
    }

    public void setPersonName(String cpf, String newName){
        if(validator.cpfValidator(cpf) == false || validator.nameValidator(newName)){
            throw  new IllegalArgumentException("Invalid attribute");

        }
        else if(this.personService.checkRegistration(cpf) == false){
            throw new NoSuchElementException("Invalid ID");
        }

        this.personService.searchPerson(cpf).setName(newName);

    }

    public void setPersonSkills(String cpf, String[] newSkills){
        if(validator.cpfValidator(cpf) == false || validator.skillsValidator(newSkills) == false){
            throw  new IllegalArgumentException("Invalid attribute");
        }
        else if(this.personService.checkRegistration(cpf) == false){
            throw new NoSuchElementException("Invalid ID");
        }
        this.personService.searchPerson(cpf).setSkills(newSkills);
    }

    public void deletePerson(String cpf){
        if(validator.cpfValidator(cpf) == false){
            throw new IllegalArgumentException("Invalid attribute");
        }
        else if(this.personService.checkRegistration(cpf) == false){
            throw new NoSuchElementException("Invalid ID");
        }
        this.personService.deletePerson(cpf);
    }

    public void addPersonCommentary(String cpf, String description, String author){
        if(validator.cpfValidator(cpf) == false || validator.cpfValidator(author) == false ||commentaryValidator.descriptionValidator(description) == false){
            throw new IllegalArgumentException("Invalid attribute");
        }
        else if(this.personService.checkRegistration(cpf) == false || this.personService.checkRegistration(author) == false){
            throw new NoSuchElementException("Invalid ID");
        }
        this.personService.searchPerson(cpf).addCommentary(new Commentary(description,author));
    }

    public String showPersonComments(String cpf){
        if(validator.cpfValidator(cpf) == false){
            throw new IllegalArgumentException("Invalid attribute");
        }
        else if(this.personService.checkRegistration(cpf) == false){
            throw new NoSuchElementException("Invalid ID");
        }
        return this.personService.searchPerson(cpf).showComments();
    }

    // FIXME rever implementação desse método:
    public boolean checkRegistration(String cpf){
        return this.personService.checkRegistration(cpf);
    }




}
