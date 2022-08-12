package com.sapo;

import com.sapo.activity.ActivityController;
import com.sapo.person.PersonController;

public class Facade {
    private PersonController personController;
    private ActivityController activityController;
    //todo Atribbute for TaskController

    public Facade(){
        this.personController = new PersonController();
        this.activityController = new ActivityController();
    }

    public void registerPerson(String cpf, String name, String[] skills){
        this.personController.registerPerson(cpf, name, skills);
    }

    public String showPerson(String cpf){
        return this.personController.showPerson(cpf);
    }

    public void setPersonName(String cpf, String newName){
        this.personController.setPersonName(cpf, newName);
    }

    public void setPersonSkills(String cpf, String[] newSkills){
        this.personController.setPersonSkills(cpf, newSkills);
    }

    public void deletePerson(String cpf){
        this.personController.deletePerson(cpf);
    }

    public void addPersonCommentary(String cpf, String description, String author){
        this.personController.addPersonCommentary(cpf, description, author);
    }

    public String showPersonComments(String cpf){
        return this.personController.showPersonComments(cpf);
    }








}
