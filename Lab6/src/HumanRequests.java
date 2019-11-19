import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class HumanRequests {
    private ILogger logger;
    HumanRequests(ILogger logger) {
        this.logger = logger;
    }

    public void getAllStates(Database database, String fileName) throws IOException {
        logger.log("Started getting unique states");
        FileWriter fileWriter = new FileWriter(fileName, false);
        TreeSet<Human> uniqueStates = new TreeSet<>(Comparator.comparing(Human::getState));
        uniqueStates.addAll(database.getList());
        uniqueStates.forEach(o1 -> {
            try {
                fileWriter.write(o1.getState() + "\n");
            } catch (IOException e) {
                logger.log("Error in saving unique states");
                e.printStackTrace();
            }
        });
        fileWriter.close();
        logger.log("Finished getting unique states");
    }

    public void sortByState(Database database) {
        Collections.sort(database.getList(), (Comparator.comparing(Human::getState)));
    }

    public void getUsers(Database database, int olderThan, int youngerThan, String fileName) throws IOException {
        logger.log("Started getting list of users between " + olderThan + " and " + youngerThan + " years old");

        FileWriter fileWriter = new FileWriter(fileName, false);

        LocalDate youngLimitDate = LocalDate.now().minusYears(olderThan);
        LocalDate oldLimitDate = LocalDate.now().minusYears(youngerThan);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");

        List<Human> dbList = database.getList();
        for (Human o1 : dbList) {
            LocalDate humanDate = LocalDate.parse(o1.getBirthDate(), dateTimeFormatter);
            if ((humanDate.compareTo(youngLimitDate) <= 0) && (humanDate.compareTo(oldLimitDate) >= 0)) {
                try {
                    fileWriter.write(o1.toString() + "\n");
                } catch (IOException e) {
                    logger.log("Error in saving user");
                    e.printStackTrace();
                }
            }
        }
        fileWriter.flush();
        logger.log("Finished getting list of users between "  + olderThan + " and " + youngerThan + " years old");
    }

    public void saveDatabaseFile(Database d, String fileName) throws IOException {
        logger.log("Started saving database");
        FileWriter fileWriter = new FileWriter(fileName, false);
        d.getList().forEach(o1 -> {
            try {
                fileWriter.write(o1.toString() + "\n");
            } catch (IOException e) {
                logger.log("Error in saving database");
                e.printStackTrace();
            }
        });
        fileWriter.close();
        logger.log("Finished saving database");
    }
}
