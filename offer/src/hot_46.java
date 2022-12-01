import java.util.ArrayList;
import java.util.List;

public class hot_46 {
    static class Solution {
        /**
         * 求全排列
         *
         * @param nums
         * @return
         */
        private List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            List<Integer> level = new ArrayList<>();
            boolean[] vis = new boolean[nums.length];
            dfs(nums, 0, vis, level);
            return ans;
        }

        private void dfs(int[] nums, int cur, boolean[] vis, List<Integer> list) {
            if (cur == nums.length) {
                ans.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (vis[i]) continue;
                vis[i] = true;
                list.add(nums[i]);
                dfs(nums, cur + 1, vis, list);
                list.remove(list.size() - 1);
                vis[i] = false;
            }
        }
    }
}
