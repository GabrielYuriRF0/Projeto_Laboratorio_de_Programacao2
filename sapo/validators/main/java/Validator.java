abstract class Validator {
    private String attribute;

    public void validateAttribute(String attribute){
        if(attribute.isEmpty() || attribute.isBlank() || attribute == null){
            throw new IllegalArgumentException("Invalid attribute!");
        }


    }
}
