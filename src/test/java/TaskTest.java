import com.sapo.tasks.Task;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest extends BaseTest{
    @Test
    void testeTask(){
        String idActivity1 = facade.registerActivity(nameActivity,descriptionActivity,cpf1);
        String idTask1 = facade.registerTask(idActivity1,nameTask,skillsTask);
        assertEquals(idTask1, idActivity1+"-0");
    }
}
