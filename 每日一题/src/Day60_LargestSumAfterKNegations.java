import java.util.Arrays;

public class Day60_LargestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int min=Integer.MAX_VALUE;
        int sum=0;
        //排序，优先处理负数
        Arrays.sort(nums);
        for (int num : nums) {
            //如果k>0,num<0，翻转
            if (k != 0 && num < 0) {
                sum += Math.abs(num);
                k--;
            } else {
                sum += num;
            }
            //记录最小的绝对值
            min = Math.min(min, Math.abs(num));
        }
        //如果k有盈余，翻转min，否则直接输出
        if (k % 2 == 0) {
            return sum;
        } else {
            return sum - 2 * min;
        }
    }
}
