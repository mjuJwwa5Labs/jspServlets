package service;

import dao.UserDao;
import dao.UserDaoStaticImpl;
import dto.UserDto;
import entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class UserServiceImpl implements UserService {

    @Override
    public Optional<UserDto> getByLogin(String login) {
        List<UserDto> userDtoList = getAllUsers();
        for (UserDto userDto : userDtoList) {
            if (userDto.getLogin().equals(login)) {
                return Optional.of(userDto);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<UserDto> getAllUsers() {
        UserDao userDao = new UserDaoStaticImpl();
        List<User> userList = userDao.getAllUsers();
        UserToUserDtoMapper mapper = new UserToUserDtoMapperImpl();
        List<UserDto> userDtoList = new ArrayList<>();
        userList.forEach( (u) -> userDtoList.add(mapper.from(u)));
        return userDtoList;
    }
}
