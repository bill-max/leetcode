import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal_Morris {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        //p1为当前结点
        TreeNode p1 = root, p2 = null;

        while (p1 != null) {
            //p2->左子树
            p2 = p1.left;
            //左子树不为空，找到左子树的最右结点
            if (p2 != null) {
                //找到左子树的最右结点
                while (p2.right != null && p2.right != p1) {
                    p2 = p2.right;
                }
                //该最右结点为空，打印，将其指针指向当前结点p1，打印根结点p1
                if (p2.right == null) {
                    res.add(p1.val);
                    p2.right = p1;
                    p1 = p1.left;
                    continue;
                } else {
                    //如果该结点指向p1，使其指向空
                    p2.right = null;
                }
            } else {
                //如果没有左子树,打印根
                res.add(p1.val);
            }
            //指向右子树
            p1 = p1.right;
        }
        return res;

    }
}
