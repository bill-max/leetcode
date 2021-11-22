public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        /**
         *  [10,9,2,5,3,7,101,18]
         *  dp[i]
         *  dp[1]=1
         *  dp[2]::
         *          last
         *          if nums[1]>last ==dp[2]=dp[1]+1
         *          else last=nums[1] ==dp[2]=dp[1]
         *  dp[3]=1 last=2
         *  dp[i]=max(dp[j])+1,其中0≤j<i且num[j]<num[i]
         */
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
    public int lengthOfLIS_useBinarySearch(int[] nums) {
        /**
         * tails[k] 的值代表 长度为 k+1 子序列 的尾部元素值。
         *
         * 最核心的操作是，插入数据替换比他大的最小的那个，保证这个队列始终是在保证最长的情况下，值最小的那个。
         * 在保证了这一点的情况下，新插入的数据如果比最大的大，扩展的话肯定就是当前位置的最长序列。
         * 通过这样的操作，模拟了，在k的位置，挨个跟k-1个数据比较，并且把长度加1
         *
         * 区间中存在 tails[i] > nums[k]tails[i]>nums[k] ：
         *      将第一个满足 tails[i] > nums[k]tails[i]>nums[k] 执行 tails[i] = nums[k]tails[i]=nums[k] ；因为更小的 nums[k]nums[k] 后更可能接一个比它大的数字（前面分析过）。
         * 区间中不存在 tails[i] > nums[k]tails[i]>nums[k] ：
         *      意味着 nums[k]nums[k] 可以接在前面所有长度的子序列之后，因此肯定是接到最长的后面（长度为 resres ），新子序列长度为 res + 1res+1。
         *
         */
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if(res == j) res++;
        }
        new Utils().print(tails);
        return res;
    }
}
