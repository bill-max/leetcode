import java.util.*;

public class PrintTree_655 {
    static class Solution {
        public List<List<String>> printTree(TreeNode root) {
            int height = calDepth(root);
            int m = height + 1;
            int n = (1 << (height + 1)) - 1;
            List<List<String>> res = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                List<String> row = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    row.add("");
                }
                res.add(row);
            }
            dfs(res, root, 0, (n - 1) / 2, height);
            return res;
        }

        public int calDepth(TreeNode root) {
            int h = 0;
            if (root.left != null) {
                h = Math.max(h, calDepth(root.left) + 1);
            }
            if (root.right != null) {
                h = Math.max(h, calDepth(root.right) + 1);
            }
            return h;
        }

        public void dfs(List<List<String>> res, TreeNode root, int r, int c, int height) {
            res.get(r).set(c, Integer.toString(root.val));
            if (root.left != null) {
                dfs(res, root.left, r + 1, c - (1 << (height - r - 1)), height);
            }
            if (root.right != null) {
                dfs(res, root.right, r + 1, c + (1 << (height - r - 1)), height);
            }
        }
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2,node1,null);
        TreeNode node3 = new TreeNode(3,node2,null);

    }
}
