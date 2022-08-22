import com.sapo.activity.Activity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class ActivityTest extends BaseTest{
    @Test
    void testRegisterActivity(){
        String idActivity1 = facade.registerActivity(nameActivity,descriptionActivity,cpf1);
        Activity a = facade.getActivity(idActivity1);
        assertEquals(cpf1, a.getCpf());
    }

}