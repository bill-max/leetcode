package backtrack;

import java.util.ArrayList;
import java.util.List;

public class subsets {
    static class Solution {
        private final List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            List<Integer> subset = new ArrayList<Integer>();
            ans.add(new ArrayList<>(subset));
            dfs(nums, 0, subset);
            return ans;
        }

        private void dfs(int[] nums, int cur, List<Integer> subset) {
            if (cur == nums.length) return;
            subset.add(nums[cur]);
            ans.add(new ArrayList<>(subset));
            dfs(nums, cur + 1, subset);
            subset.remove(subset.size() - 1);
            dfs(nums, cur + 1,  subset);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subsets(new int[]{0}));
    }
}
