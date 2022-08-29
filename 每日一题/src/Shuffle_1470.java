import java.util.Arrays;

public class Shuffle_1470 {
    static class Solution {
        public int[] shuffle(int[] nums, int n) {
            int size = nums.length;
            int[] ans = new int[size];
            int l = 0, r = n ;
            for (int i = 0; i < size; i++) {
                ans[i++] = nums[l];
                ans[i] = nums[r];
                l++;
                r++;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));
    }
}
