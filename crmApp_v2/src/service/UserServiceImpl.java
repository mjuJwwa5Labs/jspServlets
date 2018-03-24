package service;

import dao.UserDao;
import dao.UserDaoStaticImpl;
import dto.UserDto;
import entity.User;
import entity.UserGroups;
import mapper.UserToUserDtoMapper;
import mapper.UserToUserDtoMapperImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    @Override
    public Optional<UserDto> getByLogin(String login) {
        List<UserDto> userDtoList = getAllUsers();
        Optional<UserDto> userDto = Optional.empty();
        userDto = userDtoList
                .stream()
                .filter(uDto -> uDto.getLogin().equals(login))
                .findFirst();

        return userDto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        UserDao userDao = new UserDaoStaticImpl();
        List<User> userList = userDao.getAllUsers();
        UserToUserDtoMapper mapper = new UserToUserDtoMapperImpl();
        List<UserDto> userDtoList = new ArrayList<>();
        userList.forEach( (user) -> userDtoList.add(mapper.from(user)));
        return userDtoList;
    }

    @Override
    public boolean isAdminGroup(UserDto userDto) {
        List<UserGroups> userGroups = userDto.getUserGroup();
        return userGroups.stream().anyMatch(u -> u.equals(UserGroups.ADMIN));
    }
}
