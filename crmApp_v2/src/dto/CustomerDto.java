package dto;

import java.time.LocalDateTime;

public class CustomerDto {

    private Integer id;
    private String firstname;
    private String lastname;
    private LocalDateTime created;
    private LocalDateTime modified;

    public CustomerDto(Integer id, String firstname, String lastname, LocalDateTime created, LocalDateTime modified) {
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

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getModified() {
        return modified;
    }
}
