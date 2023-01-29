
import java.util.*;

class Solution {
    static class res {
        public int longestSquareStreak(int[] nums) {
            Arrays.sort(nums);
            boolean[] vis = new boolean[nums.length];
            int ans = 1;
            for (int i = 0; i < nums.length; i++) {
                int cur = 1;
                long a = (long) nums[i] * nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    if (vis[j]) continue;
                    long b = nums[j];
                    if (a == b) {
                        cur++;
                        a *= a;
                        vis[j] = true;
                    }
                }
                ans = Math.max(cur, ans);
            }
            return ans == 1 ? -1 : ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new res().longestSquareStreak(new int[]{2,4}));
    }
}

