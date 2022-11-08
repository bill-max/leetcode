public class offer_56_1 {
    static class Solution {
        public int[] singleNumbers(int[] nums) {
            int total = 0;
            //得到 x ^ y
            for (int num : nums) {
                total ^= num;
            }
            //按位分组
            int m = 1;
            while ((total & m) == 0) m <<=1;
            int x = 0, y = 0;
            for(int num: nums) {              // 3. 遍历 nums 分组
                if((num & m) != 0) x ^= num;  // 4. 当 num & m != 0
                else y ^= num;                // 4. 当 num & m == 0
            }
            return new int[] {x, y};          // 5. 返回出现一次的数字
        }
    }
}
