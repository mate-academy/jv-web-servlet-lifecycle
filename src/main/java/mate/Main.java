package mate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import mate.dao.MyCoolResource;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        MyCoolResource myCoolResource = new MyCoolResource(list);
        String dateTimeCurrent = new SimpleDateFormat("yyyy-MM-dd/HH:mm:ss")
                .format(Calendar.getInstance().getTime());
        myCoolResource.write(dateTimeCurrent);
        System.out.println(list);
    }
}
