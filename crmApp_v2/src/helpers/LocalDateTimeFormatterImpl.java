package helpers;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeFormatterImpl implements LocalDateTimeFormatter {

    private static DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm:ss");

    @Override
    public String from(LocalDateTime localDateTime) {
        return localDateTime.format(dt);
    }

    @Override
    public LocalDateTime from(String localDateTimeAsString) {
        return LocalDateTime.parse(localDateTimeAsString,dt);
    }
}
