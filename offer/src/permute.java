import java.util.ArrayList;
import java.util.List;

public class permute {
    static class Solution {
        private final List<List<Integer>> ans = new ArrayList<>();
        private final List<Integer> set = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            boolean[] vis = new boolean[nums.length];
            dfs(nums, vis, 0);
            return ans;
        }

        private void dfs(int[] nums, boolean[] vis, int cnt) {
            if (cnt == nums.length) {
                ans.add(new ArrayList<>(set));
            }
            for (int i = 0; i < nums.length; i++) {
                if (vis[i]) continue;
                set.add(nums[i]);
                vis[i] = true;
                dfs(nums, vis, cnt + 1);
                set.remove(set.size() - 1);
                vis[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new permute.Solution().permute(new int[]{1, 2, 3}));
    }
}
