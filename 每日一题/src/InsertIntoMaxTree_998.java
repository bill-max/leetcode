public class InsertIntoMaxTree_998 {
    static class Solution {
        public TreeNode insertIntoMaxTree(TreeNode root, int val) {
            return dfs(root, val);
        }

        public TreeNode dfs(TreeNode node, int val) {
            if (node.val < val) {
                return new TreeNode(val, node, null);
            }
            if (node.right != null) {
                node.right = dfs(node.right, val);
            } else {
                node.right = new TreeNode(val);
            }
            return node;
        }
    }

    public static void main(String[] args) {
    }
}
