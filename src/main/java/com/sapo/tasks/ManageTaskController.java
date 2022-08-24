package com.sapo.tasks;

public class ManageTaskController {
    private ManageTaskService manageTaskService;

    public ManageTaskController(ManageTaskService manageTaskService){
        this.manageTaskService = manageTaskService;
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
