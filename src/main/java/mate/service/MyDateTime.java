package mate.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyDateTime {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public MyDateTime() {
    }

    public String getDateTime() {
        return formatter.format(LocalDateTime.now());
    }

}
