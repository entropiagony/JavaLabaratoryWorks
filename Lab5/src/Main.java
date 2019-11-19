import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        FileManager fileManager = new FileManager();
        TagCollector tagCollector = new TagCollector();
        StringSearcher stringSearcher = new StringSearcher();

        try {
            fileManager.readFile("index.html");
        } catch (IOException e) {
            e.printStackTrace();
        }

        String input1 = fileManager.getFileStr();

        try {
            fileManager.readFile("input2.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String input2 = fileManager.getFileStr();

        tagCollector.collectTags(input1);

        try {
            fileManager.saveFile(tagCollector.getTagString(), "output1.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        input1 = input1.replaceAll("\\<[^>]*>", "");
        stringSearcher.searchContent(input1, input2);

        try {
            fileManager.saveFile(stringSearcher.getResult(), "output2.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fileManager.saveFile(stringSearcher.getNotFoundStrings(), "output3.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}