package dataSource;

import entity.Customer;
import entity.User;
import entity.UserGroups;

import java.time.LocalDateTime;
import java.util.*;

public class UserDB {

    private static List<User> userList;
    private static Map<String,String> passwordMap;

    public static List<User> getUserList() {
        createUsers();
        return userList;
    }

    public static boolean checkPassword(String login, String password) {
         createUsers();
         try {
             return passwordMap.get(login).equals(password);
         } catch (NullPointerException e) {
             return false;
         }
    }

    private static void createUsers() {
        if (userList==null) {
            userList = new ArrayList<>();
        }
        if (passwordMap==null) {
            passwordMap = new HashMap<>();
        }

        if (userList.size()==0) {
            userList.add(new User(1,"admin","imie", "nazwisko", Arrays.asList(UserGroups.ADMIN,UserGroups.USER)));
            userList.add(new User(2,"user","imie", "nazwisko", Arrays.asList(UserGroups.USER)));
        }

        if (passwordMap.size()==0) {
            passwordMap.put("admin","admin");
            passwordMap.put("user","user");
        }
    }
}
