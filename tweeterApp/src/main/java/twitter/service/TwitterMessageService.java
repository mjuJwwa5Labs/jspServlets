package twitter.service;

import twitter.dto.SearchTwitterMessageDto;
import twitter.dto.TwitterMessageDto;
import twitter.exceptions.TwitterAuthorizationException;

import java.util.List;

public interface TwitterMessageService {

    public TwitterMessageDto fingById(Integer id);

    public List<TwitterMessageDto> findAll();

    public List<TwitterMessageDto> findTweetsByUsernameAndMessage(String username, String message);

    public List<TwitterMessageDto> findTweet(SearchTwitterMessageDto searchTwitterMessageDto);

    public List<TwitterMessageDto> findByUser(String username);

    public void save(TwitterMessageDto twitterMessageDto);

    public void delete(Integer id, String username) throws TwitterAuthorizationException;

}
