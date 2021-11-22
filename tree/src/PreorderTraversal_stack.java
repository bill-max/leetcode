import java.util.*;

public class PreorderTraversal_stack {
    public List<Integer> preorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                //打印根
                res.add(node.val);
                //把根压栈
                stack.push(node);
                //进入左子树
                node = node.left;
            }
            //弹出已经打印的根和左
            node = stack.pop();
            //进入右子树
            node = node.right;
        }
        return res;
    }
}
