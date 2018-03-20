package validators;

public class IntegerValidator implements Validator {

    @Override
    public void validate(Object object, Errors errors) {
        try {
            String s = (String) object;
            if (!s.isEmpty()) {
                Integer id = Integer.valueOf(s);
            }
        } catch (NumberFormatException e) {
            errors.addError("id","Wprowadź liczbę całkowitą");
        }
    }
}
