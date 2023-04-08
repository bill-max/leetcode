public class MergeTrees_617 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static class Solution {
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root2 == null) return root1;
            dfs(root1, root2);
            return root2;
        }

        public void dfs(TreeNode node1, TreeNode node2) {
            if (node2==null || node1 == null) {
                return;
            }
            node2.val += node1.val;
            if (node2.left == null) {
                node2.left = node1.left;
            } else {
                dfs(node1.left, node2.left);
            }
            if (node2.right == null) {
                node2.right = node1.right;
            } else {
                dfs(node1.right, node2.right);
            }
        }
    }

}
