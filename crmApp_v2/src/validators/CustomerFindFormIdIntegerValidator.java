package validators;

public class CustomerFindFormIdIntegerValidator implements Validator {

    //todo to powinno iść z properties
    private static int MIN_CUSTOMER_ID = 1;

    @Override
    public void validate(Object object, Errors errors) {
        try {
            Integer id = (Integer) object;
            if (id<MIN_CUSTOMER_ID) {
                errors.addError("id","Id nie możę być mniejsze niż " + MIN_CUSTOMER_ID);
            }
        } catch (ClassCastException e) {
            errors.addError("id","Wprowadź liczbę całkowitą");
        }
    }
}
