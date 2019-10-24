import java.util.Arrays;
import java.util.regex.Pattern;

public class StringSearcher {
    private String result;
    private String notFound;

    public void searchContent(String str, String input) {
        input = input.replaceAll(";", " ");
        String[] desiredStrings = input.split("[\\n\\s;]+");
        String[] searchedStrings = str.split("[\\r\\u0085]");
        result = "";
        notFound = "";
        for (int i = 0; i < desiredStrings.length; i++) {
            int flag = 0;
            for (int j = 0; j < searchedStrings.length; j++) {
                if (Pattern.compile(Pattern.quote(desiredStrings[i]), Pattern.CASE_INSENSITIVE).matcher(searchedStrings[j]).find()) {
                    flag = 1;
                    result = result + desiredStrings[i] + " " + j + "\n";
                    break;
                }
            }
            if (flag == 0) {
                result += desiredStrings[i] + " " + "-1" + "\n";
                notFound += desiredStrings[i] + "\n";
            }
        }
    }

    public String getResult(){
        return result;
    }

    public String getNotFoundStrings(){
        return notFound;
    }
}
