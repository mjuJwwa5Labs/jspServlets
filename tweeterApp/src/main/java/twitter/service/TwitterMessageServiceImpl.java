package twitter.service;

import twitter.dto.SearchTwitterMessageDto;
import twitter.dto.TwitterMessageDto;
import twitter.exceptions.TwitterAuthorizationException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Deprecated
public class TwitterMessageServiceImpl implements TwitterMessageService {

    @Override
    public TwitterMessageDto fingById(Integer id) {
        TwitterMessageDto twitterMessageDto1 = new TwitterMessageDto(1,"first message", "mike", "pierwszy wpis");
        TwitterMessageDto twitterMessageDto2 = new TwitterMessageDto(2,"second message", "john", "drugi wpis");
        TwitterMessageDto twitterMessageDto3 = new TwitterMessageDto(3,"third message", "mike", "trzeci wpis");

        Map<Integer, TwitterMessageDto> twitterMap = new HashMap<>();
        twitterMap.put(twitterMessageDto1.getId(),twitterMessageDto1);
        twitterMap.put(twitterMessageDto2.getId(),twitterMessageDto2);
        twitterMap.put(twitterMessageDto3.getId(),twitterMessageDto3);

        //todo DAO do getTweetById()
        TwitterMessageDto foundTweet = twitterMap.get(id);
        return foundTweet;
    }

    @Override
    public List<TwitterMessageDto> findAll() {
        TwitterMessageDto twitterMessageDto1 = new TwitterMessageDto(1,"first message", "mike", "pierwszy wpis");
        TwitterMessageDto twitterMessageDto2 = new TwitterMessageDto(2,"second message", "john", "drugi wpis");
        TwitterMessageDto twitterMessageDto3 = new TwitterMessageDto(3,"third message", "mike", "trzeci wpis");

        List<TwitterMessageDto> twitterList = new ArrayList<>();
        twitterList.add(twitterMessageDto1);
        twitterList.add(twitterMessageDto2);
        twitterList.add(twitterMessageDto3);

        return twitterList;
    }

    @Override
    public List<TwitterMessageDto> findTweetsByUsernameAndMessage(String username, String message) {
        List<TwitterMessageDto> allTweets = findAll();
        List<TwitterMessageDto> foundTweets = new ArrayList<>();


        for (TwitterMessageDto singleTweet : allTweets) {
            if ((username!=null && !username.equals("")) || (message!=null && !message.equals(""))) {
                if (((singleTweet.getUsername().toLowerCase()).equals(username.toLowerCase())) ||
                        ((singleTweet.getMessage().toLowerCase()).equals(message.toLowerCase()))) {
                    foundTweets.add(singleTweet);
                }
            }
        }

        return foundTweets;
    }

    @Override
    public List<TwitterMessageDto> findByUser(String username) {
        List<TwitterMessageDto> allTweets = findAll();
        List<TwitterMessageDto> foundTweets = new ArrayList<>();


        for (TwitterMessageDto singleTweet : allTweets) {
            if ((username!=null && !username.equals(""))) {
                if (((singleTweet.getUsername().toLowerCase()).equals(username.toLowerCase()))) {
                    foundTweets.add(singleTweet);
                }
            }
        }

        return foundTweets;
    }

    @Override
    public void save(TwitterMessageDto twitterMessageDto) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public void delete(Integer id, String username) throws TwitterAuthorizationException {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public List<TwitterMessageDto> findTweet(SearchTwitterMessageDto searchTwitterMessageDto) {
        throw new UnsupportedOperationException("not implemented yet");
    }
}
