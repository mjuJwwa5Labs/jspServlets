package twitter.hibernate.dao;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import twitter.entities.Message;
import twitter.entities.User;
import twitter.exceptions.DatabaseException;
import twitter.hibernate.HibernateConfigurationLoader;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;


public class TwitterMessageDaoImpl implements TwitterMessageDao{

    private SessionFactory sessionFactory = HibernateConfigurationLoader.getSessionFactory();
    private Logger logger = Logger.getLogger(TwitterMessageDaoImpl.class);

    @Override
    public List<Message> findAll() throws DatabaseException {
        Session session;
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("from Message");
            return (List<Message>)query.list();
        } catch (HibernateException e) {
            throw new DatabaseException("Error while getting all messages: ", e);
        }
    }

    @Override
    public Message findById(Integer id) throws DatabaseException {
        Session session;
        try {
            session = sessionFactory.openSession();
            return session.find(Message.class, id);
        } catch (HibernateException e) {
            throw new DatabaseException("Error while getting message with id " + id, e);
        }
    }

    @Override
    public void save(Message message) throws DatabaseException {
        Session session;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(message);
            transaction.commit();
        } catch (HibernateException e) {
            throw new DatabaseException("Error while saving or updating message " + message.toString(), e);
        }
    }

    @Override
    public void delete(Integer id) throws DatabaseException {
        Session session;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Message message = session.find(Message.class, id);
            session.delete(message);
            transaction.commit();
        } catch (HibernateException e) {
            throw new DatabaseException("Problem while deleting message with id" + id, e);
        }
    }

    @Override
    public List<Message> findByUsernameAndTitleAndMessage(String username, String title, String message) throws DatabaseException {
        Session session;
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Message.class, "message");
            criteria.setFetchMode("message.user",FetchMode.JOIN);
            criteria.createAlias("message.user","user");
            if (StringUtils.isNotBlank(username)) {
                criteria.add(Restrictions.eq("user.username", username)); //bierze encje user i pole username
            }
            if (StringUtils.isNotBlank(title)) {
                criteria.add(Restrictions.eq("title",title));
            }
            if (StringUtils.isNotBlank(message)) {
                criteria.add(Restrictions.eq("message",message));
            }
            return (List<Message>)criteria.list();
        } catch (HibernateException e) {
            throw new DatabaseException("Problem while searching for messages ", e);
        }
    }
}
