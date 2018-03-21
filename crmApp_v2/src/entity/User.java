package entity;

import java.util.List;

public class User {

    private Integer id;
    private String login;
    private String firstname;
    private String lastname;
    private List<UserGroups> userGroups;

    public User(Integer id, String login, String firstname, String lastname, List<UserGroups> userGroups) {
        this.id = id;
        this.login = login;
        this.firstname = firstname;
        this.lastname = lastname;
        this.userGroups = userGroups;
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public List<UserGroups> getUserGroups() {
        return userGroups;
    }
}