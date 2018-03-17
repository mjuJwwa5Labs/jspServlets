package twitter.dto;

public class TwitterMessageDto {

    private Integer id;

    private String message="";

    private String username="";

    private String title="";

    public TwitterMessageDto() {
    }

    public String getTitle() {
        return title;
    }

    public TwitterMessageDto(Integer id, String message, String username, String title) {
        this.id = id;
        this.message = message;
        this.username = username;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getUsername() {
        return username;
    }
}
