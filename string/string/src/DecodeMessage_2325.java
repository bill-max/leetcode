import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DecodeMessage_2325 {
    static class Solution {
        public String decodeMessage(String key, String message) {
            Map<Character, Character> map = new HashMap<>();
            Set<Character> set = new HashSet<>();
            int count = 0;
            for (int i = 0; i < 26; i++) {
                char mapKey = (char) ('a' + i);
                while (count < key.length() && (key.charAt(count) == ' ' || set.contains(key.charAt(count)))) {
                    count++;
                }
                if (count < key.length()) {
                    set.add(key.charAt(count));
                    map.put( key.charAt(count),mapKey);
                    count++;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (char mes : message.toCharArray()) {
                if (mes == ' ') {
                    sb.append(mes);
                } else {
                    sb.append(map.get(mes));
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().decodeMessage("eljuxhpwnyrdgtqkviszcfmabo","zwx hnfx lqantp mnoeius ycgk vcnjrdb"));
    }
}
