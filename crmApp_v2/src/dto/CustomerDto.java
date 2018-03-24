package dto;

import java.time.LocalDateTime;

public class CustomerDto {

    private Integer id;
    private String firstname;
    private String lastname;
    private String created;
    private String modified;

    public CustomerDto(Integer id, String firstname, String lastname, String created, String modified) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.created = created;
        this.modified = modified;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getCreated() { return created; }

    public String getModified() {
        return modified;
    }
}
