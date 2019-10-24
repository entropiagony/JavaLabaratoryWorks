import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileManager {

    private Scanner in;
    private String fileStr;

    FileManager() {
        in = new Scanner((System.in));
    }

    public void readFile(String fileName) throws IOException {
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

    public String getFileStr() {
        return this.fileStr;
    }

    public void saveFile(String fileStr, String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName, false);
        fileWriter.write(fileStr);
        fileWriter.flush();
    }
}
