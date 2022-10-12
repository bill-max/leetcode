import java.util.HashMap;
import java.util.Map;

public class offer_07 {
    static class Solution {
        private Map<Integer, Integer> indexMap ;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            indexMap = new HashMap<>();
            for (int i = 0; i < preorder.length; i++) {
                indexMap.put(inorder[i], i);
            }
            return help(preorder, inorder, 0, preorder.length - 1, 0, inorder.length);
        }

        public TreeNode help(int[] preorder, int[] inorder, int leftStart, int leftEnd, int rightStart, int rightEnd) {
            if (leftStart > leftEnd) return null;
            //根节点为先序遍历第一个
            int root = leftStart;
            //得到根节点在中序遍历中的位置
            int rootIndex = indexMap.get(preorder[root]);
            TreeNode head = new TreeNode(preorder[root]);

            //找到左子树的节点个数
            int leftNum = rootIndex - rightStart;

            head.left = help(preorder, inorder, leftStart + 1, leftStart + leftNum, rightStart, rootIndex - 1);
            head.right = help(preorder, inorder, leftStart + leftNum + 1, leftEnd, rootIndex + 1, rightEnd);
            return head;
        }
    }

    public static void main(String[] args) {

    }
}
