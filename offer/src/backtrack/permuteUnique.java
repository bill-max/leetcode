package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permuteUnique {
    static class Solution {
        private final List<List<Integer>> ans = new ArrayList<>();
        private final List<Integer> set = new ArrayList<>();

        public List<List<Integer>> permuteUnique(int[] nums) {
            boolean[] vis = new boolean[nums.length];
            Arrays.sort(nums);
            dfs(nums, vis, 0);
            return ans;
        }

        private void dfs(int[] nums, boolean[] vis, int cnt) {
            if (cnt == nums.length) {
                ans.add(new ArrayList<>(set));
            }
            for (int i = 0; i < nums.length; i++) {
                if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) continue;
                set.add(nums[i]);
                vis[i] = true;
                dfs(nums, vis, cnt + 1);
                set.remove(set.size() - 1);
                vis[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().permuteUnique(new int[]{1, 1, 2}));
    }
}
