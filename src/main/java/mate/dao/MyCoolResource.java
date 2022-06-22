package mate.dao;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;

public class MyCoolResource implements Closeable {
    private List<String> stringList;

    private MyCoolResource(List<String> stringList) {
        this.stringList = stringList;
    }

    public static MyCoolResource openResource() {
        System.out.println("Open resource");
        return new MyCoolResource(new ArrayList<>());
    }

    public void write(String string) {
        System.out.println("Write to resource");
        stringList.add(string);
    }

    @Override
    public void close() {
        System.out.println("Close resource");
        stringList.forEach(System.out::println);
        stringList = null;
    }
}
