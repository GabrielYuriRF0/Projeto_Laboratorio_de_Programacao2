package com.sapo.tasks;

import com.sapo.validator.TaskValidator;

public class TaskController {
    private TaskService taskService;
    private TaskValidator taskValidator;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
        this.taskValidator = new TaskValidator();
    }

    public String registerTask(String idActivity, String name, String[] skills){
        taskValidator.validateGeneralString(idActivity);
        taskValidator.validateGeneralString(name);
        taskValidator.generalValidateStringArray(skills);
        return this.taskService.registerTask(new Task(name, skills),idActivity);
    }

    public void setName(String idTask, String newName){
        taskValidator.validateGeneralString(idTask);
        taskValidator.validateGeneralString(newName);
        this.taskService.setName(idTask, newName);
    }

    public void setSkills(String idTask, String[] skills){
        taskValidator.validateGeneralString(idTask);
        taskValidator.generalValidateStringArray(skills);
        this.taskService.setSkills(idTask, skills);
    }

    public void addHour(String idTask, int hour){
        taskValidator.validateGeneralString(idTask);
        taskValidator.validateHour(hour);
        this.taskService.addHour(idTask, hour);
    }

    public void removeHour(String idTask, int hour){
        taskValidator.validateGeneralString(idTask);
        taskValidator.validateHour(hour);
        this.taskService.removeHour(idTask, hour);
    }

    public void concludeTask(String idTask){
        taskValidator.validateGeneralString(idTask);
        this.taskService.concludeTask(idTask);
    }

    public void removeTask(String idTask){
        taskValidator.validateGeneralString(idTask);
        this.taskService.removeTask(idTask);
    }

    public String showTask(String idTask){
        taskValidator.validateGeneralString(idTask);
        return this.taskService.showTask(idTask);
    }

    public void addPersonTask(String cpf, String idTask){
        taskValidator.validateGeneralString(idTask);
        taskValidator.validateGeneralString(cpf);
        this.taskService.addPersonTask(cpf,idTask);
    }

    public void removePersonTask(String cpf, String idTask){
        taskValidator.validateGeneralString(idTask);
        taskValidator.validateGeneralString(cpf);
        this.taskService.removePersonTask(cpf,idTask);
    }

    public Task getTask(String idTask){
        taskValidator.validateGeneralString(idTask);
        return this.taskService.getTask(idTask);
    }



}
