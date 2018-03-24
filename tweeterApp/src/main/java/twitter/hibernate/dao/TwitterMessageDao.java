package twitter.hibernate.dao;

import twitter.entities.Message;
import twitter.exceptions.DatabaseException;

import java.util.List;

public interface TwitterMessageDao {

    public List<Message> findAll() throws DatabaseException;

    public Message findById(Integer id) throws DatabaseException;

    public void save(Message message) throws DatabaseException;
}
