package com.sapo.person;


import com.sapo.validator.PersonValidator;

public class PersonController {
    private PersonService personService;
    private PersonValidator personValidator;

    public PersonController(PersonService personService){
        this.personService = personService;
        this.personValidator = new PersonValidator();
    }

    public void registerPerson(String cpf, String name, String[] skills){
        personValidator.validateGeneralString(name);
        personValidator.generalValidate(skills);
        personValidator.cpfValidator(cpf);
        this.personService.registerPerson(new Person(cpf, name, skills));
    }

    public void registerTeacher(String CPF, String name, String siape, String[] disciplines, String[] skills){

    }
    public void registerStudent(String CPF, String name, String registration, int period, String[] skills){

    }

    public void defineTeacherFunction(String CPF, String siape, String[] discipline){

    }

    public void defineStudentFunction(String CPF, String registration, int period){

    }

    public int getLevel(String CPF){
        return 0;
    }
    public String[] listPeople(){
        return null;
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

    public void registerComments(String cpf, String commentary, String authorCpf){
        personValidator.cpfValidator(cpf);
        personValidator.cpfValidator(authorCpf);
        this.personService.registerComments(cpf, commentary, authorCpf);
    }

    public String showComments(String cpf){
        personValidator.cpfValidator(cpf);
        return this.personService.showComments(cpf);
    }

    public String getPersonName(String cpf){
        personValidator.cpfValidator(cpf);
        return this.personService.getPersonName(cpf);
    }
    public Person getPerson(String cpf){
        //TODO validação.
        return this.personService.getPerson(cpf);
    }


}
