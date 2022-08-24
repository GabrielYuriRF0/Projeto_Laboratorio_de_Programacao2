import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class SearchTest extends  BaseTest {

    @Test
    void searchPersonIsDone(){
        ArrayList<String> searchResult =new ArrayList<>();
        searchResult.add("Gabriel");
        assertEquals(searchResult.get(0), facade.searchPerson("Gabriel").get(0));
    }

    @Test
    void searchActivityIsDone(){
        ArrayList<String> searchResult = new ArrayList<>();
        String searchString =  "["+facade.getActivity(super.idActivity1).toString() + "]";
        assertEquals(searchString,facade.searchActivity("Ler"));
    }




}
