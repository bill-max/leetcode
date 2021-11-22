import java.util.*;

public class LevelOrder_queue {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        //利用一个队列表征每层
        Queue<TreeNode> queue = new LinkedList<>();
        //根入队
        queue.offer(root);
        while (!queue.isEmpty()) {
            //每层的结果level
            List<Integer> level = new ArrayList<>();
            int currentSize = queue.size();
            //当前队列的大小代表了该层的结点个数
            for (int i = 1; i <= currentSize; i++) {
                //弹出当前结点加入结果
                TreeNode node= queue.poll();
                level.add(node.val);
                //如果当前结点存在孩子，将左右孩子依次入队
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            //一次遍历结束，将当前层的结果加入result
            res.add(level);
        }
        return res;
    }
}
