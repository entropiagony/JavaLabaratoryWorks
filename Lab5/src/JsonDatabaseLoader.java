import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;


public class JsonDatabaseLoader<T extends IJSONParsable> implements IDatabaseLoader {
    private Supplier<T> supplier;
    private String fileStr;
    private ILogger logger;

    JsonDatabaseLoader(Supplier<T> supplier, ILogger logger) {
        this.supplier = supplier;
        this.logger = logger;
    }

    private void readFile(String fileName) throws IOException {
        logger.log("Started reading JSON file");
        try {
            File buff = new File(fileName);
            FileInputStream fis = new FileInputStream(buff);
            byte[] data = new byte[(int) buff.length()];
            fis.read(data);
            fis.close();
            this.fileStr = new String(data, StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            logger.log("Requested file doesn't exist");
        }
        logger.log("Finished reading JSON file");
    }


    @Override
    public List load(String fileName) {
        List<T> data = new ArrayList<>();
        try {
            this.readFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String lines[] = this.fileStr.split("\\r?\\n");
        logger.log("Started parsing data");
        int i = 1;
        for (; i < lines.length - 1; i++) {
            T model = supplier.get();
            model.initialize(model.fromJson(lines[i]));
            data.add(model);
        }
        logger.log("Parsed " + (i - 1) + " lines");
        return data;
    }

}