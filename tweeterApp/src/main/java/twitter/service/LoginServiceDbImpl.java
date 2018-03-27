package twitter.service;

import org.apache.commons.lang.StringUtils;
import twitter.entities.User;
import twitter.exceptions.DatabaseException;
import twitter.exceptions.TwitterAuthorizationException;
import twitter.hibernate.dao.UserDao;
import twitter.hibernate.dao.UserDaoImpl;

public class LoginServiceDbImpl implements LoginService {

    private UserDao userDao = new UserDaoImpl();
    private HashService hashService = new HashService();

    @Override
    public boolean login(String username, String password) throws TwitterAuthorizationException {
        boolean existingUser = false;
        try {
            if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
                String pwdHash = hashService.apply(password);
                User user = userDao.findByUsernameAndPassword(username, pwdHash);
                String usernameFromDb = user.getUsername();
                String passwordFromDb = user.getPassword();
                if (usernameFromDb.equalsIgnoreCase(username) && passwordFromDb.equals(pwdHash)) {
                    existingUser = true;
                }
            }
        } catch (DatabaseException ex) {
            throw new TwitterAuthorizationException("Wrong user or password", ex);
        }
        return existingUser;
    }
}
