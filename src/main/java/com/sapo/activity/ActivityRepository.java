package com.sapo.activity;

import java.util.*;

public class ActivityRepository {

    private Map<String, Activity> activities;

    public ActivityRepository(){
        this.activities = new HashMap<>();
    }

    public String registerActivity(Activity activity){
        activity.generateId(activities.size());
        this.activities.put(activity.getId(), activity);
        return activity.getId();
    }

    public void concludeActivity(String idActivity){
        if(this.activities.containsKey(idActivity)){
            this.activities.get(idActivity).concludeActivity();
        }
    }
    public void disableActivity(String idActivity){
        if(this.activities.containsKey(idActivity)){
            this.activities.get(idActivity).disableActivity();
        }
    }
    public void reopenActivity(String idActivity){
        if(this.activities.containsKey(idActivity)){
            this.activities.get(idActivity).reopenActivity();
        }
    }
    public String showActivity(String idActivity){
        String result = "";
        if(this.activities.containsKey(idActivity)){
            result = this.activities.get(idActivity).toString();
        }
        return result;
    }
    public void changeDescription(String idActivity, String newDescription){
        if(this.activities.containsKey(idActivity)){
            this.activities.get(idActivity).changeDescription(newDescription);
        }
    }
    public void changeResponsable(String idActivity, String cpf){
        if(this.activities.containsKey(idActivity)){
            this.activities.get(idActivity).changeResponsable(cpf);
        }
    }

    public String getResponsableName(String idActivity){
        String result = "";
        if(this.activities.containsKey(idActivity)){
            result = this.activities.get(idActivity).getResponsableName();
        }
        return result;
    }
}
