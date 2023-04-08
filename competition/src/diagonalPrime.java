import java.util.HashSet;
import java.util.Set;

public class diagonalPrime {
    static class Solution {
        Set<Integer> set = new HashSet<>();

        public int diagonalPrime(int[][] nums) {
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[0].length; j++) {
                    if (i == j || j == nums.length - i - 1) {
                        if (nums[i][j] > 1 && check(nums[i][j])) {
                            ans = Math.max(ans, nums[i][j]);
                        }
                    }
                }
            }
            return ans;
        }

        private boolean check(int i) {
            if (set.contains(i)) {
                return true;
            }
            for (int k = 2; k <= Math.sqrt(i); k++) {
                if (i % k == 0) {
                    return false;
                }
            }
            set.add(i);
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().diagonalPrime(new int[][]{{2, 2, 2}, {2, 2, 2}, {2, 2, 2}}));
    }
}
