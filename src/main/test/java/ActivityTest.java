import com.sapo.Facade;
import com.sapo.activity.Activity;
import org.junit.jupiter.api.*;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

public class ActivityTest {
    private Facade facade;
    @BeforeEach
    public void createFacade(){
        this.facade = new Facade();
    }

    @Test
    public void addActivityIsDone(){
        String[] skills = {"Desenvolvedor"};
        facade.registerPerson("014.596.031-50","Lucas",skills);
        String id = facade.addActivity("Read", "Read one chapter","014.596.031-50");
        Activity activity = facade.getActivity(id);
        Activity activity2 = new Activity("Read","Read one chapter","014.596.031-50");
        assertEquals(activity,activity2);
    }
    @Test
    public void addActivityIsFail(){
        Exception e = new NoSuchElementException("Invalid ID");
        assertEquals(e,facade.addActivity("Read", "Read one chapter","014.596.031-50"));
    }

    @Test
    void endActivityIsDone(){
        String[] skills = {"Desenvolvedor"};
        facade.registerPerson("014.596.031-50","Lucas",skills);
        String id = facade.addActivity("Read", "Read one chapter","014.596.031-50");
        facade.endActivity(id);
        Activity activity = facade.getActivity(id);
        assertEquals(2,activity.getStatus());
    }

    @Test
    void endActivityIsFail(){
        String[] skills = {"Desenvolvedor"};
        facade.registerPerson("014.596.031-50","Lucas",skills);
        String id = facade.addActivity("Read", "Read one chapter","014.596.031-50");
        facade.disableActivity(id);

        try{
            facade.endActivity(id);

        }
        catch (IllegalArgumentException e){
            Exception exception = new  IllegalArgumentException("Não é possivel encerrar atividades já encerradas ou desativadas");
            assertEquals(e, exception);

        }

    }

    @Test
    void disableActivtyIsDone(){
        String[] skills = {"Desenvolvedor"};
        facade.registerPerson("014.596.031-50","Lucas",skills);
        String id = facade.addActivity("Read", "Read one chapter","014.596.031-50");
        facade.disableActivity(id);
        assertEquals(1,facade.getActivity(id).getStatus());
    }

    @Test
    void disableActivityIsFail(){
        String[] skills = {"Desenvolvedor"};
        facade.registerPerson("014.596.031-50","Lucas",skills);
        String id = facade.addActivity("Read", "Read one chapter","014.596.031-50");
        facade.endActivity(id);

        try{
            facade.disableActivity(id);
        }
        catch (IllegalArgumentException e){
            Exception exception = new  IllegalArgumentException("Não é possivel desabilitar atividades já encerradas ou desativadas");
            assertEquals(e, exception);


        }
    }

    @Test
    void reopenActivityIsDone(){
        String[] skills = {"Desenvolvedor"};
        facade.registerPerson("014.596.031-50","Lucas",skills);
        String id = facade.addActivity("Read", "Read one chapter","014.596.031-50");
        facade.endActivity(id);
        facade.reopenActivity(id);
        assertEquals(0,facade.getActivity(id).getStatus());
    }

    @Test
    void reopenActivityIsFail(){
        String[] skills = {"Desenvolvedor"};
        facade.registerPerson("014.596.031-50","Lucas",skills);
        String id = facade.addActivity("Read", "Read one chapter","014.596.031-50");

        try{
            facade.reopenActivity(id);
        }
        catch (IllegalArgumentException e){
            Exception exception = new IllegalArgumentException("Não é possivel reabrir uma atividade já aberta");
            assertEquals(e,exception);

        }
    }










}
