package twitter.validators;

import twitter.dto.TwitterMessageDto;

public class TwitterTitleMessageValidator implements Validator {

    private static int MAX_TITLE_LENGTH = 10;

    @Override
    public void validate(Object object, Errors errors) {
        TwitterMessageDto twitterMessageDto = (TwitterMessageDto) object;
        String title = twitterMessageDto.getTitle();
        if (title==null || title.equals("")) {
            errors.addFieldError("title","Pole tytuł musi być wypełnione");
            return;
        }

        if (title!=null && title.length()>MAX_TITLE_LENGTH) {
            errors.addFieldError("title","Pole tytuł może mieć maksymalnie "+ MAX_TITLE_LENGTH +" znaków");
        }
    }
}
