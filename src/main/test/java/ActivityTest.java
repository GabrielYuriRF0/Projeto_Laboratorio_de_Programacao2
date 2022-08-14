import com.sapo.Facade;
import com.sapo.activity.Activity;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ActivityTest {
    private Facade facade;
    @BeforeEach
    public void createFacade(){
        facade = new Facade();
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




}
