//  (?<=\<).+?(?=\>)

import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagCollector {

    private Set<String> tagSet;

    public void collectTags(FileManager fileManager){
        String string = fileManager.getFileStr();
        Pattern pattern = Pattern.compile("(\\[)(.*?)(\\])"); //регулярка которая ищет строку между скобками тэга
        Matcher matcher = pattern.matcher(string);

        tagSet = new TreeSet<>();

        while(matcher.find())
        {
            tagSet.add(matcher.group(2));
        }
    }
}
