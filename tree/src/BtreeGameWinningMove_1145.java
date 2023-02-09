public class BtreeGameWinningMove_1145 {
    static class Solution {
        /*
             1
            / \
           2  3
             / \
            4  5
         */
        private int x;
        private int leftTotal, rightTotal;
        public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
            this.x = x;
            dfs(root);
            return Math.max(n - leftTotal - rightTotal - 1, Math.max(rightTotal, leftTotal)) * 2 > n;
        }
        public int dfs(TreeNode root) {
            if (root==null) return 0;
            int left = dfs(root.left);
            int right = dfs(root.right);
            if (root.val == x) {
                leftTotal = left;
                rightTotal = right;
            }
            return left + right + 1;
        }
    }

    public static void main(String[] args) {

    }
}
