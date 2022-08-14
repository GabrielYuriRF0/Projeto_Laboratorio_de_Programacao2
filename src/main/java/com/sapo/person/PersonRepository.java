package com.sapo.person;

import java.util.HashMap;
import java.util.Map;

public class PersonRepository {
    public Map<String,Person> people;

    public PersonRepository(){
        this.people = new HashMap<>();
    }

    public void registerPerson(Person person){
        people.put(person.getCpf(),person);
    }

    public Person searchPerson(String cpf){
        return this.people.get(cpf);

    }

    public void deletePerson(String cpf){
        this.people.remove(cpf);
    }

    public void addPersonCommentary(String cpf, Commentary commentary){
        this.people.get(cpf).addCommentary(commentary);

    }
    public boolean checkRegistration(String cpf){
        return people.containsKey(cpf);
    }

}
