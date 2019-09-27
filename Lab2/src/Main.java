import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        TextProcessor t = new TextProcessor();
        UserInterface menu = new UserInterface();
        menu.readText(t);
        t.excludeSeparators();
        t.sort();
        menu.output(t);
    }
}