package service;

import dto.UserDto;
import entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public Optional<UserDto> getByLogin(String login);

    public List<UserDto> getAllUsers();

    public boolean isAdminGroup(UserDto userDto);

}
