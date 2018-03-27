package twitter.service;

import java.util.HashMap;
import java.util.Map;
@Deprecated
public class LoginServiceImpl implements LoginService {

    static Map<String, String> userMap = new HashMap<>();

    static {
        userMap.put("mike", "john");
        userMap.put("john", "mike");
    }

    @Override
    public boolean login(String username, String password) {
        if (userMap!=null) {
            if (userMap.containsKey(username)
                    && userMap.get(username).equals(password)) {
                return true;
            }
        }

        return false;
    }
}
