import br.com.caelum.stella.validation.InvalidStateException;
import com.sapo.Facade;
import com.sapo.activity.Activity;
import com.sapo.person.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActivityTest extends BaseTest {
    @Test
    void registerActivityIsDone(){
        String idActivity = facade.registerActivity("Estudar","Estudar Java", "357.672.271-87");
        Activity activity = facade.getActivity(idActivity);
        assertEquals(idActivity, activity.getId());
    }
    @Test
    void registerActivityIsFailInvalidCPF(){
        try{
            facade.registerActivity("Estudar","Estudar Java", "111.111.111-11");
        }
        catch(InvalidStateException e){
            assertEquals("Validation errors: [CPFError : REPEATED DIGITS]",e.getMessage());
        }
    }

    @Test
    void registerActivityIsFailInexistentCPF(){
        try{
            facade.registerActivity("Estudar","Estudar Java","024.144.614-70");
        }
        catch(NoSuchElementException e){
            assertEquals("This cpf is not registered in the system!",e.getMessage());
        }
    }

    @Test
    void registerActivityIsFailInvalidName(){
        try{
            facade.registerActivity("Estudar","Estudar Java","024.144.614-70");
        }
        catch(NoSuchElementException e){
            assertEquals("This cpf is not registered in the system!",e.getMessage());
        }
    }
}