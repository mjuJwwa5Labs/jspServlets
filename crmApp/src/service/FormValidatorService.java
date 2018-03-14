package service;

import java.util.Map;

public interface FormValidatorService {

    public boolean formCorrect(Map<String, String[]> formRequest);

    public Map<String,String> requestParametersToMap (Map<String,String[]> parametersMap);

    public Map<String,String> validateForm (Map<String, String[]> parameters);

}
