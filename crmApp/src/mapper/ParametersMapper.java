package mapper;

import java.util.Map;

public interface ParametersMapper {

    public Map<String,String> requestParametersToMap(Map<String,String[]> parametersMap);

}
