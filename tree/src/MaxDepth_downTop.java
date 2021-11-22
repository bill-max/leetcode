public class MaxDepth_downTop {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //叶子结点深度为1
        int left_depth = maxDepth(root.left);
        int right_depth = maxDepth(root.right);
        //根的结点深度为叶子结点深度最大的一个+1
        return (left_depth>right_depth?left_depth:right_depth)+1;
    }
}
