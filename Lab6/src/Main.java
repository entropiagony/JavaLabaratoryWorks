import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileLogger logger = new FileLogger("logfile.txt");
        CSVDatabaseLoader<Human> csvloader = new CSVDatabaseLoader(Human::new, logger);
        JsonDatabaseLoader<Human> jsonloader = new JsonDatabaseLoader(Human::new, logger);
        Database csvdatabase = new Database(csvloader, logger);
        Database jsondatabase = new Database<>(jsonloader, logger);

        csvdatabase.load("data.csv");
        jsondatabase.load("data1.json");

        HumanRequests req = new HumanRequests(logger);

        req.sortByState(csvdatabase);
        req.sortByState(jsondatabase);

        req.saveDatabaseFile(csvdatabase, "output.txt");
        req.saveDatabaseFile(jsondatabase, "output1.txt");

        req.getAllStates(csvdatabase, "states.txt");
        req.getAllStates(jsondatabase, "states1.txt");

        req.getUsers(csvdatabase, 18, 60, "users.txt");
        req.getUsers(jsondatabase, 18, 60, "users1.txt");
    }
}