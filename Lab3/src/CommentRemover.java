import java.io.*;
import java.nio.charset.StandardCharsets;

public class CommentRemover {
    private String directory;
    private String fileName;
    private File file;
    private String fileStr;
    private String[] cleanFile;

    public void setFileName(String name) {
        this.fileName = name;
    }

    public void setDirectory(String dir) {
        this.directory = dir;
    }

    public void readFile() throws IOException {
        try {
            this.file = new File(directory, fileName);
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();
            this.fileStr = new String(data, StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            System.out.println("Error: file not found...");
        }
    }

    public void removeComments() {
        cleanFile = fileStr.split("//.++|(?s)/\\*.*?\\*/");
    }

    public void saveCleanFile() throws IOException {
        FileWriter fileWriter = new FileWriter(file, false);
        for (String s : cleanFile) {
            fileWriter.write(s);
            fileWriter.flush();
        }
    }
}
