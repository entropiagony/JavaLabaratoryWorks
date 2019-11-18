import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileLogger logger = new FileLogger("logfile.txt");
        CSVDatabaseLoader<Human> csvloader = new CSVDatabaseLoader(Human::new, logger);
        JsonDatabaseLoader<Human> jsonloader = new JsonDatabaseLoader(Human::new, logger);
        Database<Human> csvdatabase = new Database(csvloader, logger);
        Database<Human> jsondatabase = new Database<>(jsonloader, logger);

        csvdatabase.load("data.csv");
        jsondatabase.load("data1.json");

        Requests req = new Requests(logger);

        req.sortByState(csvdatabase.getList());
        req.sortByState(jsondatabase.getList());

        try {
            req.saveDatabaseFile(csvdatabase, "output.txt");
        } catch (IOException e) {
            logger.log("Error in saving database");
            e.printStackTrace();
        }

        try {
            req.saveDatabaseFile(jsondatabase, "output1.txt");
        } catch (IOException e) {
            logger.log("Error in saving database");
            e.printStackTrace();
        }

    }
}
