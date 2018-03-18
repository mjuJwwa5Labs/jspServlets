package twitter.validators;

import org.junit.Assert;
import org.junit.Test;
import twitter.dto.TwitterMessageDto;

public class TwitterTitleMessageValidatorTest {

    private Validator validator = new TwitterTitleMessageValidator();

    @Test
    public void shouldTitleCanNotBeNull() {
        TwitterMessageDto twitterMessageDto = new TwitterMessageDto(1,"message","username",null);
        Errors errors = new Errors();
        validator.validate(twitterMessageDto,errors);

        Assert.assertNotNull("Title can't be null", errors.getErrorMessage("title"));
    }
}