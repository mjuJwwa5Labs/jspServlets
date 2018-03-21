package dao;

import dataSource.UserDB;
import entity.User;

import java.util.List;
import java.util.Optional;

public class UserDaoStaticImpl implements UserDao {

    @Override
    public List<User> getAllUsers() {
        UserDB userDB = new UserDB();
        List<User> userList = userDB.getUserList();
        return userList;
    }

    @Override
    public Optional<User> getById(Integer id) {
        List<User> userList = getAllUsers();
        for (User user : userList) {
            if (user.getId()==id) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}
