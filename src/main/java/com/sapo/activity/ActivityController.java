package com.sapo.activity;


import com.sapo.person.PersonService;

public class ActivityController {
    private ActivityService activityService;
    private PersonService personService;

    public ActivityController(){
        this.personService = new PersonService();
        this.activityService = new ActivityService(this.personService);
    }

    public void registerActivity(String name, String description, String cpf){
        //todo validar parametros e cpf se existe e se é valido
        this.activityService.registerActivity(new Activity(name, description,cpf));
    }
    public void concludeActivity(String idActivity){
        //todo validar se o id está presente no array
        this.activityService.concludeActivity(idActivity);
    }
    public void disableActivity(String idActivity){
        //todo validar se o id está presente no array
        this.activityService.disableActivity(idActivity);
    }
    public void reopenActivity(String idActivity){
        //todo validar se o id está presente no array
        this.activityService.reopenActivity(idActivity);
    }
    public String showActivity(String idActivity){
        //todo validar se o id está presente no array
        return this.activityService.showActivity(idActivity);
    }

    public void changeDescription(String idActivity, String newDescription){
        //todo validar se o id está presente no array
        this.activityService.changeDescription(idActivity, newDescription);
    }
    public void changeResponsable(String idActivity, String cpf){
        //todo validar se o id está presente no array
        //todo checar se o cpf é valido e está cadastrado
        this.activityService.changeResponsable(idActivity, cpf);
    }
    public String getResponsableName(String idActivity){
        //todo validar se o id está presente no array
        return this.activityService.getResponsableName(idActivity);
    }
}
