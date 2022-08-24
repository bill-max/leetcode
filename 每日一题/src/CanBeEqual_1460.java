import java.util.HashMap;
import java.util.Map;

public class CanBeEqual_1460 {
    static class Solution {
        public boolean canBeEqual(int[] target, int[] arr) {
            if (target.length!=arr.length) return false;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : target) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            for (int i : arr) {
                if (!map.containsKey(i)||map.get(i)<=0) return false;
                map.put(i, map.get(i) - 1);
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canBeEqual(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3}));
    }
}
