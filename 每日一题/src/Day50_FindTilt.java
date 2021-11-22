import java.util.Deque;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

public class Day50_FindTilt {
    int ans=0;
    public int findTilt(TreeNode root) {
        postorder(root);
        return ans;
    }
    public int postorder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sumLeft=postorder(root.left);
        int sumRight=postorder(root.right);
        ans += Math.abs(sumLeft - sumRight);
        return sumLeft + sumRight + root.val;
    }
}
