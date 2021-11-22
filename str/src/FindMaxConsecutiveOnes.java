public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans=0;
        int i=0;
        int j=0;
        while (i < nums.length) {
            if (nums[i] == 1) {
                j=i;
                while (j<nums.length&&nums[j] == 1) {
                    j++;
                }
                ans = Math.max(ans, j-i);
                i = j;
            } else {
                i++;
            }
        }
        return ans;
    }
}
