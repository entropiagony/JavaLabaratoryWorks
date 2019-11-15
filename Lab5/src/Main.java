import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileLogger logger = new FileLogger("logfile.txt");
        CSVDatabaseLoader<Human> CSVloader = new CSVDatabaseLoader(Human::new, logger);
        Database<Human> database = new Database(CSVloader, logger);

        database.load("data.csv");
        Requests req = new Requests(logger);

        req.sortByState(database.getList());

        try {
            req.saveDatabaseFile(database, "output.txt");
        } catch (IOException e) {
            logger.log("Error in saving database");
            e.printStackTrace();
        }
    }
}
