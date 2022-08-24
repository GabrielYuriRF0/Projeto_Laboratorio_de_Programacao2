package com.sapo.tasks;

import com.sapo.activity.Activity;
import com.sapo.activity.ActivityService;
import org.apache.commons.lang3.ArrayUtils;

import javax.accessibility.AccessibleAction;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ManageTaskService {
    private ActivityService activityService;


    public ManageTaskService(ActivityService activityService){
        this.activityService = activityService;
    }

    //FIXME Rever implementação
    public String registerManageTask(String idActivity, String name, String[] skills, String[] idsTasks){
        int parcialId = activityService.recoverActivity(idActivity).getTasks().quantityTasks();
        String idManageTask = idActivity + "-" + parcialId;
        Activity activity = activityService.recoverActivity(idActivity);

        // Gerar a união referente a todas as habilidades de todas as tarefas contidas na atividade e o tempo total das atividades:
        // Também é pego o nome de todas as pessoas responsáveis pela tarefa gerencial
        Map<String, Task> mapOfTasks = activity.getTasks().getTasks();
        var listOfTasks = mapOfTasks.values();
        String[] unionOfSkills = new String[0];
        int totalHours = 0;
        String namesofTeam = new String();

        for(Task task: listOfTasks){
            unionOfSkills = ArrayUtils.addAll(unionOfSkills, task.getSkills());
            totalHours += task.getHour();
            for(String name1: task.getTeam().values()){
                namesofTeam += name1 + " ";
            }
        }
        String[] namesOfTeamSplit = namesofTeam.split(" ");

        // Remover duplicatas das habilidades
        HashSet<String> setUnionOfSkills = new HashSet<>();
        for(String skill: unionOfSkills){
            setUnionOfSkills.add(skill);
        }

        // Remover duplicatas do conjunto de nomes referentes ao time
        HashSet <String> setOfTeam = new HashSet<>();
        for(String oneName: namesOfTeamSplit){
            setOfTeam.add(oneName);
        }

        activity.getmanageTaskRepository().getManageTaskRepository().put(idManageTask, new ManageTask(name, setUnionOfSkills, totalHours, setOfTeam,idActivity));
        return idManageTask;
    }

    public void addInManageTask(String idManageTask, String idTask){
        String[] idActivityArray = idTask.split("-");
        String idActivity = idActivityArray[0] + "-" + idActivityArray[1];
        Activity activity = activityService.recoverActivity(idActivity);

        TaskRepository taskRepository = activity.getTasks();
        Task task = taskRepository.getTask(idTask);
        ManageTaskRepository manageTaskRepository = activity.getmanageTaskRepository();
        manageTaskRepository.addInManageTask(idManageTask, task);

    }

    public void removeTask(String idManageTask, String idTask){
        String[] idActivityArray = idTask.split("-");
        String idActivity = idActivityArray[0] + "-" + idActivityArray[1];
        Activity activity = activityService.recoverActivity(idActivity);
        ManageTaskRepository manageTaskRepository = activity.getmanageTaskRepository();
        TaskRepository taskRepository = activity.getTasks();
        Task task = taskRepository.getTask(idTask);
        manageTaskRepository.removeTask(idManageTask,task);
    }

    //FIXME Rever implementação
    public int countTasksInManage(String idManageTask){
        String[] idActivityArray = idManageTask.split("-");
        String idActivity = idActivityArray[0] + "-" + idActivityArray[1];
        Activity activity = activityService.recoverActivity(idActivity);
        ManageTaskRepository manageTaskRepository = activity.getmanageTaskRepository();
        return manageTaskRepository.countTasksInManage(idManageTask);

    }


}
