package mate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyDateTime {

    public MyDateTime() {
    }

    public String getDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return formatter.format(LocalDateTime.now());
    }

}
