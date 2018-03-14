package validator;

import java.util.HashMap;
import java.util.Map;

public class CustomerAddFormValidator implements FormValidator {

    @Override
    public Map<String,String> validateForm (Map<String, String[]> parameters) {
        Map<String,String> validationResult = new HashMap<>();

        for (Map.Entry<String,String[]> entry : parameters.entrySet()) {

            String[] entryValues = entry.getValue();

            for (String s : entryValues) {
                if (s.equals("") || s.length()==0) {
                    validationResult.put(entry.getKey(), "To pole jest obowiązkowe");
                }
            }

            if (!validationResult.containsKey(entry.getKey())) {
                validationResult.put(entry.getKey(),"");
            }
        }
        return validationResult;
    }

    @Override
    public boolean formNotCorrect(Map<String,String> validationResult) {

        for (Map.Entry<String,String> entry : validationResult.entrySet()) {
            if (entry.getValue()==null || entry.getValue().equals("") || entry.getValue().length()==0) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean formEmpty(Map<String, String[]> parameters) {

        for (Map.Entry<String,String[]> mapEntry : parameters.entrySet()) {
            for (String s : mapEntry.getValue()) {
                if (s.length()!=0) {
                    return false;
                }
            }
        }

        return true;
    }

}
