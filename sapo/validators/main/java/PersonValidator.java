import br.com.caelum.stella.validation.CPFValidator;

public class PersonValidator extends Validator {

    public boolean nameValidator(String name){
        super.validateAttribute(name);
        return true;
    }

    public boolean cpfValidator(String cpf){
        super.validateAttribute(cpf);
        CPFValidator cpfValidator = new CPFValidator();


        return true;
    }



}
