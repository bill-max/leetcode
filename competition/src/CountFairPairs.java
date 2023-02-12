import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountFairPairs {
    static class Solution {
        //0,1,4,4,5,7     3   6

        public long countFairPairs(int[] nums, int lower, int upper) {
            long res = 0L;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 1; i++) {
                int min = lower - nums[i];
                int max = upper - nums[i];
                int start = bs1(nums, i + 1, nums.length - 1, min);
                int end = bs2(nums, i + 1, nums.length - 1, max);
                res += (end - start + 1);

            }
            return res;
        }

        private int bs1(int[] nums, int i, int j, int flag) {
            while (i <= j) {
                int t = (i + j) / 2;
                if (nums[t] < flag) i = t + 1;
                else j = t - 1;
            }
            return i;
        }

        public int bs2(int[] nums, int i, int j, int flag) {  //找上界
            while (i <= j) {
                int t = (i + j) / 2;
                if (nums[t] > flag) j = t - 1;
                else i = t + 1;
            }
            return j;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countFairPairs(new int[]{0, 1, 7, 4, 4, 5}, 3, 6));
    }
}
