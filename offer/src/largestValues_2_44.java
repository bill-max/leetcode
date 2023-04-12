import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class largestValues_2_44 {
    static class Solution {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> result = new ArrayList<Integer>();
            if (root == null) return result;
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                int ans = Integer.MIN_VALUE;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    ans = Math.max(ans, node.val);
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
                result.add(ans);
            }
            return result;
        }
    }
}
