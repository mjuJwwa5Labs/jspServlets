package twitter.service;

import twitter.dto.TwitterMessageDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwitterMessageServiceImpl implements TwitterMessageService {

    @Override
    public TwitterMessageDto fingById(Integer id) {
        TwitterMessageDto twitterMessageDto1 = new TwitterMessageDto(1,"first message", "mike");
        TwitterMessageDto twitterMessageDto2 = new TwitterMessageDto(2,"second message", "john");

        Map<Integer, TwitterMessageDto> twitterMap = new HashMap<>();
        twitterMap.put(twitterMessageDto1.getId(),twitterMessageDto1);
        twitterMap.put(twitterMessageDto2.getId(),twitterMessageDto2);

        //todo DAO do getTweetById()
        TwitterMessageDto foundTweet = twitterMap.get(id);
        return foundTweet;
    }

    @Override
    public List<TwitterMessageDto> findAll() {
        TwitterMessageDto twitterMessageDto1 = new TwitterMessageDto(1,"first message", "mike");
        TwitterMessageDto twitterMessageDto2 = new TwitterMessageDto(2,"second message", "john");

        List<TwitterMessageDto> twitterList = new ArrayList<>();
        twitterList.add(twitterMessageDto1);
        twitterList.add(twitterMessageDto2);

        return twitterList;
    }
}
