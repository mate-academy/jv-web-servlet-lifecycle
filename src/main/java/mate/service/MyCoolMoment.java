package mate.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class MyCoolMoment {
    private final DateTimeFormatter formatter
            = DateTimeFormatter.ofPattern("yyyy-MMMM-dd HH:mm:ss", Locale.US);

    public MyCoolMoment() {
    }

    public String getFormatter() {
        return formatter.format(LocalDateTime.now());
    }
}
