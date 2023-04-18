public class MaxAncestorDiff_1026 {
    static class Solution {
        public int maxAncestorDiff(TreeNode root) {
            return visit(root, root.val, root.val);
        }

        public int visit(TreeNode root, int max, int min) {
            if (root == null) {
                return max - min;
            }
            int ans = Math.max(Math.abs(max - root.val), Math.abs(min - root.val));
            int left = visit(root.left, Math.max(max, root.val), Math.min(min, root.val));
            int right = visit(root.right, Math.max(max, root.val), Math.min(min, root.val));
            return Math.max(ans, Math.max(left, right));
        }
    }
}
