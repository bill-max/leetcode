public class EvaluateTree_2331 {
    static class Solution {
        public boolean evaluateTree(TreeNode root) {
            return dfs(root);
        }

        private boolean dfs(TreeNode node) {
            if (node.left == null || node.right == null) {
                return node.val == 1;
            }
            boolean left = dfs(node.left);
            boolean right = dfs(node.right);
            if (node.val == 2) {
                return left || right;
            } else {
                return left && right;
            }
        }
    }
}
