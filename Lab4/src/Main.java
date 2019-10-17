import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileManager fM = new FileManager();
        try {
            fM.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}