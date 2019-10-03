import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        UserInterface menu = new UserInterface();
        CommentRemover c = new CommentRemover();
        menu.getFileDir(c);
        menu.getFileName(c);
        c.readFile();
        c.removeComments();
        c.saveCleanFile();
    }
}
