package service;

import dataSource.UserDB;

public class LoginServiceImpl implements LoginService{

    @Override
    public boolean login(String login, String password) {
        return UserDB.checkPassword(login,password);
    }
}
