package com.sapo.activity;


import com.sapo.person.Person;
import com.sapo.person.PersonService;
import com.sapo.validator.ActivityValidator;
import com.sapo.validator.PersonValidator;

public class ActivityController {
    private ActivityService activityService;
    private ActivityValidator validator;
    private PersonValidator personValidator;

    public ActivityController(ActivityService activityService){
        this.activityService = activityService;
        this.validator = new ActivityValidator();
        this.personValidator = new PersonValidator();
    }

    public String registerActivity(String name, String description, String cpf){
        this.validator.validateGeneralString(name);
        this.validator.validateGeneralString(description);
        this.validator.validateGeneralString(cpf);
        this.personValidator.cpfValidator(cpf);
        return this.activityService.registerActivity(new Activity(name, description,cpf));
    }
    public void concludeActivity(String idActivity){
        this.validator.idValidator(idActivity);
        if(this.activityService.recoverActivity(idActivity).getStatus().equals("STARTED")){
            this.activityService.concludeActivity(idActivity);
        }else{
            throw new IllegalStateException("Invalid Operation!");
        }
    }
    public void disableActivity(String idActivity){
        this.validator.idValidator(idActivity);
        if(this.activityService.recoverActivity(idActivity).getStatus().equals("STARTED")) {
            this.activityService.disableActivity(idActivity);
        }else{
            throw new IllegalStateException("Invalid Operation!");
        }
    }
    public void reopenActivity(String idActivity){
        this.validator.idValidator(idActivity);
        if(!this.activityService.recoverActivity(idActivity).getStatus().equals("STARTED")) {
            this.activityService.reopenActivity(idActivity);
        }else{
            throw new IllegalStateException("Invalid Operation!");
        }
    }
    public String showActivity(String idActivity){
        this.validator.idValidator(idActivity);
        return this.activityService.showActivity(idActivity);
    }

    public void changeDescription(String idActivity, String newDescription){
        this.validator.idValidator(idActivity);
        if(this.activityService.recoverActivity(idActivity).getStatus().equals("STARTED")) {
            this.activityService.changeDescription(idActivity, newDescription);
        }else{
            throw new IllegalArgumentException("Invalid Atributte");
        }
    }
    public void changeResponsable(String idActivity, String cpf){
        this.validator.idValidator(idActivity);
        this.personValidator.cpfValidator(cpf);
        if(this.activityService.recoverActivity(idActivity).getStatus().equals("STARTED")) {
            this.activityService.changeResponsable(idActivity, cpf);
        }else{
            throw new IllegalArgumentException("Invalid Atributte");
        }
    }
    public String getResponsableName(String idActivity){
        this.validator.idValidator(idActivity);
        return this.activityService.getResponsableName(idActivity);
    }
    public Activity getActivity(String idActivity){
        return this.activityService.recoverActivity(idActivity);
    }
}
