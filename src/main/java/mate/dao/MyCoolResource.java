package mate.dao;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyCoolResource implements Closeable {
    private List<String> stringList;

    private MyCoolResource(List<String> stringList) {
        this.stringList = stringList;
    }

    public static MyCoolResource openResource() {
        return new MyCoolResource(new ArrayList<>());
    }

    public void write(String string) {
        stringList.add(string);
    }

    @Override
    public void close() {
        stringList.forEach(System.out::println);
        stringList = null;
    }

    public String getStringList() {
        return String.join("\n", stringList);
    }
}
