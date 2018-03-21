package mapper;

import dto.UserDto;
import entity.User;

public class UserMapper {

    public UserDto from (User user) {
        return new UserDto(user.getId(),user.getLogin(),user.getLastname());
    }
}
