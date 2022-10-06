import java.util.HashMap;
import java.util.Map;

public class offer_03 {
    static class Solution {
        public int findRepeatNumber(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                int count = map.getOrDefault(num, 0);
                count++;
                if (count > 1)
                    return num;
                else
                    map.put(num, count);
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}
