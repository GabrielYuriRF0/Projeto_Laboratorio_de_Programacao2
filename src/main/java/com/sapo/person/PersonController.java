package com.sapo.person;


import com.sapo.validator.PersonValidator;

public class PersonController {
    private PersonService personService;
    private PersonValidator personValidator;

    public PersonController(PersonService personService){
        this.personService = personService;
    }

    public void registerPerson(String cpf, String name, String[] skills){
        personValidator.generalValidate(name, skills);
        personValidator.cpfValidator(cpf);
        this.personService.registerPerson(new Person(cpf, name, skills));
    }

    public void removePerson(String cpf){
        personValidator.cpfValidator(cpf);
        this.personService.removePerson(cpf);
    }

    public String showPerson(String cpf){
        personValidator.cpfValidator(cpf);
        return this.personService.showPerson(cpf);
    }

    public void setPersonName(String cpf, String newName){
        personValidator.validateGeneralString(newName);
        personValidator.cpfValidator(cpf);
        this.personService.setPersonName(cpf, newName);
    }

    public void setPersonSkills(String cpf, String[] newSkills){
        personValidator.generalValidateStringArray(newSkills);
        personValidator.cpfValidator(cpf);
        this.personService.setPersonSkills(cpf, newSkills);
    }

    public void registerComments(String cpf, Commentary commentary){
        personValidator.cpfValidator(cpf);
        this.personService.registerComments(cpf, commentary);
    }

    public String showComments(String cpf){
        personValidator.cpfValidator(cpf);
        return this.personService.showComments(cpf);
    }

    public String getPersonName(String cpf){
        personValidator.cpfValidator(cpf);
        return this.personService.getPersonName(cpf);
    }
}
