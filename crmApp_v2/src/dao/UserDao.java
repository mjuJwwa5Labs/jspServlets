package dao;

import entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    public Optional<User> getById(Integer id);

    public List<User> getAllUsers();
}
