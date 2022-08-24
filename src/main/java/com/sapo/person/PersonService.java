package com.sapo.person;

import com.sapo.activity.Activity;
import com.sapo.activity.ActivityRepository;
import com.sapo.activity.ActivityService;
import com.sapo.tasks.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PersonService {
    private PersonRepository personRepository;
    private ActivityService activityService;

    public PersonService(ActivityService activityService){
        this.personRepository = new PersonRepository();
        this.activityService = activityService;
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

    public void registerComments(String cpf, String commentary, String authorCpf){
        this.personRepository.registerComments(cpf, commentary, authorCpf);
    }

    public String showComments(String cpf){
        return this.personRepository.showComments(cpf);
    }

    public String getPersonName(String cpf){
        return this.personRepository.getPersonName(cpf);
    }

    public Person getPerson(String cpf){
        return this.personRepository.getPerson(cpf);
    }

    public Map<String, Person> getPeople(){
        return this.personRepository.getPeople();
    }
}
