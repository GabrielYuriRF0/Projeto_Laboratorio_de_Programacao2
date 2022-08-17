import com.sapo.activity.ActivityController;
import com.sapo.person.PersonController;
import com.sapo.person.PersonService;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    private PersonController personController;
    private ActivityController ActivityController;

    private PersonService personService;
    private  String name1 = "Lucas";
    private  String cpf1 = "703.765.025-09";
    private  String[] skills1 = {"Desenvolvedor"};

    private  String name2 = "Rafael";
    private  String cpf2 = "101.301.725-02";
    private  String[] skills2 = {"Desenvolvedor", "Estudante"};


    @BeforeEach
    void baseTestInit(){
        this.personService = new PersonService();
        this.personController = new PersonController(this.personService);
        this.ActivityController = new ActivityController(this.personService);
        this.personController.registerPerson(cpf1, name1, skills1);
        this.personController.registerPerson(cpf2, name2, skills2);



    }



}
