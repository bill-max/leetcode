public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //当前根节点为空，返回false
        if (root == null) {
            return false;
        }
        //将目标值减去根的值
        targetSum -= root.val;
        //如果该结点为叶子结点，且目标值已经减为0，返回true
        if (root.right == null && root.left == null && targetSum==0) {
            return true;
        }
        //遍历左右子树
        return hasPathSum(root.right, targetSum) || hasPathSum(root.left, targetSum);
    }
}
