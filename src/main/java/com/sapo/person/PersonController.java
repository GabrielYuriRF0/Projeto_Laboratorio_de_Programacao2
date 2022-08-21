package com.sapo.person;


public class PersonController {
    private PersonService personService;

    public PersonController(PersonService personService){
        this.personService = personService;
    }

    public void registerPerson(String cpf, String name, String[] skills){
        this.personService.registerPerson(new Person(cpf, name, skills));
    }

    public void removePerson(String cpf){
        this.personService.removePerson(cpf);
    }

    public String showPerson(String cpf){
        return this.personService.showPerson(cpf);
    }

    public void setPersonName(String cpf, String newName){
        this.personService.setPersonName(cpf, newName);
    }

    public void setPersonSkills(String cpf, String[] newSkills){
        this.personService.setPersonSkills(cpf, newSkills);
    }

    public void registerComments(String cpf, Commentary commentary){
        this.personService.registerComments(cpf, commentary);
    }

    public String showComments(String cpf){
        return this.personService.showComments(cpf);
    }

    public String getPersonName(String cpf){
        return this.personService.getPersonName(cpf);
    }
}
