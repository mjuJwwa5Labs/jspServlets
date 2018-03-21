package service;

import dto.UserDto;
import entity.User;
import mapper.UserMapper;

public class UserToUserDtoMapperImpl implements UserToUserDtoMapper {

    @Override
    public UserDto from(User user) {
        return new UserMapper().from(user);
    }
}
