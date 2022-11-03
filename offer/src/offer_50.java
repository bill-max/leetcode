import java.util.*;

public class offer_50 {
    static class Solution {
        public char firstUniqChar(String s) {
            if (s.length() == 0) return ' ';
            Map<Character, Integer> map = new HashMap<>();
            Queue<Character> queue = new LinkedList<>();
            for (char ch : s.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            for (char ch : s.toCharArray()) {
                if (map.get(ch) == 1) {
                    return ch;
                }
            }
            return ' ';
        }

        /**
         * 有序hashMap   按照插入顺序排序
         * @param s
         * @return
         */
        public char firstUniqChar2(String s) {
            Map<Character, Boolean> dic = new LinkedHashMap<>();
            char[] sc = s.toCharArray();
            for(char c : sc)
                dic.put(c, !dic.containsKey(c));
            for(Map.Entry<Character, Boolean> d : dic.entrySet()){
                if(d.getValue()) return d.getKey();
            }
            return ' ';
        }
    }
}
