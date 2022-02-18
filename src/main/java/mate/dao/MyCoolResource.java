package mate.dao;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;

public class MyCoolResource implements Closeable {
    private List<String> stringList;

    //навіщо хтось створив конструктор MyCoolResource і зробив його з модифікатором private
    //для того щоб можна було створювати екзепляри цього класу я зміню модифікатор на public
    public MyCoolResource(List<String> stringList) {
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
}
