import java.util.*;

public class WidthOfBinaryTree_662 {
    static class Solution {
        Map<Integer, Integer> map = new HashMap<>();
        int ans;
        public int widthOfBinaryTree(TreeNode root) {
            dfs(root, 1, 0);
            return ans;
        }
        void dfs(TreeNode root, int u, int depth) {
            if (root == null) return ;
            if (!map.containsKey(depth)) map.put(depth, u);
            ans = Math.max(ans, u - map.get(depth) + 1);
            dfs(root.left, u << 1, depth + 1);
            dfs(root.right, u << 1 | 1, depth + 1);
        }

    }

    public static void main(String[] args) {

    }
}
