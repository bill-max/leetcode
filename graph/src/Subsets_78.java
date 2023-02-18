import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Subsets_78 {
    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>());
            for (int i = 1; i <= nums.length; i++) {
                Deque<Integer> deque = new ArrayDeque<>();
                dfs(i, 0, deque, ans, nums);
            }
            return ans;
        }

        private void dfs(int len, int cur, Deque<Integer> path, List<List<Integer>> ans, int[] nums) {
            if (path.size() == len) {
                ans.add(new ArrayList<>(path));
                return;
            }
            for (int i = cur; i < nums.length; i++) {
                path.addLast(nums[i]);
                dfs(len, i + 1, path, ans, nums);
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subsets(new int[]{1,2,3}));
    }
}
