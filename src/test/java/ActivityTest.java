import com.sapo.Facade;
import com.sapo.person.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActivityTest extends BaseTest {
    @Test
    void registerActivityIsDone(){
        Person person1 = super.facade.getPerson(super.cpf1);
        assertEquals("Gabriel", super.facade.getPerson(super.cpf1).getName());
    }

}