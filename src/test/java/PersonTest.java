import com.sapo.person.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class PersonTest extends BaseTest{
    @Test
    void testeCadastroPessoa(){
        var person = facade.getPerson(cpf1);
        assertEquals(cpf1, person.getCpf());
    }
}
