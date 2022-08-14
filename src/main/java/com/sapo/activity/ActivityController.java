package com.sapo.activity;

import com.sapo.person.Person;
import com.sapo.person.PersonRepository;
import com.sapo.person.PersonService;
import com.sapo.validators.ActivityValidator;
import com.sapo.validators.PersonValidator;

import javax.accessibility.AccessibleAction;
import java.util.NoSuchElementException;

public class ActivityController {
    private ActivityService as;
    private ActivityValidator av;
    private PersonValidator pv;
    private  PersonRepository pr;
    private ActivityRepository ar;

    private PersonService ps;

    public ActivityController(){
        as = new ActivityService();
        av = new ActivityValidator();
        pv = new PersonValidator();
        pr = new PersonRepository();
        ar = new ActivityRepository();
        ps = new PersonService();
    }

    public String addActivity(String name, String description, String cpf){
        boolean checkRegistration = this.ps.checkRegistration(cpf);
        if(checkRegistration){
            this.av.descriptionValidator(description);
            this.pv.nameValidator(name);
            this.pv.cpfValidator(cpf);
            return this.as.addActivity(new Activity(name, description, cpf));
        }
        else{
            throw new NoSuchElementException("Invalid ID");
        }

    }

    public void endActivity(String id){
        this.ar.searchIdInRepository(id);
        this.as.endActivity(id);
    }

    public void disableActivity(String id){
        this.ar.searchIdInRepository(id);
        this.as.disableActivity(id);
    }

    public void reopenActivity(String id){
        this.ar.searchIdInRepository(id);
        this.as.reopenActivity(id);
    }

    public String displayActivity(String id){
        this.ar.searchIdInRepository(id);
        return this.as.displayActivity(id);
    }

    public void changeActivityDescription(String id, String descricao){
        this.ar.searchIdInRepository(id);
        this.as.changeActivityDescription(id, descricao);
    }

    public void changeActivityResponsable(String id, String CPF){
        this.ar.searchIdInRepository(id);
        this.as.changeActivityResponsable(id, CPF);
    }

    public Activity getActivity(String id){
        return ar.getActivity(id);
    }
}
