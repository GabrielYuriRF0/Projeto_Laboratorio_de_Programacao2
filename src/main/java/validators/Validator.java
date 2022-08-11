package validators;

abstract class Validator {
    private String attribute;

    public void validateAttribute(String attribute){
        if(attribute.isEmpty() || attribute.isBlank()){
            throw new IllegalArgumentException("Invalid attribute!");
        }


    }
}
