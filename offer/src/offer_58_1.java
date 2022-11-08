import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class offer_58_1 {
    static class Solution {
        public String reverseWords(String s) {
            String[] strings = s.trim().split("\\s+");
            List<String> list = Arrays.asList(strings);
            Collections.reverse(list);
            return String.join(" ", list);
        }
    }

    public static void main(String[] args) {
        new Solution().reverseWords("ex  s  sa ");
    }
}
