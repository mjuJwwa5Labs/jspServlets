import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Testtest {

    @Test
    public void testest() {
        LocalDateTime localDateTime = LocalDateTime.of(1999,2,10,15,12);
        System.out.println("LocalDateTime: " + localDateTime);

        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm:ss");
        String ldtString = localDateTime.format(dt);
        System.out.println("String: " + ldtString);

        LocalDateTime dtFromString = LocalDateTime.parse(ldtString,dt);
        System.out.println("LDT From String: " + dtFromString);
    }

}
