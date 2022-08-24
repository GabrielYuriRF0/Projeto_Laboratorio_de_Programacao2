import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManageTaskTest extends BaseTest{

        @Test
        void returnExceptionToInvalidId(){
            try{
                String[] ids = {"LRX-0-0", "LTR-0-1"};
                facade.registerManageTask("InvalidID", name1, ids);
            } catch (IllegalArgumentException e){
                assertEquals("Invalid ID", e.getMessage());
            }
        }
        @Test
        void showThatRegisterManageTaskIsDone(){
            String[] ids = {"LRX-0-0", "LTR-0-1"};
            assertEquals("LRX-0-0", facade.registerManageTask(idActivity1, name1, ids));
        }
}


