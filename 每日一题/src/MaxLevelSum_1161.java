import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSum_1161 {
    static class Solution {
        public int maxLevelSum(TreeNode root) {
            int Maxsum = Integer.MIN_VALUE;
            int ans = 1, level = 1;
            //层序遍历
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int levelSum = 0;
                int curSize = q.size();
                for (int i = 0; i < curSize; i++) {
                    TreeNode node = q.poll();
                    levelSum += node.val;
                    if (node.left != null) q.add(node.left);
                    if (node.right != null) q.add(node.right);
                }
                if (levelSum > Maxsum) {
                    ans = level;
                    Maxsum = levelSum;
                }
                level++;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(-8);
        TreeNode node3 = new TreeNode(7, node1, node2);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(1, node3, node4);
        int ans = new Solution().maxLevelSum(node5);
        System.out.println(ans);
    }
}
