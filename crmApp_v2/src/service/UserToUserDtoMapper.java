package service;

import dto.UserDto;
import entity.User;

public interface UserToUserDtoMapper {

    public UserDto from (User user);

}
