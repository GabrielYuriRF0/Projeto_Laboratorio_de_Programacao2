import com.sapo.Facade;
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
        String[] skills = {};
        facade.registerPerson("014.596.031-50","Lucas",skills);
        facade.addActivity("Read", "Read one chapter","014.596.031-50");
    }




}
