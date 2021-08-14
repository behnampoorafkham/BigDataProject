package PreProcess;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindWord {
    public List<String> findHashtag(String text) {
        Pattern MY_PATTERN = Pattern.compile("#(\\S+)");
        Matcher mat = MY_PATTERN.matcher(text);
        List<String> strs = new ArrayList<String>();
        while (mat.find()) {
            strs.add(mat.group(1));
        }
        return strs;
    }
}
