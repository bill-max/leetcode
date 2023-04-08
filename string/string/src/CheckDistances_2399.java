import java.util.HashMap;
import java.util.Map;

public class CheckDistances_2399 {
    static class Solution {
        public boolean checkDistances(String s, int[] distance) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (!map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), i);
                } else {
                    map.put(s.charAt(i), i - map.get(s.charAt(i)) - 1);
                }
            }

            for (int i = 0; i < distance.length; i++) {
                char ch = (char) ('a' + i);
                if (map.containsKey(ch)&&!map.get(ch).equals(distance[i])) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.print(new Solution().checkDistances("abaccb",new int[]{1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
    }
}
