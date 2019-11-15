import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class CSVDatabaseLoader<T extends IType> implements IDatabaseLoader {

    private Supplier<T> supplier;
    private String fileStr;
    private ILogger logger;

    CSVDatabaseLoader(Supplier<T> supplier, ILogger logger) {
        this.supplier = supplier;
        this.logger = logger;
    }

    private void readFile(String fileName) throws IOException {
        logger.log("Started reading file");
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
        logger.log("Finished reading file");
    }

    @Override
    public List<T> load(String fileName) {
        List<T> data = new ArrayList<>();
        try {
            this.readFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String lines[] = this.fileStr.split("\\r?\\n");
        logger.log("Started parsing data");
        int i = 1;
        for(; i<lines.length; i++){
            T bruh = supplier.get();
            bruh.arrangeString(lines[i]);
            data.add(bruh);
        }
        logger.log("Parsed " + i + " lines");
        return data;
    }
}
