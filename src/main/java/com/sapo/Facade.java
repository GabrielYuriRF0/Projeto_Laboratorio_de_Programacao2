package com.sapo;

import com.sapo.activity.Activity;
import com.sapo.activity.ActivityController;
import com.sapo.person.PersonController;

public class Facade {
    private PersonController personController;
    private ActivityController activityController;
    // todo Atribbute for TaskController

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

    public String addActivity(String name, String description, String CPF){
        return this.activityController.addActivity(name, description, CPF);
    }

    public void endActivity(String id){
        this.activityController.endActivity(id);
    }

    public void disableActivity(String id){
        this.activityController.disableActivity(id);
    }

    public void reopenActivity(String id){
        this.activityController.reopenActivity(id);
    }

    public String displayActivity(String id){
        return this.activityController.displayActivity(id);
    }

    public void changeActivityDescription(String id, String descricao){
        this.activityController.changeActivityDescription(id, descricao);

    }

    public void changeActivityResponsable(String id, String CPF){
        this.activityController.changeActivityResponsable(id, CPF);
    }

    public Activity getActivity(String id){
        return this.activityController.getActivity(id);
    }

    //todo implementar métodos de TaskController

}
