import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        CSVDatabaseLoader loader = new CSVDatabaseLoader();
        Database database = new Database(loader);
        database.load("data.csv");
        Requests req = new Requests();
        req.sortByState(database.getList());
        try {
            req.saveDatabaseFile(database, "output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
