import java.util.ArrayList;
import java.util.List;


/**
 * 1 2 3 4
 * 1 3 2 4
 * 1 2 4 3
 * <p>
 * 1 2 3
 * 3 2 1
 * <p>
 * 1 2 3 4
 * 3 2 1 4
 */
public class RecoverTree_99 {
    static class Solution {
        public void recoverTree(TreeNode root) {
            //1 搜索
            List<Integer> list = new ArrayList<>();
            inOrder(root, list);

            //2 检查位置
            int[] swapped = findTwoSwapped(list);
            //3 改
            dfs(root, swapped[0], swapped[1]);
        }

        public void inOrder(TreeNode node, List<Integer> list) {
            if (null == node) return;
            inOrder(node.left, list);
            list.add(node.val);
            inOrder(node.right, list);
        }

        public void dfs(TreeNode node, int pos1, int pos2) {
            if (null == node) return;
            dfs(node.left, pos1, pos2);
            if (node.val == pos1) node.val = pos2;
            else if (node.val == pos2) node.val = pos1;
            dfs(node.right, pos1, pos2);
        }

        public int[] findTwoSwapped(List<Integer> nums) {
            int n = nums.size();
            int index1 = -1, index2 = -1;
            for (int i = 0; i < n - 1; ++i) {
                if (nums.get(i + 1) < nums.get(i)) {
                    index2 = i + 1;
                    if (index1 == -1) {
                        index1 = i;
                    } else {
                        break;
                    }
                }
            }
            int x = nums.get(index1), y = nums.get(index2);
            return new int[]{x, y};
        }
    }

    public static void main(String[] args) {
/*        TreeNode node4 = new TreeNode(2);
        TreeNode node3 = new TreeNode(4, node4, null);
        TreeNode node2 = new TreeNode(1);
        TreeNode node1 = new TreeNode(3, node2, node3);*/
        TreeNode node3 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3, null, node3);
        TreeNode node1 = new TreeNode(1, node2, null);
        System.out.println(new InorderTraversal().inorderTraversal(node1));

        new Solution().recoverTree(node1);

        System.out.println(new InorderTraversal().inorderTraversal(node1));
    }
}
