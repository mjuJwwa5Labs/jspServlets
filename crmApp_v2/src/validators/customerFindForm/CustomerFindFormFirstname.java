package validators.customerFindForm;

import dto.CustomerDto;
import validators.Errors;
import validators.Validator;

public class CustomerFindFormFirstname implements Validator {

    private static int FIRSTNAME_MIN_CHARACTERS = 3; //todo to powinno iść z properties
    private static int FIRSTNAME_MAX_CHARACTERS = 10; //todo to powinno iść z properties

    @Override
    public void validate(Object object, Errors errors) {
        CustomerDto customerDto = (CustomerDto) object;
        String firstname = customerDto.getFirstname();

        if (firstname!=null && firstname!="" && firstname.length()<FIRSTNAME_MIN_CHARACTERS) {
            errors.addError("firstname","Imię nie może być krótsze niż " + FIRSTNAME_MIN_CHARACTERS + " znaków");
        }

        if (firstname!=null && firstname!="" && firstname.length()>FIRSTNAME_MAX_CHARACTERS) {
            errors.addError("firstname","Imię może mieć maksymalnie " + FIRSTNAME_MAX_CHARACTERS + " znaków");
        }

        if (firstname!=null && firstname!="" && !firstname.matches("[a-zA-Z]+")) {
            errors.addError("firstname","Imię może zawierać tylko litery");
        }
    }
}
