package dto;

import entity.UserGroups;

import java.util.List;

public class UserDto {

    private Integer id;
    private String login;
    private String username;
    private List<UserGroups> userGroup;

    public UserDto(Integer id, String login, String username, List<UserGroups> userGroup) {
        this.id = id;
        this.login = login;
        this.username = username;
        this.userGroup = userGroup;
    }

    public String getLogin() {
        return login;
    }

    public String getUsername() {
        return username;
    }

    public Integer getId() {
        return id;
    }

    public List<UserGroups> getUserGroup() { return userGroup; }
}
