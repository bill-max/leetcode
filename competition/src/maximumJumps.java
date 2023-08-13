import java.util.Map;

public class maximumJumps {
    static class Solution {
        /**
         * nums = [1,3,6,4,1,2], target = 2
         * 3
         * 1 4 0 0 0  target=3  3
         * dp[]
         * 1 max(i-1)
         */
        private int ans = 0;

        public int maximumJumps(int[] nums, int target) {
            int[] dp = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (Math.abs(nums[i] - nums[j]) <= target) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            return dp[nums.length - 1] == 0 ? -1 : dp[nums.length - 1];

//            dfs(nums, target, 0, 0);
//            return ans == 0 ? -1 : ans;
        }

        private void dfs(int[] nums, int target, int cur, int path) {
            if (nums.length - cur + path - 1 < ans) return;
            if (cur == nums.length - 1) {
                ans = Math.max(ans, path);
                return;
            }
            for (int i = cur + 1; i < nums.length; i++) {
                if (Math.abs(nums[cur] - nums[i]) <= target) dfs(nums, target, i, path + 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumJumps(new int[]{-308149108, 503242833, 761360378, -932045245, -185603464, -932422772, 620640609, 666799209, 430484655, -63753190, -209809703, -90685979, -579701670, 263173801, 34353574, -671800218, 137384426, 545262861, -269984558, 82314804, 10317282, 653838558, 183707671, -384017201, -392677027, 399451064, -845351771, -269956884, -189370464, -283272580, 286864833, -481610781, -873503232, 587424662, -435309304, 72295544, -726122412, -766031165, -836255989, -502311527, 744146259, 942243102, -747403161, -808441554, -505384943, -553226578, 710813817, 37920092, 981202479}, 757485188));
    }
}
