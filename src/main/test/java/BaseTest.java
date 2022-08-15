import com.sapo.activity.ActivityController;
import com.sapo.person.PersonController;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    private PersonController personController;
    private ActivityController ActivityController;

    private final String name1 = "Lucas";
    private final String cpf1 = "703.765.025-09";
    private final String[] skills1 = {"Desenvolvedor"};

    private final String name2 = "Rafael";
    private final String cpf2 = "101.301.725-02";
    private final String[] skills2 = {"Desenvolvedor", "Estudante"};


    @BeforeEach
    void baseTestInit(){
        this.personController = new PersonController();
        this.ActivityController = new ActivityController();
        this.personController.registerPerson(cpf1, name1, skills1);
        this.personController.registerPerson(cpf2, name2, skills2);

    }



}
