import java.util.HashMap;
import java.util.Map;

public class Day61_CanConstruct {
    /**
     * hashmap
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        //计数
        for (char ch : magazine.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : ransomNote.toCharArray()) {
            if (map.containsKey(ch)) {
                int count = map.get(ch) - 1;
                if (count < 0) {
                    return false;
                } else {
                    map.put(ch, count);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 优化，采用数组
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct1(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if(cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}
