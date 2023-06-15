public class NumTimesAllBlue_1375 {
    static class Solution {
        public int numTimesAllBlue(int[] flips) {
            long sum = 0;
            int ans = 0;
            for (int i = 0; i < flips.length; i++) {
                sum += flips[i];
                if (sum == (long) (i + 2) * (i + 1) / 2) ans++;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numTimesAllBlue(new int[]{1, 8, 3, 4, 9, 6, 7, 2, 5, 10}));
    }
}
