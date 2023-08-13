package backtrack;

import java.util.ArrayList;
import java.util.List;

public class combinationSum {
    static class Solution {
        private final List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<Integer> set = new ArrayList<>();
            dfs(candidates, target, 0, set);
            return ans;
        }

        private void dfs(int[] candidates, int target, int cur, List<Integer> set) {
            if (target == 0) {
                ans.add(new ArrayList<>(set));
                return;
            }
            if (target < 0 || cur >= candidates.length) {
                return;
            }
            set.add(candidates[cur]);
            dfs(candidates, target - candidates[cur], cur, set);
            set.remove(set.size() - 1);
            dfs(candidates, target, cur + 1, set);
        }
    }
}
