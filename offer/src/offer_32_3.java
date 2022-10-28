import java.util.*;

public class offer_32_3 {
    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            Queue<TreeNode> queue = new ArrayDeque<>();
            int curLevel = 1;
            queue.add(root);
            while (!queue.isEmpty()) {
                int curSize = queue.size();
                List<Integer> level = new ArrayList<>();
                for (int i = 0; i < curSize; i++) {
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
                if (curLevel % 2 == 0)
                    Collections.reverse(level);
                ans.add(level);
                curLevel++;
            }
            return ans;
        }
    }
}
