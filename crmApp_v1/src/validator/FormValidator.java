package validator;

import java.util.Map;

public interface FormValidator {

    public Map<String,String> validateForm (Map<String, String[]> parameters);

    public boolean formNotCorrect(Map<String,String> validationResult);

    public boolean formEmpty(Map<String, String[]> parameters);

}
