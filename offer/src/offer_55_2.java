public class offer_55_2 {
    static class Solution {
        private boolean flag = false;

        /**
         * 后序遍历  +  剪枝
         *
         * @param root
         * @return
         */
        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;
            dfs(root, 1);
            return !flag;
        }

        public int dfs(TreeNode node, int k) {
            if (node == null || flag) {
                return k;
            }
            int deepL = dfs(node.left, k + 1);
            int deepR = dfs(node.right, k + 1);
            flag |= Math.abs(deepL - deepR) > 1;
            return Math.max(deepL, deepR);
        }
    }

    static class Solution2 {
        /**
         * 后序遍历 + 剪枝
         *
         * @param root
         * @return
         */
        public boolean isBalanced(TreeNode root) {
            return recur(root) != -1;
        }

        private int recur(TreeNode root) {
            if (root == null) return 0;
            int left = recur(root.left);
            if (left == -1) return -1;
            int right = recur(root.right);
            if (right == -1) return -1;
            return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
        }
    }

}
