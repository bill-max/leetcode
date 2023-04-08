import java.math.BigInteger;

public class FindTheArrayConcVal {
    static class Solution {
        public long findTheArrayConcVal(int[] nums) {
            long ans = 0;
            int i = 0, j = nums.length - 1;
            while (i < j) {
                ans += Integer.parseInt(nums[i] + Integer.toString(nums[j]));
                i++;
                j--;
            }
            if (i == j) {
                ans += nums[i];
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int n = 10;
//        System.out.println(new Solution().findTheArrayConcVal(new int[]{1}));
        BigInteger b = BigInteger.valueOf(2);
        BigInteger bigInteger = b.modPow(BigInteger.valueOf(n), BigInteger.valueOf(100000007)).subtract(BigInteger.TWO);
    }

}
