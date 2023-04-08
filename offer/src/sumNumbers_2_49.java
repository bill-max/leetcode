import java.util.ArrayList;
import java.util.List;

public class sumNumbers_2_49 {
    class Solution {
        private List<String> ans = new ArrayList<>();

        private int sum = 0;

        public int sumNumbers(TreeNode root) {
            dfs(root, new StringBuilder());
            int res = 0;
            for (String str : ans) {
                res += Integer.parseInt(str);
            }
            return res;
        }

        private void dfs(TreeNode node, StringBuilder sb) {
            sb.append(node.val);
            if (node.left == null && node.right == null) {
                ans.add(sb.toString());
            }
            if (node.left != null) {
                dfs(node.left, sb);
            }
            if (node.right != null) {
                dfs(node.right, sb);
            }
            sb.deleteCharAt(sb.length() - 1);
        }

        private void dfs2(TreeNode node, int num) {
            if (node == null) return;
            num = num * 10 + node.val;
            if (node.left == null && node.right == null) {
                sum += num;
            }
            dfs2(node.left, num);
            dfs2(node.right, num);
        }
    }
}
