public class offer_44 {
    static class Solution {
        /**
         * 推出各 digit下的数位数量 count 的计算公式：
         * count=9×start×digit
         *
         * @param n
         * @return
         */
        public int findNthDigit(int n) {
            int digit = 1; //当前数位
            long start = 1; //当前数位的起始值
            long count = 9;
            while (n > count) { // 1.  确定所求数位的 所在数字的位数
                n -= count;
                digit += 1;
                start *= 10;
                count = digit * start * 9;
            }
            long num = start + (n - 1) / digit; // 2. 确定当前位  的数
            return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3. 确定结果
        }
    }
}
