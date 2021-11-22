import java.util.HashMap;
import java.util.Map;

public class Day10_IsAnagram {
    public static void main(String[] args) {
        String s = "a";
        String t = "ab";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //key->char;value->count
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            //-1:t中未在s里出现的
            int count = map.getOrDefault(ch, -1);
            //t中每出现一次，次数-1
            if (count != 0) {
                count--;
                map.put(ch, count);
            }
            //次数为0的时候直接移除键值对
            if (count == 0) {
                map.remove(ch);
            }
        }
        return map.isEmpty();
    }
}
