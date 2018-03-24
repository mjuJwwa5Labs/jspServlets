package helpers;

import java.time.LocalDateTime;

public interface LocalDateTimeFormatter {

    public String from(LocalDateTime localDateTime);

    public LocalDateTime from(String localDateTimeAsString);

}
