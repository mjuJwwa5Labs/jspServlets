package twitter.service;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import twitter.dto.TwitterMessageDto;
import twitter.entities.Message;
import twitter.entities.User;
import twitter.exceptions.DatabaseException;
import twitter.hibernate.dao.TwitterMessageDao;
import twitter.hibernate.dao.TwitterMessageDaoImpl;
import twitter.hibernate.dao.UserDao;
import twitter.hibernate.dao.UserDaoImpl;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TwitterMessageServiceDbImpl implements TwitterMessageService {

    private TwitterMessageDao twitterMessageDao = new TwitterMessageDaoImpl();
    private TwitterMessageDtoMapper dtoMapper = new TwitterMessageDtoMapper();
    private TwitterMessageEntityMapper entityMapper = new TwitterMessageEntityMapper();
    private Logger logger = Logger.getLogger(this.getClass());
    private UserDao userDao = new UserDaoImpl();

    @Override
    public TwitterMessageDto fingById(Integer id) {
        TwitterMessageDto twitterMessageDto = null;
        try {
            twitterMessageDto = dtoMapper.apply(twitterMessageDao.findById(id));
        } catch (DatabaseException e) {
            logger.error("Error while getting message with id " + id);
        }
        return twitterMessageDto;
    }

    @Override
    public List<TwitterMessageDto> findAll() {
        try {
            List<Message> messages = twitterMessageDao.findAll();
            return messages.stream()
                    .map(dtoMapper)
                    .collect(Collectors.toList());
        } catch (DatabaseException e) {
            logger.error("Error while mapping",e);
        }
        return null;
    }

    @Override
    public void save(TwitterMessageDto twitterMessageDto) {
        try {
            Message message = entityMapper.apply(twitterMessageDto);
            twitterMessageDao.save(message);
        } catch (DatabaseException e) {
            logger.error("Problem with saving tweet to database ",e);
        }
    }

    @Override
    public List<TwitterMessageDto> findTweetsByUsernameAndMessage(String username, String message) {
        return null;
    }

    @Override
    public List<TwitterMessageDto> findByUser(String username) {
        return null;
    }

    private class TwitterMessageDtoMapper implements Function<Message, TwitterMessageDto> {
        @Override
        public TwitterMessageDto apply(Message message) {
            User user = message.getUser();
            return new TwitterMessageDto(message.getId(),message.getMessage(),user.getUsername(),message.getTitle());
        }
    }

    private class TwitterMessageEntityMapper implements Function<TwitterMessageDto, Message> {
        @Override
        public Message apply(TwitterMessageDto twitterMessageDto) {
            User user = null;
            try {
                user = userDao.findByUsername(twitterMessageDto.getUsername());
            } catch (DatabaseException e) {
                logger.error("Error while getting user " + twitterMessageDto.getUsername());
            }
            return new Message(twitterMessageDto.getTitle(),twitterMessageDto.getMessage(), user);
        }
    }
}
