import com.sapo.Facade;
import org.junit.jupiter.api.BeforeEach;

class BaseTest {
    protected final String name1 = "Gabriel";
    protected final String cpf1 = "357.672.271-87";
    protected final String[] skills1 = {"Estudante","Desenvolvedor"};

    protected final String name2 = "Lucas";
    protected final String cpf2 = "145.667.387-44";
    protected final String[] skills2 = {"Programador"};

    protected final String nameActivity = "Estudar OO";
    protected final String descriptionActivity = "Testar atividade";

    protected final String nameTask = "Tarefa de composicao";
    protected final String[] skillsTask = {"Professor, Objeto"};
    protected Facade facade;
    @BeforeEach
    void setUp(){
        this.facade = new Facade();
        facade.registerPerson(name1, cpf1, skills1);
    }

}