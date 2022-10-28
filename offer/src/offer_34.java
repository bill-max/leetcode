import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class offer_34 {
    static class Solution {

        /**
         * **回溯法   经典题型**
         * @param root
         * @param target
         * @return
         */
        public List<List<Integer>> pathSum(TreeNode root, int target) {
            List<List<Integer>> ans = new LinkedList<>();
            if (root == null) return ans;
            Deque<Integer> level = new LinkedList<>();
            dfs(ans, level, root, target);
            return ans;
        }

        private void dfs(List<List<Integer>> ans, Deque<Integer> level, TreeNode root, int target) {
            if (root == null) return;
            target = target - root.val;
            level.offerLast(root.val);
            if (target == 0 && root.right == null && root.left == null) {
                ans.add(new LinkedList<>(level));
            }
            dfs(ans, level, root.left, target);
            dfs(ans, level, root.right, target);
            level.removeLast();
        }


    }
}
