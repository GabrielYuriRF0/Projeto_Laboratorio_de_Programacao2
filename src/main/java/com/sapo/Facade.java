package com.sapo;

import com.sapo.activity.Activity;
import com.sapo.activity.ActivityController;
import com.sapo.activity.ActivityService;
import com.sapo.person.Commentary;
import com.sapo.person.Person;
import com.sapo.person.PersonController;
import com.sapo.person.PersonService;
import com.sapo.tasks.TaskController;
import com.sapo.tasks.TaskService;

public class Facade {

    private PersonController personController;
    private ActivityController activityController;
    private TaskController taskController;
    public Facade(){
        var personService = new PersonService();
        var activityService = new ActivityService(personService);
        var taskService = new TaskService(activityService); //TODO talvez eu passe o personService como parametro tb, nao sei se da pra utilizar o personservice ja de activity.

        this.personController = new PersonController(personService);
        this.activityController = new ActivityController(activityService);
        this.taskController = new TaskController(taskService);
        //ATÉ ENTAO TA CERTO.
    }

    //Métodos de PersonController
    public void registerPerson(String cpf, String name, String[] skills){
        this.personController.registerPerson(cpf, name, skills);
    }

    public void removePerson(String cpf){
        this.personController.removePerson(cpf);
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

    public void registerComments(String cpf, Commentary commentary){
        this.personController.registerComments(cpf, commentary);
    }

    public String showComments(String cpf){
        return this.personController.showComments(cpf);
    }

    public String getPersonName(String cpf){
        return this.personController.getPersonName(cpf);
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

    //---------------------------------------------TASK-------------------------------------------------------------
    public String registerTask(String idActivity, String name, String[] skills){
        return this.taskController.registerTask(idActivity,name,skills);
    }

    public void setNameTask(String idTask, String newName){
        this.taskController.setName(idTask, newName);
    }

    public void setSkillsTask(String idTask, String[] skills){
        this.taskController.setSkills(idTask, skills);
    }

    public void addHourTask(String idTask, int hour){
        this.taskController.addHour(idTask, hour);
    }

    public void removeHourTask(String idTask, int hour){
        this.taskController.removeHour(idTask, hour);
    }

    public void concludeTask(String idTask){
        this.taskController.concludeTask(idTask);
    }

    public void removeTask(String idTask){
        this.taskController.removeTask(idTask);
    }

    public String showTask(String idTask){
        //TODO dps.
        return "";

    }

    public void addPersonTask(String cpf, String idTask){
        //TODO dps.
    }

    public void removePersonTask(String cpf, String idTask){
        //TODO dps.
    }



}
