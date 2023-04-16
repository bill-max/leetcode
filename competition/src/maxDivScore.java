import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class maxDivScore {
    static class Solution {
        public int maxDivScore(int[] nums, int[] divisors) {
            int n = nums.length;
            int score = 0;
            int ans = divisors[0];
//            Arrays.sort(nums);
            for (int d : divisors) {
                int t = 0;
                for (int num : nums) {
                    if ((num % d) == 0) {
                        t++;
                    }
                }
                if (t>score) {
                    score = t;
                    ans = d;
                } else if (t == score && d < ans) {
                    ans = d;
                }
            }
            return ans;
        }

    }
}
