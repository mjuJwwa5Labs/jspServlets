package twitter.service;

import twitter.dto.TwitterMessageDto;

import java.util.List;

public interface TwitterMessageService {

    public TwitterMessageDto fingById(Integer id);

    public List<TwitterMessageDto> findAll();

    public List<TwitterMessageDto> findTweetsByUsernameAndMessage(String username, String message);

    public List<TwitterMessageDto> findByUser(String username);

}
