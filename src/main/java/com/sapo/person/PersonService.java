package com.sapo.person;

public class PersonService {
    private PersonRepository personRepository;

    public PersonService(){
        this.personRepository = new PersonRepository();
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

    public void defineTeacherFunction(String cpf, String siape, String[] disciplines){

    }
    public void defineStudentFuncion(String cpf, String registration, int period){

    }
    public void removeFunction(String CPF){

    }
    public int getLevel(String CPF){
        return 0;
    }

    public String[] listPeople(){
        return null;
    }
}
