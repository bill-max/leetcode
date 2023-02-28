public class Rob {
    public int rob(int[] nums) {
        /**
         * dp[i]:以当前i为结尾的的nums的可以得到的最大利润
         *
         * {2,7,9,3,1}
         * dp[0]=2
         * dp[1]=7
         * dp[2]=2+9=11
         * dp[3]=7+3=10<dp[2]=11
         * dp[4]=12
         *
         * dp[i]=max(dp[i-1],dp[i-2]+nums[i])
         */
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int[] dp=new int[n];
        dp[0]=nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }
}
