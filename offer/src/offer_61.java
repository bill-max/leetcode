import java.util.Arrays;

public class offer_61 {
    static class Solution {
        public boolean isStraight(int[] nums) {
            Arrays.sort(nums);
            int pre = nums[0];
            int count = pre == 0 ? 1 : 0;
            for (int i = 1; i < nums.length; i++) {
                int cur = nums[i];
                if (cur == 0) {
                    count++;
                    continue;
                }
                if (pre == 0) {
                    pre = cur;
                    continue;
                }
                if (cur - pre > 1) {
                    count -= cur - pre - 1;
                    if (count < 0) {
                        return false;
                    }
                } else if (cur - pre < 1) {
                    return false;
                }
                pre = cur;
            }
            return true;
        }

        public boolean isStraight2(int[] nums) {
            int joker = 0;
            Arrays.sort(nums); // 数组排序
            for(int i = 0; i < 4; i++) {
                if(nums[i] == 0) joker++; // 统计大小王数量
                else if(nums[i] == nums[i + 1]) return false; // 若有重复，提前返回 false
            }
            return nums[4] - nums[joker] < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
        }
    }
}
