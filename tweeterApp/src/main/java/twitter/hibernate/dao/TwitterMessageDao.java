package twitter.hibernate.dao;

import twitter.entities.Message;
import twitter.entities.User;
import twitter.exceptions.DatabaseException;

import java.util.List;

public interface TwitterMessageDao {

    public List<Message> findAll() throws DatabaseException;

    public Message findById(Integer id) throws DatabaseException;

    public void save(Message message) throws DatabaseException;

    public void delete(Integer id) throws DatabaseException;

    public List<Message> findByUsernameAndTitleAndMessage(String username, String title, String message) throws DatabaseException;

}
