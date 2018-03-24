package service;

import dto.UserDto;
import entity.UserGroups;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    private UserService userService;

    @Before
    public void setUp() {
        userService = new UserServiceImpl();
    }

    @Test
    public void shouldGetAllUsers() {
        List<UserDto> userDtoList = userService.getAllUsers();
        Assert.assertNotNull("userDto list can't be null", userDtoList);
        Assert.assertTrue("userDto list should contain at least one element", userDtoList.size()>0);
    }

    @Test
    public void shouldFindUserByLoginWhenExist() {
        List<UserDto> userDtoList = userService.getAllUsers();
        UserDto userDto = userDtoList.get(0);
        String login = userDto.getLogin();

        Optional<UserDto> foundUserDtoOptional = userService.getByLogin(login);
        Assert.assertTrue("Optional should be set as not empty", foundUserDtoOptional.isPresent());
        Assert.assertEquals("Login should be " + login, login, foundUserDtoOptional.get().getLogin());
    }

    @Test
    public void shouldNotFindByLoginWhenDoesNotExist() {
        List<UserDto> userDtoList = userService.getAllUsers();
        UserDto userDto = userDtoList.get(0);
        String login = userDto.getLogin()+ LocalDateTime.now();

        Optional<UserDto> foundUserDtoOptional = userService.getByLogin(login);
        Assert.assertFalse("Optional should be empty", foundUserDtoOptional.isPresent());
    }

    @Test
    public void shouldBeTrueWhenVerifyUserWhoIsInAdminGroup() {
        List<UserDto> userDtoList = userService.getAllUsers();
        UserGroups adminGroup = UserGroups.ADMIN;

        Optional<UserDto> adminUserOptional = userDtoList
                                    .stream()
                                    .filter((uDto) -> uDto.getUserGroup().contains(UserGroups.ADMIN))
                                    .findFirst();

        UserDto adminUser = adminUserOptional.get();
        Assert.assertTrue("Should admin group", userService.isAdminGroup(adminUser));
    }

}