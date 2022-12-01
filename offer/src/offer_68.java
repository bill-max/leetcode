public class offer_68 {
    static class Solution {
        TreeNode node;
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (p.val>q.val) return lowestCommonAncestor(root, q, p);
            node = new TreeNode();
            dfs(root, p, q);
            return node;
        }
        public void dfs(TreeNode root, TreeNode p, TreeNode q) {
            if (p.val <= root.val && q.val >= root.val) {
                node = root;
                return;
            }
            if (root.right != null) {
                dfs(root.right, p, q);
            }
            if (root.left != null) {
                dfs(root.left, p, q);
            }
        }
    }
}
