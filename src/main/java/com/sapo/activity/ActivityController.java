package com.sapo.activity;

public class ActivityController {
    private ActivityService as;
    private ActivityValidator validator;

    public String addActivity(String name, String description, String CPF){
        this.validator.validator(name, description, CPF);
        return this.as.addActivity(new Activity(name, description, CPF));
    }

    public void endActivity(String id){
        this.as.endActivity(id);
    }

    public void disableActivity(String id){
        this.as.disableActivity(id);
    }

    public void reopenActivity(String id){
        this.as.reopenActivity(id);
    }

    public String displayActivity(String id){
        return this.as.displayActivity(id);
    }

    public void changeActivityDescription(String id, String descricao){
        this.as.changeActivityDescription(id, descricao);
    }

    public void changeActivityResponsable(String id, String CPF){
        this.as.changeActivityResponsable(id, CPF);
    }
}
