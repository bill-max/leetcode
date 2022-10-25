public class offer_26 {
    static class Solution {
        public boolean isSubStructure(TreeNode a, TreeNode b) {
            return (a != null && b != null) && (dfs(a, b) || isSubStructure(a.left, b) || isSubStructure(a.right, b));
        }

        private boolean dfs(TreeNode a, TreeNode b) {
            //检查叶子节点是否结构相同
            if (b == null) return true;
            if (a == null || a.val != b.val) return false;
            //结构相同的可能情况：
            //1. a 左右 = b 左右
            //2. a 左 = b 左    a 右！=null b.r=null
            //3. a 右 = b 右    a 左！=null b.l=null
            return dfs(a.left, b.left) && dfs(a.right, b.right);
        }
    }
}
