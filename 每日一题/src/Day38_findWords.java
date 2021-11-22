import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day38_findWords {
    public String[] findWords(String[] words) {
        Set<Character> line1 = new HashSet<>();
        Set<Character> line2 = new HashSet<>();
        Set<Character> line3 = new HashSet<>();

        List<String> res = new ArrayList<>();

        String a = "qwertyuiopQWERTYUIOP";
        String b = "asdfghjklASDFGHJKL";
        String c = "zxcvbnmZXCVBNM";

        for (int i = 0; i < a.length(); i++) {
            line1.add(a.charAt(i));
        }
        for (int i = 0; i < b.length(); i++) {
            line2.add(b.charAt(i));
        }
        for (int i = 0; i < c.length(); i++) {
            line3.add(c.charAt(i));
        }

        for (String str : words) {
            int flag = 0;
            char ch = str.charAt(0);
            if (line1.contains(ch)) {
                for (int j = 0; j < str.length(); j++) {
                    if (!line1.contains(str.charAt(j))) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    res.add(str);
                }
            } else if (line2.contains(ch)) {
                for (int j = 1; j < str.length(); j++) {
                    if (!line2.contains(str.charAt(j))) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    res.add(str);
                }
            } else if (line3.contains(ch)) {
                for (int j = 1; j < str.length(); j++) {
                    if (!line3.contains(str.charAt(j))) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    res.add(str);
                }
            }
        }
        return res.toArray(new String[0]);
    }
}
