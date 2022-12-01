public class offer_68_2 {
    static class Solution {
        /**
         * 最近公共祖先问题
         * 只能有三种情况
         * 1. p q 在异侧
         * 2. p q 都在左子树
         * 3. p q 都在右子树
         * @param root
         * @param p
         * @param q
         * @return
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;
            if (root.val == p.val || root.val == q.val) return root;//返回先找到的
            TreeNode left = lowestCommonAncestor(root.left, p, q);//遍历左子树，看是否存在
            TreeNode right = lowestCommonAncestor(root.right, p, q);//遍历右子树，看是否存在
            if (left==null) return right;//都在右子树
            else if (right==null) return left;//都在左子树
            else return root;//在异侧
        }
    }
}
