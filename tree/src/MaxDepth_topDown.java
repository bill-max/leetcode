public class MaxDepth_topDown {
    private int ans=0;
    public int maxDepth(TreeNode root) {
        max(root, 1);
        return ans;
    }

    public void max(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        //更新深度；
        if (root.right == null && root.left == null) {
            ans = ans > depth ? ans: depth;
        }
        max(root.left, depth + 1);
        max(root.right, depth + 1);
    }
}
