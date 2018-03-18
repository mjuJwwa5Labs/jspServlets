package twitter.validators;

import twitter.dto.TwitterMessageDto;

public class TwitterMessageValidator implements Validator {

    private static int MAX_MESSAGE_LENGTH = 255;

    @Override
    public void validate(Object object, Errors errors) {
        TwitterMessageDto twitterMessageDto = (TwitterMessageDto) object;
        String message = twitterMessageDto.getMessage();

        if (message==null || message.equals("")) {
            errors.addFieldError("message","Pole wiadomość musi być wypełnione");
            return;
        }

        if (message!=null && message.length()> MAX_MESSAGE_LENGTH) {
            errors.addFieldError("message","Pole wiadomość może mieć maksymalnie "+ MAX_MESSAGE_LENGTH +" znaków");
        }

        if (!message.matches("[a-zA-Z]+")) {
            errors.addFieldError("message","Wiadomość może zawierać tylko litery");
        }
    }
}
