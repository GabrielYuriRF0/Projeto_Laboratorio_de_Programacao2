package com.sapo.person;

import com.sapo.activity.Activity;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class PersonRepository {
    private Map<String, Person> people;

    public PersonRepository(){
        this.people = new HashMap<>();
    }

    public void registerPerson(Person person){
        this.people.put(person.getCpf(),person);
    }

    public void removePerson(String cpf){
        checkRegistration(cpf);
        this.people.remove(cpf);
    }

    public String showPerson(String cpf){
        checkRegistration(cpf);
        return this.people.get(cpf).toString();
    }

    public void setPersonName(String cpf, String newName){
        checkRegistration(cpf);
        this.people.get(cpf).setName(newName);
    }

    public void setPersonSkills(String cpf, String[] newSkills){
        checkRegistration(cpf);
        this.people.get(cpf).setSkills(newSkills);
    }

    public void registerComments(String cpf, String commentary, String authorCpf){
        checkRegistration(cpf);
        checkRegistration(authorCpf);
        String authorName = people.get(authorCpf).getName();
        this.people.get(cpf).registerCommentary(new Commentary(commentary, authorName));
    }

    public String showComments(String cpf){
        checkRegistration(cpf);
        return this.people.get(cpf).showComments();
    }

    public String getPersonName(String cpf){
        checkRegistration(cpf);
        return this.people.get(cpf).getName();
    }

    private void checkRegistration(String cpf){
        if(this.people.containsKey(cpf) == false){
            throw new NoSuchElementException("This cpf is not registered in the system!");
        }
    }

    public Person getPerson(String cpf){
        checkRegistration(cpf);
        return this.people.get(cpf);
    }

    public String getFunction(String CPF){
        checkRegistration(CPF);
        return this.people.get(CPF).getFunction();
    }
    public void defineTeacherFunction(String CPF, String siape, String[] disciplines){
        checkRegistration(CPF);
        this.people.put(CPF, new Teacher(CPF, this.people.get(CPF).getName(), siape, this.people.get(CPF).getSkills(), disciplines));
        this.people.get(CPF).setFunction("TEACHER");
    }

    public void defineStudentFunction(String CPF, String registration, int period){
        checkRegistration(CPF);
        this.people.put(CPF, new Student(CPF, this.people.get(CPF).getName(), registration, period, this.people.get(CPF).getSkills()));
        this.people.get(CPF).setFunction("STUDENT");
    }

    public void removeFunction(String CPF){
        checkRegistration(CPF);
        this.people.get(CPF).setFunction("NO FUNCTION");
    }

    public float getLevel(String CPF){
        checkRegistration(CPF);
        return 0;
    }

    public String[] listPeople(){
        return null;
    }

    public Map<String, Person> getPeople(){
        return this.people;
    }
}
