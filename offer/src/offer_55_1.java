public class offer_55_1 {
    class Solution {
        private int max=0;
        public int maxDepth(TreeNode root) {
            dfs(root, 1);
            return max;
        }

        private void dfs(TreeNode node, int k) {
            if (node == null) {
                return;
            }
            max = Math.max(k, max);
            dfs(node.left, k + 1);
            dfs(node.right, k + 1);
        }
    }
}
