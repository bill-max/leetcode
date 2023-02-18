public class IsGoodArray_1250 {
    static class Solution {
        /**
         * 12,5,7,23     5 和 7     5*3 + 7*(-2) = 1
         */
        public boolean isGoodArray(int[] nums) {
            int divisor = nums[0];
            for (int num : nums) {
                divisor = gcd(divisor, num);
                if (divisor == 1) {
                    break;
                }
            }
            return divisor == 1;
        }

        public int gcd(int num1, int num2) {
            while (num2 != 0) {
                int temp = num1;
                num1 = num2;
                num2 = temp % num2;
            }
            return num1;
        }
    }
}
