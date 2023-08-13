package backtrack;

import java.util.ArrayList;
import java.util.List;

public class combine {
    static class Solution {
        private final List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            List<Integer> subset = new ArrayList<>();
            dfs(n, k, subset, 1);
            return ans;
        }

        private void dfs(int n, int k, List<Integer> subset, int i) {
            if (i > n + 1 || subset.size() + (n - i + 1) < k) return;
            if (subset.size() == k) {
                ans.add(new ArrayList<>(subset));
                return;
            }
            subset.add(i);
            dfs(n, k, subset, i + 1);
            subset.remove(subset.size() - 1);
            dfs(n, k, subset, i + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combine(1, 1));
    }
}
