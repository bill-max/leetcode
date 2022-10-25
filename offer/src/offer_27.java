
public class offer_27 {
    static class Solution {
        public TreeNode mirrorTree(TreeNode root) {
            dfs(root);
            return root;
        }

        private void dfs(TreeNode node) {
            if (node == null) {
                return;
            }
            reverse(node);
            dfs(node.left);
            dfs(node.right);
        }

        private void reverse(TreeNode node) {
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }
}
