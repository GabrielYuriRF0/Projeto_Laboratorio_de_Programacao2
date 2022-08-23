import com.sapo.tasks.Task;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest extends BaseTest{

    @Test
    void testeTask(){
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
    void returnExceptionToNullTaskId(){
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
}
