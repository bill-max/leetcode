import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class offer_32_1 {
    static class Solution {
        /**
         * 经典层序遍历二叉树
         *
         * @param root 根节点
         * @return result
         */
        public int[] levelOrder(TreeNode root) {
            Queue<TreeNode> q = new ArrayDeque<>();
            if (root == null) {
                return new int[0];
            }
            q.offer(root);
            List<Integer> ans = new ArrayList<>();
            while (!q.isEmpty()) {
                int cur = q.size();
                for (int i = 0; i < cur; i++) {
                    TreeNode node = q.poll();
                    ans.add(node.val);
                    if (node.left != null)
                        q.add(node.left);
                    if (node.right != null)
                        q.add(node.right);
                }
            }
            return ans.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
