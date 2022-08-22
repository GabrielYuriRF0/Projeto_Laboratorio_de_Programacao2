import com.sapo.Facade;
import org.junit.jupiter.api.BeforeEach;

class BaseTest {
    protected final String name1 = "Gabriel";
    protected final String cpf1 = "357.672.271-87";
    protected final String[] skills1 = {"Estudante","Desenvolvedor"};

    private final String name2 = "Lucas";
    private final String cpf2 = "145.667.387-44";
    private final String[] skills2 = {"Programador"};

    protected Facade facade;
    @BeforeEach
    void setUp(){
        this.facade = new Facade();
        facade.registerPerson(name1, cpf1, skills1);
        facade.registerPerson(name2, cpf2, skills2);
    }

}