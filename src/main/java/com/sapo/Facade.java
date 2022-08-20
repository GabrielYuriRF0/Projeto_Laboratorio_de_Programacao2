package com.sapo;

import com.sapo.activity.Activity;
import com.sapo.activity.ActivityController;
import com.sapo.activity.ActivityService;
import com.sapo.person.Person;
import com.sapo.person.PersonController;
import com.sapo.person.PersonService;

public class Facade {

    public Facade(){
    }

    //Metódos de activityController
    public void registerActivity(String name, String description, String cpf){
        this.activityController.registerActivity(name, description, cpf);
    }
    public void concludeActivity(String idActivity){
        this.activityController.concludeActivity(idActivity);
    }
    public void disableActivity(String idActivity){
        this.activityController.disableActivity(idActivity);
    }
    public void reopenActivity(String idActivity){
        this.activityController.reopenActivity(idActivity);
    }
    public String showActivity(String idActivity){
        return this.activityController.showActivity(idActivity);
    }
    public void changeDescription(String idActivity, String newDescription){
        this.activityController.changeDescription(idActivity, newDescription);
    }
    public void changeResponsable(String idActivity, String cpf){
        this.activityController.changeResponsable(idActivity, cpf);
    }
    public String getResponsableName(String idActivity){
        return this.activityController.getResponsableName(idActivity);
    }
}
