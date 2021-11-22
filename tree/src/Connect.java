import java.util.LinkedList;
import java.util.Queue;

public class Connect {
    //层序遍历
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                Node node= queue.poll();
                //链接
                if (i < currentSize-1 ) {
                    node.next = queue.peek();
                }
                //如果当前结点存在孩子，将左右孩子依次入队
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}
