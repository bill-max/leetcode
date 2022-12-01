import java.util.*;

public class hot_39 {
    static class Solution {
        /**
         * 回溯 + 剪枝
         */
        private List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Deque<Integer> level = new LinkedList<>();
            Arrays.sort(candidates);
            dfs(candidates,0, level, target);
            return ans;
        }

        private void dfs(int[] nums, int begin, Deque<Integer> list, int target) {
            if (target < 0) return;
            if (target == 0) ans.add(new ArrayList<>(list));
            for (int i = begin; i < nums.length; i++) {
                int num = nums[i];
                if (num <= target) {
                    list.add(num);
                    dfs(nums, i, list, target - num);
                    list.removeLast();
                }
            }
        }
    }
}
