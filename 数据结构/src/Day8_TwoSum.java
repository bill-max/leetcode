
import java.util.HashMap;
import java.util.Map;

public class Day8_TwoSum {
    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;
        int[] result;
        result = twoSum(nums, target);
        for (int a :
                result) {
            System.out.print(" " + a + " ");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            x = target - nums[i];
            if (map.containsKey(x)) {
                result[0] = (int) map.get(x);
                result[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }
}

