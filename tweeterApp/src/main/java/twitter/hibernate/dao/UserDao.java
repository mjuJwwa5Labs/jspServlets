package twitter.hibernate.dao;

import twitter.entities.User;
import twitter.exceptions.DatabaseException;

public interface UserDao {

    public User findById(Integer id) throws DatabaseException;

    public User findByUsername(String username) throws DatabaseException;

    public User findByUsernameAndPassword(String username, String password) throws DatabaseException;
}
