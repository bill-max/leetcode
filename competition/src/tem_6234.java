
import java.util.*;

public class tem_6234 {

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ans = new ArrayList<>();
        for (Integer num : queries) {
            TreeNode cur = searchNode(root, num);
            if (cur.val < num) {
                ans.add(Arrays.asList(searchMaxMin(cur, num), searchMax(cur, num)));
            } else if (cur.val > num) {
                ans.add(Arrays.asList(searchMin(cur, num), searchMinMax(cur, num)));
            } else {
                ans.add(Arrays.asList(searchMaxMin(cur, num), searchMinMax(cur, num)));
            }
        }
        return ans;
    }

    private int searchMinMax(TreeNode cur, int num) {
        if (cur.left == null) return cur.val;
        TreeNode node = searchNode(cur.left, num);
        int min = node.right == null ? node.val : node.right.val;
        if (min > num) return Math.min(min, cur.val);
        else return cur.val;
    }

    private int searchMaxMin(TreeNode cur, int num) {
        if (cur.right == null) return cur.val;
        TreeNode node = searchNode(cur.right, num);
        int max = node.left == null ? node.val : node.left.val;
        if (max < num) return Math.max(max, cur.val);
        else return cur.val;
    }

    private int searchMin(TreeNode cur, int num) {
        if (cur.left == null) return -1;
        TreeNode node = searchNode(cur.left, num);
        return node.val;
    }

    private int searchMax(TreeNode cur, Integer num) {
        if (cur.right == null) return -1;
        TreeNode node = searchNode(cur.right, num);
        return node.val;
    }

    private TreeNode searchNode(TreeNode root, int num) {
        if (root.val == num) return root;
        if (root.left != null && root.left.val >= num) return searchNode(root.left, num);
        else if (root.right != null && root.right.val <= num) return searchNode(root.right, num);
        else return root;
    }

    public static void main(String[] args) {

    }
}
