package mapper;

import dto.UserDto;
import entity.User;

public class UserToUserDtoMapperImpl implements UserToUserDtoMapper {

    @Override
    public UserDto from(User user) {
        return new UserMapper().from(user);
    }
}
