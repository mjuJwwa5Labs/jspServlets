package service;

import mapper.CustomerAddFormMapper;
import mapper.CustomerMapper;
import mapper.CustomerMapperImpl;
import mapper.ParametersMapper;
import validator.CustomerAddFormValidator;
import validator.FormValidator;

import java.util.Map;

public class CustomerAddFormValidatorService implements FormValidatorService{

    @Override
    public boolean formCorrect(Map<String, String[]> formRequest) {
        FormValidator validator = new CustomerAddFormValidator();
        ParametersMapper mapper = new CustomerAddFormMapper();

        if (validator.formNotCorrect(mapper.requestParametersToMap(formRequest))) {
            return false;
        }

        if (validator.formEmpty(formRequest)) {
            return false;
        }

        return true;
    }

    @Override
    public Map<String,String> requestParametersToMap (Map<String,String[]> parametersMap) {
        ParametersMapper mapper = new CustomerAddFormMapper();
        return mapper.requestParametersToMap(parametersMap);
    }

    @Override
    public Map<String, String> validateForm(Map<String, String[]> parameters) {
        FormValidator validator = new CustomerAddFormValidator();
        return validator.validateForm(parameters);
    }
}
