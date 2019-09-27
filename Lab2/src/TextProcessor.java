import java.util.Arrays;

public class TextProcessor {
    private String text;
    String[] buffer;

    public void setText(String a) {
        this.text = a;
    }

    public String getSortedText() {
        return this.text;
    }

    public void excludeSeparators() {
        String separators = "[,. ]";
        buffer = text.split(separators);
    }

    public void sort() {
        Arrays.sort(buffer, String.CASE_INSENSITIVE_ORDER);
        text = Arrays.toString(buffer);
    }
}
