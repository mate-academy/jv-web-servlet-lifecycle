package mate.dao;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;

public class MyCoolResource implements Closeable {
    private List<String> stringList;

    public MyCoolResource(List<String> stringList) {
        this.stringList = stringList;
    }

    public static MyCoolResource openResource() {
        return new MyCoolResource(new ArrayList<>());
    }

    public void write(String string) {
        stringList.add(string);
    }

    public List get() {
        return stringList;
    }

    @Override
    public void close() {
        stringList.forEach(System.out::println);
        stringList = null;
    }
}
