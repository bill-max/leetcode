import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Combine_77 {
    /**
     * 回溯
     */
    static class Solution {
        private final List<List<Integer>> ans = new ArrayList<>();
        public List<List<Integer>> combine(int n, int k) {
            dfs(n, k, 1, new ArrayDeque<>());
            return ans;
        }

        private void dfs(int n, int k, int begin, Deque<Integer> path) {
            if (path.size() == k) {
                ans.add(new ArrayList<>(path));
                return;
            }
            for (int i = begin; i <= n; i++) {
                path.addLast(i);
                dfs(n, k, i + 1, path);
                path.removeLast();
            }
        }

    }
}
