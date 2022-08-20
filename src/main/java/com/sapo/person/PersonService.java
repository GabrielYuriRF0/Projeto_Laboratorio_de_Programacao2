package com.sapo.person;

public class PersonService {
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public void registerPerson(Person person){
        this.personRepository.registerPerson(person);
    }

    public void removePerson(String cpf){
        this.personRepository.removePerson(cpf);
    }

    public String showPerson(String cpf){
        return this.personRepository.showPerson(cpf);
    }

    public void setPersonName(String cpf, String newName){
        this.personRepository.setPersonName(cpf, newName);
    }

    public void setPersonSkills(String cpf, String[] newSkills){
        this.personRepository.setPersonSkills(cpf, newSkills);
    }

    public void registerComments(String cpf, Commentary commentary){
        this.registerComments(cpf, commentary);
    }

    public String showComments(String cpf){
        return this.personRepository.showComments(cpf);
    }

    public String getPersonName(String cpf){
        return this.personRepository.getPersonName(cpf);
    }

}
