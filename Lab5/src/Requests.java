import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Requests {
    public void sortByState(List<Human> list){
        Collections.sort(list, (Comparator.comparing(Human::getState)));
    }

    public void saveDatabaseFile(Database d, String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName, false);
        d.getList().forEach(o1 -> {
            try {
                fileWriter.write(o1.toString());
                fileWriter.write("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        fileWriter.flush();
    }
}
