import java.util.Arrays;

public class GetMaximumConsecutive_1798 {
    static class Solution {
        /**
         * 1 4 10 3 1   20
         * sort  ==>  1 1 3 4 10
         * @param coins
         * @return
         */
        public int getMaximumConsecutive(int[] coins) {
            Arrays.sort(coins);
            int curSum = 0;
            for (int coin : coins) {
                if (curSum < coin - 1) {
                    return curSum + 1;
                }
                curSum += coin;
            }
            return curSum + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getMaximumConsecutive(new int[]{1,4,10,3,1}));
    }
}
