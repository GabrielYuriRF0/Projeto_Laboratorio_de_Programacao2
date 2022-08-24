package com.sapo.tasks;

import com.sapo.activity.Activity;
import com.sapo.activity.ActivityService;
import org.apache.commons.lang3.ArrayUtils;

import javax.accessibility.AccessibleAction;
import java.util.*;

public class ManageTaskService {
    private ActivityService activityService;


    public ManageTaskService(ActivityService activityService){
        this.activityService = activityService;
    }

    public String registerManageTask(String idActivity, String name, String[] idsTasks){
        int parcialId = activityService.recoverActivity(idActivity).getTasks().quantityTasks();
        String idManageTask = idActivity + "-" + parcialId;
        Activity activity = activityService.recoverActivity(idActivity);
        TaskRepository taskRepository = activity.getTasks();
        Map<String,Task> mapTasks = taskRepository.getTasks();
        var valuesMapTasks = mapTasks.values();

        // Inserir em um Array todas as tasks que estão em uma atividade e que possuem um dos idsTasks
        ArrayList<Task> collectionTasks = new ArrayList<>();
        for(Task actualTask: valuesMapTasks){
            for(int i = 0; i < idsTasks.length; i++){
                if(actualTask.getId().equals(idsTasks[i])){
                    collectionTasks.add(actualTask);
                    break;
                }
            }
        }



        // Gerar a união referente a todas as habilidades de todas as tarefas contidas na atividade
        // e o tempo total das mesmas.

        // Também é pego o nome de todas as pessoas responsáveis pela tarefa gerencial
        String[] unionOfSkills = new String[0];
        int totalHours = 0;
        String namesofTeam = new String();

        for(Task task: collectionTasks){
            unionOfSkills = ArrayUtils.addAll(unionOfSkills, task.getSkills());
            totalHours += task.getHour();
            for(String actualName: task.getTeam().values()){
                namesofTeam += actualName + " ";
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
        // Adicionar o array de tasks a ManageTask
        for(int i = 0; i< collectionTasks.size(); i++){
            activity.getmanageTaskRepository().addInManageTask(idManageTask, collectionTasks.get(i));
        }
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
