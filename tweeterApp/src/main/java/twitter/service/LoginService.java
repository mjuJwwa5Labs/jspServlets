package twitter.service;

import twitter.exceptions.TwitterAuthorizationException;

public interface LoginService {

    public boolean login(String username, String password) throws TwitterAuthorizationException;

}
