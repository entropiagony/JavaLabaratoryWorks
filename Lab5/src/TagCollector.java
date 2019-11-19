import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagCollector {

    private Set<String> tagSet;

    public void collectTags(String input) {
        tagSet = new TreeSet<>((String o1, String o2) -> o1.length() - o2.length());
        Pattern pattern = Pattern.compile("<.*?>");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            tagSet.add(matcher.group());
        }
    }

    public String getTagString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String buff : tagSet) {
            stringBuilder.append(buff);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
