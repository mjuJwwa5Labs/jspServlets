package twitter.hibernate.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import twitter.entities.Message;
import twitter.entities.User;
import twitter.exceptions.DatabaseException;
import twitter.hibernate.HibernateConfigurationLoader;



public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory = HibernateConfigurationLoader.getSessionFactory();
    private Logger logger = Logger.getLogger(TwitterMessageDaoImpl.class);

    @Override
    public User findById(Integer id) throws DatabaseException {
        Session session;
        try {
            session = sessionFactory.openSession();
            return session.find(User.class, id);
        } catch (HibernateException e) {
            throw new DatabaseException("Error while getting user with id " + id, e);
        }
    }

    @Override
    public User findByUsername(String username) throws DatabaseException {
        Session session;
        try {
            session = sessionFactory.openSession();
            Query<User> query = session.createNamedQuery("findUserByUsername",User.class);
            query.setParameter("givenUsername",username);
            return query.getSingleResult();
        } catch (HibernateException e) {
            throw new DatabaseException("Error while getting user with username " + username, e);
        }
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) throws DatabaseException {
        Session session;
        try {
            session = sessionFactory.openSession();
            Query<User> query = session.createQuery(
                    "SELECT u FROM User u WHERE u.username LIKE :givenUsername AND u.password LIKE :givenPassword",User.class);
            query.setParameter("givenUsername",username);
            query.setParameter("givenPassword",password);
            return query.getSingleResult();
        } catch (HibernateException e) {
            throw new DatabaseException("Error while getting user with username " + username, e);
        }
    }
}
