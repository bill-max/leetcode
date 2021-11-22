import java.util.*;

public class Day26_KthSmallest {
    //二叉搜索树
    List<Integer> res = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        help(root);
        Collections.sort(res);
        return res.get(k-1);
    }

    public void help(TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        help(root.left);
        help(root.right);
    }
}
