import java.util.List;

public class Database {
    private List<Human> data;
    private IDatabaseLoader loader;

    Database(IDatabaseLoader _loader) {
        this.loader = _loader;
    }

    public void load(String fileName) {
        data = loader.load(fileName);
    }

    public void test() {
        System.out.println(data.toString());
    }

    public List<Human> getList() {
        return data;
    }

}
