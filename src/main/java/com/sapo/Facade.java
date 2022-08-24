package com.sapo;

import com.sapo.activity.Activity;
import com.sapo.activity.ActivityController;
import com.sapo.activity.ActivityService;
import com.sapo.person.Commentary;
import com.sapo.person.Person;
import com.sapo.person.PersonController;
import com.sapo.person.PersonService;
import com.sapo.search.SearchController;
import com.sapo.search.SearchService;
import com.sapo.tasks.*;

import java.util.List;

public class Facade {

    private PersonController personController;
    private ActivityController activityController;
    private TaskController taskController;
    private SearchController searchController;
    private ManageTaskController manageTaskController;

    public Facade(){
        var personService = new PersonService();
        var activityService = new ActivityService(personService);
        var taskService = new TaskService(activityService, personService);
        var searchService = new SearchService(personService,activityService,taskService);
        var manageTaskService = new ManageTaskService(activityService);

        this.personController = new PersonController(personService);
        this.activityController = new ActivityController(activityService);
        this.taskController = new TaskController(taskService);
        this.searchController = new SearchController(searchService);
        this.manageTaskController = new ManageTaskController(manageTaskService);
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

    public void registerComments(String cpf, String commentary, String authorCpf){
        this.personController.registerComments(cpf ,commentary, authorCpf);
    }

    public String showComments(String cpf){
        return this.personController.showComments(cpf);
    }

    public String getPersonName(String cpf){
        return this.personController.getPersonName(cpf);
    }

    public Person getPerson(String cpf){
        return this.personController.getPerson(cpf);
    }

    //Metódos de activityController
    public String registerActivity(String name, String description, String cpf){
        return this.activityController.registerActivity(name, description, cpf);
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
    public Activity getActivity(String idActivity){
        return this.activityController.getActivity(idActivity);
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
        return this.taskController.showTask(idTask);

    }

    public void addPersonTask(String cpf, String idTask){
        this.taskController.addPersonTask(cpf, idTask);
    }

    public void removePersonTask(String cpf, String idTask){
        this.taskController.removePersonTask(cpf, idTask);
    }

    public Task getTask(String idTask){
        return this.taskController.getTask(idTask);
    }
    //Métodos de SearchController

    public List<String> searchPerson(String terms){
        return this.searchController.searchPerson(terms);
    }

    public List<String> searchActivity(String terms){
        return this.searchController.searchActivity(terms);
    }

    /*public List<String> searchTask(String name){
        return this.searchController.searchTask(name);
    }

    public List<String> searchTask(String idActivity, String name){
        return this.searchController.searchTask(idActivity,name);
    }

    public List<String> sugestTasks(String cpf){
        return this.searchController.sugestTasks(cpf);
    }
    */
    public List<String> recentSearch(int searchNumbers){
        return this.searchController.recentSearch(searchNumbers);
    }

    public List<String> showSearchHistoric(int searchId){
        return this.searchController.showSearchHistoric(searchId);
    }

    // Métodos referentes a ManageTask
    public String registerManageTask(String idActivity, String name,  String[] idsTasks){
        return this.manageTaskController.registerManageTask(idActivity,name ,idsTasks);

    }
    public void addInManageTask(String idManageTask, String idTask){
        this.manageTaskController.addInManageTask(idManageTask,idTask);
    }

    public void removeTask(String idManageTask, String idTask){
        this.manageTaskController.removeTask(idManageTask,idTask);
    }

    public int countTasksInManage(String idManageTask){
        return this.manageTaskController.countTasksInManage(idManageTask);
    }
}
