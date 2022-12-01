public class hot_114 {
    static class Solution {
        public void flatten(TreeNode root) {
            root = dfs(root);
        }

        public TreeNode dfs(TreeNode node) {
            if (node==null) return null;
            TreeNode head = node;
            TreeNode left = dfs(node.left);
            TreeNode right = dfs(node.right);
            head.right = left;
            head.left = null;
            if (left != null) {
                while (left.right != null) {
                    left = left.right;
                }
                left.right = right;
            } else {
                head.right = right;
            }
            return head;
        }
    }
}
