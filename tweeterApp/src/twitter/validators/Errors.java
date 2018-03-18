package twitter.validators;

import java.util.HashMap;
import java.util.Map;

public class Errors {

    //todo tutaj raczej powinna być lista stringów
    private Map<String,String> fieldErrors;

    public void addFieldError(String fieldName, String errorMessage) {
        if (fieldErrors == null) {
            this.fieldErrors = new HashMap<>();
        }
        fieldErrors.put(fieldName,errorMessage);
    }

    public String getErrorMessage(String fieldname) {
        return fieldErrors.get(fieldname);
    }
}
