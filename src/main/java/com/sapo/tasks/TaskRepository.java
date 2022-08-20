package com.sapo.tasks;

import java.util.HashMap;
import java.util.Map;

public class TaskRepository {
    private Map<String, Task> tasks; //idTask, task.

    public TaskRepository(){
        this.tasks = new HashMap<>();
    }
    public String RegisterTask(Task task){
        //TODO dps.
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
        tasks.remove(idTask); //TODO analisar para ver qual a melhor situação.
    }
    public String showTask(String idTask){
        //TODO ver o tostring depois.
    }

    public void addPersonTask(String idTask){
        //TODO DEPOIS.
    }

    public void removerPersonTask(String idTask, String cpf){
        //TODO DEPOIS.
    }
}
