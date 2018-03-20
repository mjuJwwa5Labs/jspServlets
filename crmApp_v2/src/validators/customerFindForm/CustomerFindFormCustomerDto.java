package validators.customerFindForm;

import dto.CustomerDto;
import validators.Errors;
import validators.Validator;

public class CustomerFindFormCustomerDto implements Validator {

    @Override
    public void validate(Object object, Errors errors) {
        CustomerDto customerDto = (CustomerDto) object;

        boolean errorsFound = true;

        if (customerDto.getId()!=null) {
            errorsFound=false;
            return;
        }

        if (customerDto.getFirstname()!=null && customerDto.getFirstname()!="") {
            errorsFound=false;
            return;
        }

        if (customerDto.getLastname()!=null && customerDto.getLastname()!="") {
            errorsFound=false;
            return;
        }

        if (customerDto.getCreated()!=null) {
            errorsFound=false;
            return;
        }

        if (customerDto.getModified()!=null) {
            errorsFound=false;
            return;
        }

        if (errorsFound) {
            errors.addError("errorMessage", "Wypełnij poprawnie przynajmniej jedno pole");
        }
    }
}
