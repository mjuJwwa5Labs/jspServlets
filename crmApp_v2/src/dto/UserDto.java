package dto;

public class UserDto {

    private Integer id;
    private String login;
    private String username;

    public UserDto(Integer id, String login, String username) {
        this.id = id;
        this.login = login;
        this.username = username;
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
}
