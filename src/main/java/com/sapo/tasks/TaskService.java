package com.sapo.tasks;

import com.sapo.activity.Activity;
import com.sapo.activity.ActivityService;
import com.sapo.person.PersonService;

public class TaskService {
    private ActivityService activityService;
    private PersonService personService;
    public TaskService(ActivityService activityService, PersonService personService){
        this.activityService = activityService;
        this.personService = personService;
    }

    public String registerTask(Task task, String idActivity){
        Activity ac = this.activityService.recoverActivity(idActivity);
        TaskRepository tasks = ac.getTasks();
        int qntTasksAtividade = tasks.quantityTasks();
        return tasks.registerTask(task, idActivity, qntTasksAtividade);
    }

    public void setName(String idTask, String newName){
        String[] idActivityArray = idTask.split("-");
        String idActivity = idActivityArray[0] + "-" + idActivityArray[1];
        Activity ac = this.activityService.recoverActivity(idActivity);
        TaskRepository tasks = ac.getTasks();
        tasks.setName(idTask, newName);
    }

    public void setSkills(String idTask, String[] newSkills){
        String[] idActivityArray = idTask.split("-");
        String idActivity = idActivityArray[0] + "-" + idActivityArray[1];
        Activity ac = this.activityService.recoverActivity(idActivity);
        TaskRepository tasks = ac.getTasks();
        tasks.setSkills(idTask, newSkills);
    }

    public void addHour(String idTask, int hour){
        String[] idActivityArray = idTask.split("-");
        String idActivity = idActivityArray[0] + "-" + idActivityArray[1];
        Activity ac = this.activityService.recoverActivity(idActivity);
        TaskRepository tasks = ac.getTasks();
        tasks.addHour(idTask,hour);
    }

    public void removeHour(String idTask, int hour){
        String[] idActivityArray = idTask.split("-");
        String idActivity = idActivityArray[0] + "-" + idActivityArray[1];
        Activity ac = this.activityService.recoverActivity(idActivity);
        TaskRepository tasks = ac.getTasks();
        tasks.removeHour(idTask,hour);
    }

    public void concludeTask(String idTask){
        String[] idActivityArray = idTask.split("-");
        String idActivity = idActivityArray[0] + "-" + idActivityArray[1];
        Activity ac = this.activityService.recoverActivity(idActivity);
        TaskRepository tasks = ac.getTasks();
        tasks.concludeTask(idTask);
    }

    public void removeTask(String idTask){
        String[] idActivityArray = idTask.split("-");
        String idActivity = idActivityArray[0] + "-" + idActivityArray[1];
        Activity ac = this.activityService.recoverActivity(idActivity);
        TaskRepository tasks = ac.getTasks();
        tasks.removeTask(idTask);
    }

    public String showTask(String idTask){
        String[] idActivityArray = idTask.split("-");
        String idActivity = idActivityArray[0] + "-" + idActivityArray[1];
        Activity ac = this.activityService.recoverActivity(idActivity);
        TaskRepository tasks = ac.getTasks();
        return tasks.showTask(idTask,ac);
    }

    public void addPersonTask(String cpf, String idTask){
        //TODO dps.
    }

    public void removePersonTask(String cpf, String idTask){
        //TODO dps.
    }



}
