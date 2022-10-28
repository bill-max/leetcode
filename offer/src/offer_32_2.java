import java.util.*;

public class offer_32_2 {
    static class Solution {
        /**
         * 简单题 层序遍历
         * @param root
         * @return
         */
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int curSize = queue.size();
                List<Integer> level = new ArrayList<>();
                for (int i = 0; i < curSize; i++) {
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    if (node.left!=null) queue.offer(node.left);
                    if (node.right!=null) queue.offer(node.right);
                }
                ans.add(level);
            }
            return ans;
        }
    }
}
