import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class offer_33 {
    /**
     * 判断一个数组是否为二叉搜索树的后序遍历结果
     * 二叉搜索树： 中序 遍历 递增数组
     * 后序遍历   ->  左 右 根
     */
    static class Solution {
        /**
         * 递归法
         * 先确定根
         * 从左到右找到大于根结点的数  此时这些数为右子树
         * 核心思想：左子树所有结点小于根  右子树所有结点大于根
         *
         * @param postorder
         * @return
         */
        public boolean verifyPostorder(int[] postorder) {
            return dfs(postorder, 0, postorder.length - 1);
        }

        private boolean dfs(int[] postorder, int cur, int root) {
            if (cur >= root) return true;
            int i = 0;
            while (postorder[i] < postorder[root]) i++;//找到右子树位置
            int rightPos = i;
            while (postorder[i] > postorder[root]) i++;//检查右子树是否满足条件
            return i == root && (dfs(postorder, cur, rightPos - 1) && dfs(postorder, rightPos, root - 1));
        }

        /**
         * 单调栈
         * 核心思想：后序遍历   ->  左 右 根
         * 倒着遍历时，遇到比当前根结点大的，说明是右子树
         * 一旦遇到 递减的数，说明是左子树的结点
         * 这时通过单调栈去寻找它的父节点
         * @param postorder
         * @return
         */
        public boolean verifyPostorder2(int[] postorder) {
            Stack<Integer> stack = new Stack<>();
            int root=Integer.MAX_VALUE;
            for (int i = postorder.length - 1; i >= 0; i--) {
                //当如果前节点小于栈顶元素，说明栈顶元素和当前值构成了倒叙，
                //说明当前节点是前面某个节点的左子节点，我们要找到他的父节点
                while (!stack.isEmpty() && postorder[i] < stack.peek()) {
                    root = stack.pop();
                }
                //只要遇到了某一个左子节点，才会执行上面的代码，才会更
                //新parent的值，否则parent就是一个非常大的值，也就
                //是说如果一直没有遇到左子节点，那么右子节点可以非常大
                if (postorder[i]>root) return false;
                stack.push(postorder[i]);
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().verifyPostorder2(new int[]{1,6,3,2,5}));
    }
}
