import com.sapo.person.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class PersonTest extends BaseTest{
    @Test
    void testeCadastroPessoa(){
        var person = facade.getPerson(cpf1);
        assertEquals(cpf1, person.getCpf());
    }
    @Test
    void testeCadastraPessoaCpfInválidoVazio(){
        try{
            facade.registerPerson("", "Lucas", skills1);
        }catch (Exception e){
            assertEquals("Validation errors: [CPFError : INVALID DIGITS]", e.getMessage());
        }
    }

    @Test
    void testeCadastraPessoaCpfInválidoEspaco(){
        try{
            facade.registerPerson(" ", "Lucas", skills1);
        }catch (Exception e){
            assertEquals("Validation errors: [CPFError : INVALID DIGITS]", e.getMessage());
        }
    }

    @Test
    void testeCadastraPessoaCpfInválidoNull(){
        try{
            facade.registerPerson(null, "Lucas", skills1);
        }catch (Exception e){
            assertEquals("Validation errors: [CPFError : INVALID DIGITS]", e.getMessage());
        }
    }

    @Test
    void testeCadastraPessoaNomeInválidoVazio(){
        try{
            facade.registerPerson(cpf1, "", skills1);
        }catch (IllegalArgumentException e) {
            assertEquals("Empty or null attribute!", e.getMessage());
        }
    }

    @Test
    void testeCadastraPessoaNomeInválidoEspaco(){
        try{
            facade.registerPerson(cpf1, " ", skills1);
        }catch (IllegalArgumentException e) {
            assertEquals("Empty or null attribute!", e.getMessage());
        }
    }
    @Test
    void testeCadastraPessoaNomeInválidoNull(){
        try{
            facade.registerPerson(cpf1, null, skills1);
        }catch (Exception e) {
            assertEquals("Null", e.getMessage());
        }
    }
}