public class IsSameTree_100 {
    static class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            return dfs(p, q);
        }

        public boolean dfs(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            } else if (p == null || q == null) {
                return false;
            }
            return dfs(p.left, q.left) && dfs(p.right, q.right) && p.val == q.val;
        }
    }
}
