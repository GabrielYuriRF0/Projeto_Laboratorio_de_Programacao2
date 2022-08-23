import com.sapo.tasks.Task;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest extends BaseTest{

    @Test
    void showThatIdIsGeneratedCorrectly(){
        String idActivity1 = facade.registerActivity(nameActivity,descriptionActivity,cpf1);
        String idTask1 = facade.registerTask(idActivity1,nameTask,skillsTask);
        assertEquals(idTask1, idActivity1+"-0");
    }

    @Test
    void returnExceptionToVoidTaskId(){
        try{
            facade.registerTask("", nameTask, skillsTask);
        } catch (IllegalArgumentException e){
            assertEquals("Empty or null attribute!", e.getMessage());
        }
    }
    @Test
    void returnExceptionToEmptyTaskId(){
        try{
            facade.registerTask(" ", nameTask, skillsTask);
        } catch (IllegalArgumentException e){
            assertEquals("Empty or null attribute!", e.getMessage());
        }
    }

    @Test
    void returnExceptionToInvalidTaskId(){
        try{
            facade.registerTask("invalidId", nameTask, skillsTask);
        } catch (NoSuchElementException e){
            assertEquals("Activity do not registered in the repository", e.getMessage());
        }
    }
    @Test
    void returnExceptionToVoidTaskName(){
        try{
            facade.registerTask(idActivity1, "", skillsTask);
        } catch (IllegalArgumentException e){
            assertEquals("Empty or null attribute!", e.getMessage());
        }
    }
    @Test
    void returnExceptionToEmptyTaskName(){
        try{
            facade.registerTask(idActivity1, " ", skillsTask);
        } catch (IllegalArgumentException e){
            assertEquals("Empty or null attribute!", e.getMessage());
        }
    }
    @Test
    void returnExceptionToNullTaskName(){
        try{
            facade.registerTask(idActivity1, null, skillsTask);
        } catch (IllegalArgumentException e){
            assertEquals("Null", e.getMessage());
        }
    }

    @Test
    void returnExceptionToEmptySkills(){
        try{
            String[] t = new String[]{""};
            facade.registerTask(idActivity1, nameTask, t);
        } catch (IllegalArgumentException e){
            assertEquals("Empty or null attribute!", e.getMessage());
        }
    }

    @Test
    void returnExceptionToVoidSkills(){
        try{
            String[] t = new String[]{};
            facade.registerTask(idActivity1, nameTask, t);
        } catch (IllegalArgumentException e){
            assertEquals("Empty or null attribute!", e.getMessage());
        }
    }
    @Test
    void showThatRegisterTaskIsDone(){
        String idTask1 = facade.registerTask(idActivity1,nameTask,skillsTask);
        assertEquals("LRX-0-0", idTask1);
    }

    @Test
    void returnExceptionToIdTaskIsVoidInSetSkills(){
        try{
            facade.registerTask(idActivity1, nameTask, skillsTask);
            facade.setNameTask("", "Rafael");
        } catch (IllegalArgumentException e){
            assertEquals("Empty or null attribute!", e.getMessage());
        }
    }

    @Test
    void returnExceptionToIdTaskIsEmpty(){
        try{
            facade.registerTask(idActivity1, nameTask, skillsTask);
            facade.setNameTask(" ", "Rafael");
        } catch (IllegalArgumentException e){
            assertEquals("Empty or null attribute!", e.getMessage());
        }
    }
    @Test
    void returnExceptionToIdTaskIsNull(){
        try{
            facade.registerTask(idActivity1, nameTask, skillsTask);
            facade.setNameTask(null, "Rafael");
        } catch (IllegalArgumentException e){
            assertEquals("Null", e.getMessage());
        }
    }
    @Test
    void returnExceptionToNewNameIsVoid(){
        try{
            facade.registerTask(idActivity1, nameTask, skillsTask);
            facade.setNameTask("LRX-0-0", "");
        } catch (IllegalArgumentException e){
            assertEquals("Empty or null attribute!", e.getMessage());
        }
    }
    @Test
    void returnExceptionToNewNameIsEmpty(){
        try{
            facade.registerTask(idActivity1, nameTask, skillsTask);
            facade.setNameTask("LRX-0-0", " ");
        } catch (IllegalArgumentException e){
            assertEquals("Empty or null attribute!", e.getMessage());
        }
    }
    @Test
    void returnExceptionToNewNameIsNull(){
        try{
            facade.registerTask(idActivity1, nameTask, skillsTask);
            facade.setNameTask("LRX-0-0", null);
        } catch (IllegalArgumentException e){
            assertEquals("Null", e.getMessage());
        }
    }

    @Test
    void showThatSetNameIsDone(){
        facade.registerTask(idActivity1, nameTask, skillsTask);
        Task task1 = facade.getTask("LRX-0-0");
        assertEquals("Tarefa de composicao", task1.getName());
        facade.setNameTask("LRX-0-0", "Criação de testes");
        Task task = facade.getTask("LRX-0-0");
        assertEquals("Criação de testes", task.getName());
    }

    @Test
    void returnExceptionToIdTaskInSetTasksIsVoid(){
        try{
            facade.registerTask(idActivity1, nameTask, skillsTask);
            String[] t = {"Estudar, Trabalho"};
            facade.setSkillsTask("", t);
        } catch (IllegalArgumentException e){
            assertEquals("Empty or null attribute!", e.getMessage());
        }
    }
    @Test
    void returnExceptionToIdTaskInSetTasksIsEmpty(){
        try{
            facade.registerTask(idActivity1, nameTask, skillsTask);
            String[] t = {"Estudar, Trabalho"};
            facade.setSkillsTask(" ", t);
        } catch (IllegalArgumentException e){
            assertEquals("Empty or null attribute!", e.getMessage());
        }
    }
    @Test
    void returnExceptionToIdTaskInSetTasksIsNull(){
        try{
            facade.registerTask(idActivity1, nameTask, skillsTask);
            String[] t = {"Estudar, Trabalho"};
            facade.setSkillsTask(null, t);
        } catch (IllegalArgumentException e){
            assertEquals("Null", e.getMessage());
        }
    }
    @Test
    void returnExceptionToSkillsInSetTasksIsVoid(){
        try{
            facade.registerTask(idActivity1, nameTask, skillsTask);
            String[] t = {};
            facade.setSkillsTask("LRX-0-0", t);
        } catch (IllegalArgumentException e){
            assertEquals("Empty or null attribute!", e.getMessage());
        }
    }
    @Test
    void returnExceptionToSkillsInSetTasksIsEmpty(){
        try{
            facade.registerTask(idActivity1, nameTask, skillsTask);
            String[] t = {" "};
            facade.setSkillsTask("LRX-0-0", t);
        } catch (IllegalArgumentException e){
            assertEquals("Empty or null attribute!", e.getMessage());
        }
    }
    @Test
    void showThatSetTasksIsDone(){
        facade.registerTask(idActivity1, nameTask, skillsTask);
        Task task1 = facade.getTask("LRX-0-0");
        String word = "";
        for(int i = 0; i < task1.getSkills().length; i++){
            word += task1.getSkills()[i];
        }
        assertEquals("Professor, Objeto", word);


        String[] t = {"Aluno, Estudar"};
        facade.setSkillsTask("LRX-0-0", t);
        Task task = facade.getTask("LRX-0-0");
        String word1 = "";
        for(int i = 0; i < task1.getSkills().length; i++){
            word1 += task1.getSkills()[i];
        }
        assertEquals("Aluno, Estudar", word1);
    }

    @Test
    void returnExceptionIfHourIsLowerThanZero(){
        try{
            facade.registerTask(idActivity1, nameTask, skillsTask);
            facade.addHourTask("LRX-0-0", -1);
        } catch (IllegalArgumentException e){
            assertEquals("invalid hour", e.getMessage());
        }
    }

    @Test
    void showThatAddHourIsDone(){
        facade.registerTask(idActivity1, nameTask, skillsTask);
        facade.addHourTask("LRX-0-0", 10);
        facade.addHourTask("LRX-0-0", 5);
        assertEquals(15, facade.getTask("LRX-0-0").getHour());
    }
    @Test
    void showThatRemoveHourIsDone(){
        facade.registerTask(idActivity1, nameTask, skillsTask);
        facade.addHourTask("LRX-0-0", 10);
        facade.removeHourTask("LRX-0-0", 3);
        assertEquals(7, facade.getTask("LRX-0-0").getHour());
    }

    @Test
    void returnExceptionIfRemoveHourIsLowerThanZero(){
        try{
            facade.registerTask(idActivity1, nameTask, skillsTask);
            facade.addHourTask("LRX-0-0", 10);
            facade.removeHourTask("LRX-0-0", -2);
        } catch (IllegalArgumentException e){
            assertEquals("invalid hour", e.getMessage());
        }
    }
    @Test
    void returnExceptionIfRemoveHourHasAsValueLessThanZero(){
        try{
            facade.registerTask(idActivity1, nameTask, skillsTask);
            facade.addHourTask("LRX-0-0", 10);
            facade.removeHourTask("LRX-0-0", 11);
        } catch (IllegalStateException e){
            assertEquals("Number of hours cannot be negative", e.getMessage());
        }
    }
    @Test
    void returnExceptionIfIdTaskIsVoidInConcludeTask(){
        try{
            facade.registerTask(idActivity1, nameTask, skillsTask);
            facade.concludeTask("");
        } catch (IllegalArgumentException e){
            assertEquals("Empty or null attribute!", e.getMessage());
        }
    }

    @Test
    void returnExceptionIfIdTaskIsEmptyInConcludeTask(){
        try{
            facade.registerTask(idActivity1, nameTask, skillsTask);
            facade.concludeTask(" ");
        } catch (IllegalArgumentException e){
            assertEquals("Empty or null attribute!", e.getMessage());
        }
    }
    @Test
    void returnExceptionIfIdTaskIsNullInConcludeTask(){
        try{
            facade.registerTask(idActivity1, nameTask, skillsTask);
            facade.concludeTask(null);
        } catch (IllegalArgumentException e){
            assertEquals("Null", e.getMessage());
        }
    }

    @Test
    void showThatConcludeTaskIsDone(){
        facade.registerTask(idActivity1, nameTask, skillsTask);
        facade.concludeTask("LRX-0-0");
        assertEquals("FINISHED", facade.getTask("LRX-0-0").getStatus());
    }

    @Test
    void returnExceptionIfCloseATaskIsAlreadyClosed(){
        try{
            facade.registerTask(idActivity1, nameTask, skillsTask);
            facade.concludeTask("LRX-0-0");
            facade.concludeTask("LRX-0-0");
        } catch (IllegalStateException e){
            assertEquals("Invalid Operation, the task status isn't STARTED", e.getMessage());
        }
    }
    @Test
    void showThatRemoveTaskIsDone(){
        String[] t = {"Estudar", "Praticar"};
        facade.registerTask(idActivity1, nameTask, skillsTask);
        facade.registerTask(idActivity1, "Fazendo Testes", t);
        assertEquals(2, facade.getActivity(idActivity1).getTasks().quantityTasks());
        facade.removeTask("LRX-0-0");
        assertEquals(1, facade.getActivity(idActivity1).getTasks().quantityTasks());
    }

    @Test
    void showThatTaskToStringIsDone(){
        facade.registerTask(idActivity1, nameTask, skillsTask);
        String taskString = facade.showTask("LRX-0-0");
        System.out.println(taskString);
    }

    @Test
    void showThatAddPersonTaskIsDone(){
        facade.registerTask(idActivity1, nameTask, skillsTask);
        facade.addPersonTask(cpf1, "LRX-0-0");
        Map<String,String> t = new HashMap<>();
        t.put(cpf1, "Gabriel");
        assertEquals(t, facade.getTask("LRX-0-0").getTeam());
    }

    @Test
    void showThatRemovePersonTaskIsDone(){
        facade.registerTask(idActivity1, nameTask, skillsTask);
        facade.addPersonTask(cpf1, "LRX-0-0");
        facade.addPersonTask(cpf2, "LRX-0-0");
        assertEquals(2, facade.getTask("LRX-0-0").getTeam().size());
        facade.removePersonTask(cpf2, "LRX-0-0");
        assertEquals(1, facade.getTask("LRX-0-0").getTeam().size());
    }
}


