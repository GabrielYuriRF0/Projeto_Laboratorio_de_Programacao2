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
        String idActivity = facade.registerActivity("Estudar","Estudar Java", super.cpf1);
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
            facade.registerActivity("","Estudar Java",super.cpf1);
        }
        catch(IllegalArgumentException e){
            assertEquals("Empty or null attribute!",e.getMessage());
        }
    }

    @Test
    void registerActivityIsFailInvalidDescription(){
        try{
            facade.registerActivity("Estudar","",super.cpf1);
        }
        catch(IllegalArgumentException e){
            assertEquals("Empty or null attribute!",e.getMessage());
        }
    }

    @Test
    void concludeActivityIsDone(){
        facade.concludeActivity(super.idActivity1);
        assertEquals("FINISHED",super.activity1.getStatus());
    }
    @Test
    void concludeActivityIsFail(){
        facade.disableActivity(super.idActivity1);
        try{
            facade.concludeActivity(super.idActivity1);
        }
        catch (IllegalStateException e){
            assertEquals("Invalid Operation!", e.getMessage());
        }
    }

    @Test
    void disableActivityIsDone(){
        facade.disableActivity(super.idActivity1);
        assertEquals("DISABLED",super.activity1.getStatus());
    }

    @Test
    void disableActivityIsFail1(){
        facade.concludeActivity(idActivity1);
        try{
            facade.disableActivity(super.idActivity1);
        }
        catch (IllegalStateException e){
            assertEquals("Invalid Operation!", e.getMessage());
        }
    }

    @Test
    void disableActivityIsFail2(){
        facade.disableActivity(super.idActivity1);

        try{
            facade.disableActivity(super.idActivity1);
        }
        catch(IllegalStateException e){
            assertEquals("Invalid Operation!", e.getMessage());

        }

    }

    @Test
    void reopenActivityIsDone(){
        facade.disableActivity(super.idActivity1);
        facade.reopenActivity(super.idActivity1);
        assertEquals("STARTED",super.activity1.getStatus());
    }

    @Test
    void reopenActivityIsFail(){
        facade.concludeActivity(super.idActivity1);

        try{
            facade.reopenActivity(super.idActivity1);
        }
        catch (IllegalStateException e){
            assertEquals("Invalid Operation!", e.getMessage());

        }
    }
    //FIXME Rever teste
    @Test
    void showActivityIsDone(){
        String activityString = facade.showActivity(super.idActivity1);
        System.out.println(activityString);
    }

    @Test
    void changeActivityDescriptionIsDone(){
        facade.changeDescription(idActivity1,"Ler Harry Potter");
        assertEquals("Ler Harry Potter", facade.getActivity(idActivity1).getDescription());
    }

    @Test
    void changeActivityDescriptionFailInvalidId(){
        try{
            facade.changeDescription("InvalidId","Ler Harry Potter");
        }
        catch (IllegalArgumentException e){
            assertEquals("Invalid ID", e.getMessage());
        }
    }
    @Test
    void changeActivityDescriptionFailInexistentId(){
        try{
            facade.changeDescription("STD-2","Ler Harry Potter");
        }
        catch (NoSuchElementException e){
            assertEquals("Activity do not registered in the repository", e.getMessage());
        }
    }

    @Test
    void changeActivityDescriptionFailInvalidDescription(){
        try{
            facade.changeDescription(super.idActivity1," ");
        }
        catch (IllegalArgumentException e){
            assertEquals("Empty or null attribute!", e.getMessage());
        }
    }

    @Test
    void changeActivityResponsableIsDone(){
        facade.changeResponsable(super.idActivity1,super.cpf1);
        assertEquals("Gabriel",facade.getActivity(super.idActivity1).getResponsableName());
    }

    @Test
    void changeActivityResponsableIsFailsInvalidID(){
        try{
            facade.changeResponsable("Invalid ID",super.cpf1);
        }
        catch (IllegalArgumentException e){
            assertEquals("Invalid ID", e.getMessage());
        }

    }

    @Test
    void changeActivityResponsableIsFailsInvalidCpf(){

    }


}