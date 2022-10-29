import java.util.ArrayList;
import java.util.List;

public class offer_36 {
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    ;

    static class Solution {
        Node head, pre;

        /**
         * 将 二叉搜索树 转换为 双向循环链表
         * 核心思想：中序遍历
         *
         * @param root
         * @return
         */
        public Node treeToDoublyList(Node root) {
            if (root == null) return null;
            dfs(root);
            //单独处理头结点
            head.left = pre;
            pre.right = head;
            return head;
        }

        public void dfs(Node cur) {
            if (cur == null) return;//结点为空，直接越过
            dfs(cur.left);
            //构建列表
            if (pre!=null) pre.right = cur;//父结点指向左子树
            else head = cur;
            cur.left=pre;//左子树指向父节点
            pre=cur;
            dfs(cur.right);
        }
    }
}
