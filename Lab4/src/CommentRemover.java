import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommentRemover {
    private String directory;
    private String fileName;
    private File file;
    private String fileStr;

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
        int prevInd = 0;
        StringBuilder clearBuilder = new StringBuilder();
        StringBuilder dirtyBuilder = new StringBuilder(this.fileStr);
        Matcher commentMatcher = Pattern.compile("('[^\\\\']*(\\\\.[^\\\\']*)*')" +
                "|(\"[^\\\\\"]*(\\\\.[^\\\\\"]*)*\")" +
                "|(/\\*[\\s\\S]*?\\*/)|(//.*?\\R)" +
                "|(//.*?$)").matcher(dirtyBuilder.append("\n//"));

        while (commentMatcher.find()) {
            switch (dirtyBuilder.charAt(commentMatcher.start())) {
                case '"':
                case '\'':
                    clearBuilder.append(dirtyBuilder.substring(prevInd, commentMatcher.end()));
                    break;

                case '/':
                    clearBuilder.append(dirtyBuilder.substring(prevInd, commentMatcher.start()));
                    if (dirtyBuilder.length() > commentMatcher.start() + 1 &&
                            dirtyBuilder.charAt(commentMatcher.start() + 1) == '/') {
                        clearBuilder.append("\n");
                    }
                    break;
            }

            prevInd = commentMatcher.end();
        }

        clearBuilder.trimToSize();
        this.fileStr = clearBuilder.toString();
    }

    public void saveCleanFile() throws IOException {
        FileWriter fileWriter = new FileWriter(file, false);
        fileWriter.write(this.fileStr);
        fileWriter.flush();
    }
}
