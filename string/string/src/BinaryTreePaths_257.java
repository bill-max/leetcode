import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_257 {
    static class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> ans = new ArrayList<>();
            dfs(root, "", ans);
            return ans;
        }

        public void dfs(TreeNode node, String str, List<String> ans) {
            if (node.right == null && node.left == null) {
                ans.add(str.substring(0, str.length() - 2));
                return;
            }
            str += node.val + "->";
            if (node.left != null) {
                dfs(node.left, str, ans);
            }
            if (node.right != null) {
                dfs(node.right, str, ans);
            }

        }
        //使用stringBuilder优化
        private void dfs2(TreeNode root, StringBuilder cur, List<String> paths) {
            if (root == null) return;
            if (root.left == null && root.right == null) {
                paths.add(cur.toString() + root.val);
                return;
            }
            int sz = cur.length();
            cur.append(root.val).append("->");
            dfs2(root.left, cur, paths);
            dfs2(root.right, cur, paths);
            cur.delete(sz, cur.length());
        }
    }

    public static void main(String[] args) {

    }
}
