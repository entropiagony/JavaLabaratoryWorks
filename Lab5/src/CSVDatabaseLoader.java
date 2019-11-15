import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CSVDatabaseLoader implements IDatabaseLoader {
    private String fileStr;

    private void readFile(String fileName) throws IOException {
        try {
            File buff = new File(fileName);
            FileInputStream fis = new FileInputStream(buff);
            byte[] data = new byte[(int) buff.length()];
            fis.read(data);
            fis.close();
            this.fileStr = new String(data, StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            System.out.println("Error: file not found...");
        }
    }

    @Override
    public List<Human> load(String fileName) {
        List<Human> data = new ArrayList<>();
        try {
            this.readFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String lines[] = this.fileStr.split("\\r?\\n");
        for(int i = 1; i<lines.length; i++){
            Human bruh = new Human(lines[i]);
            data.add(bruh);
        }
        return data;
    }
}
