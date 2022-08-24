package com.sapo.tasks;

import com.sapo.validator.ActivityValidator;

import javax.xml.validation.Validator;

public class ManageTaskController {
    private ActivityValidator activityValidator;
    private ManageTaskService manageTaskService;
    private Validator validator;
    public ManageTaskController(ManageTaskService manageTaskService){
        this.manageTaskService = manageTaskService;
        this.activityValidator = new ActivityValidator();
    }

    public String registerManageTask(String idActivity, String name,  String[] idsTasks){
        return manageTaskService.registerManageTask(idActivity,name,idsTasks);

    }

    public void addInManageTask(String idManageTask, String idTask){
        this.manageTaskService.addInManageTask(idManageTask,idTask);
    }

    public void removeTask(String idManageTask, String idTask){
        this.manageTaskService.removeTask(idManageTask,idTask);
    }

    public int countTasksInManage(String idManageTask){
        return this.manageTaskService.countTasksInManage(idManageTask);
    }
}
