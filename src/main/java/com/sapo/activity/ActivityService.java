package com.sapo.activity;

import com.sapo.person.PersonService;

public class ActivityService {
    private ActivityRepository activityRepository;
    private PersonService personService;

    public ActivityService(PersonService personService){
        this.personService = personService;
        this.activityRepository = new ActivityRepository();
    }

    public void registerActivity(Activity activity){
        if(activity.getStatus().equals("STARTED")){
            activity.setResponsableName(this.personService.getPersonName(activity.getCpf()));
            this.activityRepository.registerActivity(activity);
        }else{
            throw new IllegalArgumentException("Invalid Atributte");
        }
    }

    public void concludeActivity(String idActivity){
        this.activityRepository.concludeActivity(idActivity);
    }
    public void disableActivity(String idActivity){
        this.activityRepository.disableActivity(idActivity);
    }
    public void reopenActivity(String idActivity){
        this.activityRepository.reopenActivity(idActivity);
    }
    public String showActivity(String idActivity){
        return this.activityRepository.showActivity(idActivity);
    }

    public void changeDescription(String idActivity, String newDescription){
        this.activityRepository.changeDescription(idActivity, newDescription);
    }
    public void changeResponsable(String idActivity, String cpf){
        this.activityRepository.changeResponsable(idActivity, cpf, this.personService.getPersonName(cpf));
    }
    public String getResponsableName(String idActivity){
        return this.activityRepository.getResponsableName(idActivity);
    }

    public Activity recoverActivity(String idActivity){
        return this.activityRepository.recoverActivity(idActivity);
    }
}
