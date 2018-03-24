package twitter.entities;

import javax.persistence.*;

@Entity
@Table(name = "twitter_messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String message;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Message() {
    }

    public Message(String title, String message, User user) {
        this.title = title;
        this.message = message;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }
}
