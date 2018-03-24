package twitter.validators;

import org.junit.Assert;
import org.junit.Test;
import twitter.dto.TwitterMessageDto;

public class TwitterTitleValidatorTest {

    private Validator validator = new TwitterTitleValidator();

    @Test
    public void shouldTitleCanNotBeNull() {
        TwitterMessageDto twitterMessageDto = new TwitterMessageDto(1,"message","username",null);
        Errors errors = new Errors();
        validator.validate(twitterMessageDto,errors);

        Assert.assertNotNull("Title can't be null", errors.getErrorMessage("title"));
    }

    @Test
    public void shouldTitleNotExceedLengthOf10() {
        TwitterMessageDto twitterMessageDto = new TwitterMessageDto(1,"message","username","12345678901");
        Errors errors = new Errors();
        validator.validate(twitterMessageDto,errors);
        String errorMessage = errors.getErrorMessage("title");
        Assert.assertEquals("Pole tytuł może mieć maksymalnie 10 znaków",errorMessage);
    }

    @Test
    public void shouldTitleCanNotBeEmpty() {
        TwitterMessageDto twitterMessageDto = new TwitterMessageDto(1,"message","username","");
        Errors errors = new Errors();
        validator.validate(twitterMessageDto,errors);

        Assert.assertNotNull("Title can't be null", errors.getErrorMessage("title"));
    }
}