package validators.customerFindForm;

import dto.CustomerDto;
import validators.Errors;
import validators.Validator;

public class CustomerFindFormId implements Validator {

    private static int MIN_CUSTOMER_ID = 1; //todo to powinno iść z properties

    @Override
    public void validate(Object object, Errors errors) {
        CustomerDto customerDto = (CustomerDto) object;
        Integer id = customerDto.getId();
        if (id!=null && id<MIN_CUSTOMER_ID) {
            errors.addError("id","Id nie możę być mniejsze niż " + MIN_CUSTOMER_ID);
        }
    }
}
