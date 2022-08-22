package com.sapo.tasks;

import com.sapo.activity.Activity;

import java.util.HashMap;
import java.util.Map;

public class TaskRepository {
    private Map<String, Task> tasks; //idTask, task.

    public TaskRepository(){
        this.tasks = new HashMap<>();
    }
    public String registerTask(Task task, String idActivity, int taskSize){
        String idTask = task.generateId(idActivity,taskSize);
        tasks.put(idTask,task);
        return idTask;
    }

    public void setName(String idTask, String newName){
        tasks.get(idTask).setName(newName);
    }

    public void setSkills(String idTask, String[] newSkills){
        tasks.get(idTask).setSkills(newSkills);
    }

    public void addHour(String idTask, int hours){
        tasks.get(idTask).addHour(hours);
    }

    public void removeHour(String idTask, int hours){
        tasks.get(idTask).removeHour(hours);
    }

    public void concludeTask(String idTask){
        tasks.get(idTask).concludeTask();
    }

    public void removeTask(String idTask){
        tasks.get(idTask).removeTask();
        tasks.remove(idTask);
    }
    public String showTask(String idTask, Activity activity){
        return tasks.get(idTask).toString(activity);
    }

    public void addPersonTask(String idTask, String cpf, String name){
        tasks.get(idTask).addPersonTask(cpf,name);
    }

    public void removePersonTask(String idTask, String cpf){
        tasks.get(idTask).removePersonTask(cpf);
    }

    public int quantityTasks(){
        return this.tasks.size();
    }

    public Task getTask(String idTask){
        return this.tasks.get(idTask);
    }
}
