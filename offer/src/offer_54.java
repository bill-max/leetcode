import java.util.PriorityQueue;
import java.util.Queue;

public class offer_54 {
    static class Solution {
        /**
         * 二叉搜索树的  top k  问题
         * 小根堆
         * @param root
         * @param k
         * @return
         */
        private Queue<Integer> heap;
        public int kthLargest(TreeNode root, int k) {
            heap = new PriorityQueue<>(k);
            dfs(root, k);
            return heap.peek();
        }
        public void dfs(TreeNode node,int k) {
            if (node == null) {
                return;
            }
            if (heap.size() < k || heap.peek() < node.val) {
                heap.add(node.val);
            }
            if (heap.size() > k) {
                heap.poll();
            }
            dfs(node.right, k);
            dfs(node.left, k);
        }
    }
    static class Solution2 {
        int res, k;

        /**
         * 递归
         * @param root
         * @param k
         * @return
         */
        public int kthLargest(TreeNode root, int k) {
            this.k = k;
            dfs(root);
            return res;
        }
        void dfs(TreeNode root) {
            if(root == null) return;
            dfs(root.right);
            if(k == 0) return;
            if(--k == 0) res = root.val;
            dfs(root.left);
        }
    }
}
