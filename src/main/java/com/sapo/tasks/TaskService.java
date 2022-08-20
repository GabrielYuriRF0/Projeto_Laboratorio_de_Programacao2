package com.sapo.tasks;

import com.sapo.activity.ActivityService;

public class TaskService {
    private TaskRepository taskRepository;
    private ActivityService activityService;
    public TaskService(ActivityService activityService){
        this.taskRepository = new TaskRepository();
        this.activityService = activityService;
    }

    public String registerTask(Task task){
        //TODO implementar depois.
    }

    public void setName(String idTask, String newName){
        taskRepository.setName(idTask, newName);
    }

    public void setSkills(String idTask, String[] newSkills){
        taskRepository.setSkills(idTask, newSkills);
    }

    public void addHour(String idTask, int hour){
        taskRepository.addHour(idTask,hour);
    }

    public void removeHour(String idTask, int hour){
        taskRepository.removeHour(idTask, hour);
    }

    public void concludeTask(String idTask){
        taskRepository.concludeTask(idTask);
    }

    public void removeTask(String idTask){
        taskRepository.removeTask(idTask);
    }

    public String showTask(String idTask){
        //TODO dps.
    }

    public void addPersonTask(String cpf, String idTask){
        //TODO dps.
    }

    public void removePersonTask(String cpf, String idTask){
        //TODO dps.
    }



}
