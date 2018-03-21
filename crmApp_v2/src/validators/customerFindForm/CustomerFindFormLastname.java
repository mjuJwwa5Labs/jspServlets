package validators.customerFindForm;

import dto.CustomerDto;
import validators.Errors;
import validators.Validator;

public class CustomerFindFormLastname implements Validator {

    private static int LASTNAME_MIN_CHARACTERS = 3; //todo to powinno iść z properties
    private static int LASTNAME_MAX_CHARACTERS = 100; //todo to powinno iść z properties

    @Override
    public void validate(Object object, Errors errors) {
        CustomerDto customerDto = (CustomerDto) object;
        String lastname = customerDto.getFirstname();

        if (lastname!=null && lastname!="" && lastname.length()<LASTNAME_MIN_CHARACTERS) {
            errors.addError("lastname","Nazwisko musi być dłuższe od " + LASTNAME_MIN_CHARACTERS + " znaków");
        }

        if (lastname!=null && lastname!="" && lastname.length()>LASTNAME_MAX_CHARACTERS) {
            errors.addError("lastname","Nazwisko musi być krótsze od " + LASTNAME_MAX_CHARACTERS + " znaków");
        }

        if (lastname!=null && lastname!="" && !lastname.matches("[a-zA-Z]+")) {
            errors.addError("lastname","Nazwisko może zawierać tylko litery");
        }
    }
}
