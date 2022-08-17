package com.sapo.person;

import java.util.Map;

public class PersonService {
    private  PersonRepository personRepository;

    public PersonService(){
        this.personRepository = new PersonRepository();
    }

    public PersonService(Map<String, Person> people){
        this.personRepository = new PersonRepository(people);
    }


    public void registerPerson(Person person){
        this.personRepository.registerPerson(person);
    }

    public Person searchPerson(String cpf){
        return this.personRepository.searchPerson(cpf);
    }

    public String showPerson(String cpf){
        return this.personRepository.searchPerson(cpf).toString();
    }

    public void deletePerson(String cpf){
        this.personRepository.deletePerson(cpf);
    }

    public void addPersonCommentary(String cpf, Commentary commentary){
        this.personRepository.addPersonCommentary(cpf, commentary);

    }
    public boolean checkRegistration(String cpf){
        return personRepository.checkRegistration(cpf);
    }
}
