import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger implements ILogger {
    private FileWriter fileWriter;

    FileLogger(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName);
    }

    @Override
    public void log(String info) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        try{
        fileWriter.write((dtf.format(now) + " " + info + "\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
        fileWriter.flush();} catch (IOException e) {
            e.printStackTrace();
        }
    }
}
