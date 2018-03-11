package twitter.service;

import twitter.dto.TwitterMessageDto;

import java.util.List;

public interface TwitterMessageService {

    public TwitterMessageDto fingById(Integer id);

    public List<TwitterMessageDto> findAll();

}
