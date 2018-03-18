package twitter.validators;

import org.junit.Assert;
import org.junit.Test;
import twitter.dto.TwitterMessageDto;

import static org.junit.Assert.*;

public class TwitterMessageValidatorTest {

    private Validator validator = new TwitterMessageValidator();

    @Test
    public void shouldMessageContainOnlyLetters() {
        TwitterMessageDto twitterMessageDto = new TwitterMessageDto(1,"message1","username","title");
        Errors errors = new Errors();
        validator.validate(twitterMessageDto,errors);

        Assert.assertNotNull("Wiadomość może zawierać tylko litery", errors.getErrorMessage("message"));
    }
}