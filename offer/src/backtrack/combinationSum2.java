package backtrack;

import java.util.*;

public class combinationSum2 {
    static class Solution {
        private final List<List<Integer>> ans = new ArrayList<>();


        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<Integer> set = new ArrayList<>();
            Arrays.sort(candidates);
            dfs(candidates, target, 0, set);
            return ans;
        }

        private void dfs(int[] candidates, int target, int cur, List<Integer> set) {
            if (target == 0) {
                ans.add(new ArrayList<>(set));
                return;
            }
            for (int i = cur; i < candidates.length; i++) {
                if (target < 0) return;//剪枝
                if (i > cur && candidates[i] == candidates[i - 1]) continue; //剪枝
                set.add(candidates[i]);
                dfs(candidates, target - candidates[i], i + 1, set);
                set.remove(set.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
