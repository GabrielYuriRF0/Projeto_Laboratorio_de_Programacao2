import com.sapo.tasks.Task;
import org.junit.jupiter.api.Test;

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
}
