import java.util.Arrays;

public class PivotIndex {
    public int pivotIndex(int[] nums) {
        /*int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum1=0,sum2=0;
            for (int j = 0; j < i; j++) {
                sum1 += nums[j];
            }
            if (i != n - 1) {
                for (int h = i + 1; h < n; h++) {
                    sum2 += nums[h];
                }
            }
            if (sum1 == sum2) {
                return i;
            }
        }
        return -1;*/
        //采用前缀和
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
