import java.lang.annotation.Inherited;
import java.util.HashMap;
import java.util.Map;

public class BestHand_2347 {
    static class Solution {
        public String bestHand(int[] ranks, char[] suits) {
            Map<Character, Integer> map = new HashMap<>();
            for (var suit : suits) {
                if (!map.containsKey(suit)) {
                    map.put(suit, 1);
                } else {
                    int count = map.get(suit);
                    if (count == 4) {
                        return "Flush";
                    }
                    map.put(suit, count + 1);
                }
            }
            Map<Integer, Integer> count = new HashMap<>();
            int max = 0;
            for (var num : ranks) {
                int c = count.getOrDefault(num, 0) + 1;
                max = Math.max(max, c);
                count.put(num, c);
            }
            if (max >= 3) {
                return "Three of a Kind";
            } else if (max == 2) {
                return "Pair";
            } else {
                return "High Card";
            }
        }
    }

    public static void main(String[] args) {

    }
}
