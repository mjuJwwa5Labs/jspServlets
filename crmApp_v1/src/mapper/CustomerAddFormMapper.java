package mapper;

import java.util.HashMap;
import java.util.Map;

public class CustomerAddFormMapper implements ParametersMapper {

    @Override
    public Map<String, String> requestParametersToMap(Map<String, String[]> parametersMap) {
        Map<String, String> resultMap = new HashMap<>();

        for (Map.Entry<String,String[]> entry : parametersMap.entrySet()) {
            String key = entry.getKey();
            String valueArray[] = entry.getValue();

            if (valueArray.length != 1) {
                throw new IllegalArgumentException("Expected only one parameter");
            }

            String resultValue = valueArray[0];
            resultMap.put(key,resultValue);
        }

        return resultMap;
    }
}
